package com.despegar.jav.service;

import com.despegar.jav.http.GithubConnector;
import com.despegar.jav.transfer.AbstractMapper;
import com.despegar.jav.transfer.github.CreatedRepoDTO;
import com.despegar.jav.transfer.github.RepoCreationDTO;
import com.despegar.jav.transfer.inner.RepoDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;

public class GithubService extends RepoCreationService {
    @Value("${scm.repo.create.url}")
    private String repoCreation;

    @Value("${scm.repo.create.homepage}")
    private String homepage;

    @Value("${scm.repo.create.description}")
    private String hardcodedDescription;

    @Value("${scm.repo.members.member}")
    private String membersUrl;

    @Value("${scm.owner}")
    private String owner;

    @Autowired
    private GithubConnector connector;

    @Autowired
    private AbstractMapper mapper;

    protected RepoDTO createRepo(String name, Optional<String> description, List<String> members) {
        RepoCreationDTO repoCreationDTO = new RepoCreationDTO(name, description.orElse(hardcodedDescription), true,
                homepage, true);

        String response = connector.post(repoCreation, mapper.toJson(repoCreationDTO));
        CreatedRepoDTO created = mapper.fromJson(response, new TypeReference<CreatedRepoDTO>() {
        });

        addMembers(name, members);

        return new RepoDTO(name, created.getHtmlUrl());
    }

    private void addMembers(String name, List<String> members) {
        members.forEach(member -> {
            String url = membersUrl.replace(":owner", owner)
                    .replace(":repo", name)
                    .replace(":username", member);

            connector.put(url, "");
            waitBeforeNext();
        });
    }

}