package com.despegar.jav.transfer.github;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RepoCreationDTO {
    private String name;
    private String description;

    @JsonProperty("private")
    private Boolean isPrivate;

    private String homepage;

    private Boolean autoInit;

    public RepoCreationDTO() {
    }

    public RepoCreationDTO(String name, String description, Boolean isPrivate, String homepage, Boolean autoInit) {
        this.name = name;
        this.description = description;
        this.isPrivate = isPrivate;
        this.homepage = homepage;
        this.autoInit = autoInit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Boolean getAutoInit() {
        return autoInit;
    }

    public void setAutoInit(Boolean autoInit) {
        this.autoInit = autoInit;
    }
}