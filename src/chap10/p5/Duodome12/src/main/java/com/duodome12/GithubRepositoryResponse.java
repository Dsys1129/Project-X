package com.duodome12;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GithubRepositoryResponse {
    @JsonProperty("total_count")
    private int totalCount;
    @JsonProperty("items")
    private List<GithubRepositoryInfo> items;

    @Data
    public static class GithubRepositoryInfo {
        @JsonProperty("id")
        private long id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("full_name")
        private String fullName;
        @JsonProperty("html_url")
        private String htmlUrl;
        @JsonProperty("description")
        private String description;
        @JsonProperty("stargazers_count")
        private long stargazersCount;
        @JsonProperty("watchers_count")
        private long watchersCount;
        @JsonProperty("forks_count")
        private long forksCount;
        @JsonProperty("language")
        private String language;
    }
}
