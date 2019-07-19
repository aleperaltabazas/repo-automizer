package com.despegar.jav.service;

import com.despegar.jav.service.naming.NamingStrategy;
import com.despegar.jav.transfer.inner.RepoDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public abstract class RepoCreationService {
    public List<RepoDTO> createRepos(String name, Optional<String> description, List<List<String>> groups,
                                     NamingStrategy strategy) {
        return groups.stream()
                .map(group -> {
                    Integer index = groups.indexOf(group);
                    RepoDTO repo = createRepo(strategy.apply(name, index + 1, group), description, group);
                    waitBeforeNext();
                    return repo;
                })
                .collect(Collectors.toList());
    }

    protected abstract RepoDTO createRepo(String name, Optional<String> description, List<String> group);

    protected void waitBeforeNext() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}