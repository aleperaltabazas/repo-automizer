package com.despegar.jav.controller;

import com.despegar.jav.service.RepoCreationService;
import com.despegar.jav.service.naming.NamingStrategy;
import com.despegar.jav.transfer.inner.CreationRequestDTO;
import com.despegar.jav.transfer.inner.CreationResponseDTO;
import com.despegar.jav.transfer.inner.RepoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RepoController {
    @Autowired
    private RepoCreationService service;

    @RequestMapping(method = RequestMethod.POST, path = "/repos")
    @ResponseBody
    public CreationResponseDTO bulkCreate(@RequestBody CreationRequestDTO request,
                                          @RequestParam(required = false, defaultValue = "number") String orderedBy) {
        List<RepoDTO> repos = service.createRepos(request.getRepoName(), request.getDescription(), request.getMembers(),
                NamingStrategy.parse(orderedBy));

        return new CreationResponseDTO(200, repos.size(), repos);
    }
}