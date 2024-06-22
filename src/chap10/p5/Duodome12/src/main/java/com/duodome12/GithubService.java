package com.duodome12;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GithubService {

    private final WebClient webClient;

    public GithubService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<GithubRepositoryResponse> fetchTopStarredRepositories() {
        return webClient.get()
                .uri("/search/repositories?q=stars:>=10000&sort=stars&order=desc&per_page=10")
                .retrieve()
                .bodyToMono(GithubRepositoryResponse.class);
    }
}
