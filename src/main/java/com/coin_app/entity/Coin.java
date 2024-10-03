package com.coin_app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Coin {

    @Id
    private String id;

    private String symbol;

    private String name;

    @JsonProperty("current_price")
    private double currentPrice;

    private String image;

    @JsonProperty("market_cap_rank")
    private int marketCapRank;

    @JsonProperty("high_24h")
    private double highDay;

    @JsonProperty("low_24h")
    private double lowDay;

    @JsonProperty("price_change_24h")
    private double priceChangeDayInCurrency;

    @JsonProperty("price_change_percentage_24h")
    private double priceChangePercentageDayInCurrency;

}