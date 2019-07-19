package alesaurio.transfer.inner;

import java.util.List;
import java.util.Optional;

public class CreationRequestDTO {
    private String repoName;
    private Integer amount;
    private Optional<String> description = Optional.empty();
    private List<List<String>> members;

    public CreationRequestDTO() {
    }

    public CreationRequestDTO(String repoName, Integer amount, String description,
                              List<List<String>> members) {
        this.repoName = repoName;
        this.amount = amount;
        this.description = Optional.ofNullable(description);
        this.members = members;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<List<String>> getMembers() {
        return members;
    }

    public void setMembers(List<List<String>> members) {
        this.members = members;
    }

    public Optional<String> getDescription() {
        return description;
    }

    public void setDescription(Optional<String> description) {
        this.description = description;
    }
}