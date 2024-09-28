package com.coin_app.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class CoinGeckoApiClient {

    private final WebClient webClient;

    @Value("${coin-gecko.api-key}")
    private String apiKey;
    @Value("${coin-gecko.base-url}")
    private String baseUrl;




}
