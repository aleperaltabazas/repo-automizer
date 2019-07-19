package alesaurio.service;

import alesaurio.transfer.inner.RepoDTO;

import java.util.List;
import java.util.Optional;

public class MockCreationService extends RepoCreationService {
    protected RepoDTO createRepo(String name, Optional<String> description, List<String> group) {
        return new RepoDTO(name, "https://someurl.com/repositories/" + name);
    }
}