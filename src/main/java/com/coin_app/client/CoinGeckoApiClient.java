package com.coin_app.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class CoinGeckoApiClient {

    private final WebClient webClient;

    @Autowired
    public CoinGeckoApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    @Value("${coin-gecko.api-key}")
    private String apiKey;
    @Value("${coin-gecko.base-url}")
    private String baseUrl;



}
