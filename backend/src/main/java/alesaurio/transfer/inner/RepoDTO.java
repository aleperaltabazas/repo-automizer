package alesaurio.transfer.inner;

import java.util.Objects;

public class RepoDTO {
    private String name;
    private String url;

    public RepoDTO(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepoDTO repoDTO = (RepoDTO) o;
        return Objects.equals(name, repoDTO.name) &&
                Objects.equals(url, repoDTO.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }
}