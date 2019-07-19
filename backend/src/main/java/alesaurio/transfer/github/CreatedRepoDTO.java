package alesaurio.transfer.github;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatedRepoDTO {
    @JsonProperty("html_url")
    private String htmlUrl;

    public CreatedRepoDTO() {
    }

    public CreatedRepoDTO(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}