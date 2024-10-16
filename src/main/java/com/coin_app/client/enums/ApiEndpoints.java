package com.coin_app.client.enums;

public enum ApiEndpoints {

    COIN_MARKET_DATA("/coins/markets"),
    COIN_DATA_BY_ID("/coins/"),
    EXCHANGE_DATA("/exchanges");

    private final String endpoints;

    ApiEndpoints(String endpoints) {
        this.endpoints = endpoints;
    }

    public String getEndpoint() {
        return endpoints;
    }


}
