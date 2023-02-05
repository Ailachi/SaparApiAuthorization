package com.example.saparauthorization.service;

import org.springframework.web.reactive.function.client.WebClient;

public interface WebClientBuilder {
    WebClient getRestWebClient(String url);
}
