package com.example.saparauthorization.service.impl;


import com.example.saparauthorization.service.WebClientBuilder;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Service
public class WebClientBuilderImpl implements WebClientBuilder {

    @Override
    public WebClient getRestWebClient(String url) {
        ConnectionProvider connectionProvider = ConnectionProvider.builder("AuthConnectionProvider").build();
        HttpClient httpClient = HttpClient.create(connectionProvider)
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(50))
                        .addHandlerLast(new WriteTimeoutHandler(50)))
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 50 * 1000);

        return wcBuild(url, httpClient);
    }

    public WebClient wcBuild(String url, HttpClient httpClient) {
        return WebClient.builder()
                .baseUrl(url)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs()
                                .maxInMemorySize(18 * 1024 * 1024))
                        .build())
                .build();
    }
}
