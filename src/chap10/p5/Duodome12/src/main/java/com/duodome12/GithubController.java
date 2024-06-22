package com.duodome12;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GithubController {

    private final GithubService githubService;

    private GithubController (GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/external/github/most-starred-repositories")
    public Mono<GithubRepositoryResponse> findMostStarredRepositories() {
        Mono<GithubRepositoryResponse> result = githubService.fetchTopStarredRepositories();
        return result;
    }
}
