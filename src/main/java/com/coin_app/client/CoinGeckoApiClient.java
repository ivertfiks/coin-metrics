package com.coin_app.client;

import com.coin_app.client.enums.ApiEndpoints;
import com.coin_app.entity.Coin;
import java.util.List;

import com.coin_app.entity.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class CoinGeckoApiClient {

    private final WebClient restClient;

    @Value("${coin-gecko.api-key}")
    private String apiKey;

    @Value("${coin-gecko.base-url}")
    private String baseUrl;


    public List<Coin> getCoinMarketData(String currency){
        return restClient.get()
            .uri(baseUrl + ApiEndpoints.COIN_MARKET_DATA.getEndpoint()+"?vs_currency="+currency)
//            .uri(baseUrl + COIN_MARKET_DATA + "?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false")
            .header("Content-Type", "application/json")
            .header("x-cg-pro-api-key", apiKey)
            .retrieve()
            .bodyToFlux(Coin.class)
            .collectList()
            .block();
    }

    public Coin getCoinDataById(String id){
        return restClient.get()
                .uri(baseUrl + ApiEndpoints.COIN_MARKET_DATA.getEndpoint()+id)
                .header("Content-Type", "application/json")
                .header("x-cg-pro-api-key", apiKey)
                .retrieve()
                .bodyToFlux(Coin.class)
                .blockFirst();
    }

    public List<Exchange> getExchangesData(){
        return restClient.get()
                .uri(baseUrl + ApiEndpoints.COIN_DATA_BY_ID.getEndpoint())
                .header("Content-Type", "application/json")
                .header("x-cg-pro-api-key", apiKey)
                .retrieve()
                .bodyToFlux(Exchange.class)
                .collectList()
                .block();
    }

}
