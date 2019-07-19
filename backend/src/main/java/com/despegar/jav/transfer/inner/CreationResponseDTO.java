package com.despegar.jav.transfer.inner;

import java.util.List;

public class CreationResponseDTO {
    private Integer statusCode;
    private Integer amountCreated;
    private List<RepoDTO> repositories;

    public CreationResponseDTO(Integer statusCode, Integer amountCreated, List<RepoDTO> repositories) {
        this.statusCode = statusCode;
        this.amountCreated = amountCreated;
        this.repositories = repositories;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getAmountCreated() {
        return amountCreated;
    }

    public void setAmountCreated(Integer amountCreated) {
        this.amountCreated = amountCreated;
    }

    public List<RepoDTO> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<RepoDTO> repositories) {
        this.repositories = repositories;
    }
}