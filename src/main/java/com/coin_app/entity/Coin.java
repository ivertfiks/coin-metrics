package com.coin_app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
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

    @JsonProperty("market_cap")
    private long marketCapUsd;

    @JsonProperty("fully_diluted_valuation")
    private long fullyDilutedValuationUsd;

    @JsonProperty("total_volume")
    private long totalVolumeUsd;

    @JsonProperty("circulating_supply")
    private long circulatingSupply;

    @JsonProperty("total_supply")
    private long totalSupply;

    @JsonProperty("max_supply")
    private long maxSupply;

    @JsonProperty("high_24h")
    private double highDay;

    @JsonProperty("low_24h")
    private double lowDay;

    @JsonProperty("price_change_24h")
    private double priceChangeDayInCurrency;

    @JsonProperty("price_change_percentage_24h")
    private double priceChangePercentageDayInCurrency;

    @JsonProperty("market_data")
    public void setMarketData(JsonNode marketData) {
        JsonNode currentPriceNode = marketData.get("current_price");
        if (currentPriceNode != null && currentPriceNode.has("usd")) {
            this.currentPrice = currentPriceNode.get("usd").asDouble();
        }

        JsonNode marketCapNode = marketData.get("market_cap");
        if (marketCapNode != null) {
            if (marketCapNode.has("usd")) {
                this.marketCapUsd = marketCapNode.get("usd").asLong();
            }
        }

        JsonNode fullyDilutedValuationNode = marketData.get("fully_diluted_valuation");
        if (fullyDilutedValuationNode != null && fullyDilutedValuationNode.has("usd")) {
            this.fullyDilutedValuationUsd = fullyDilutedValuationNode.get("usd").asLong();
        }

        JsonNode totalVolumeNode = marketData.get("total_volume");
        if (totalVolumeNode != null && totalVolumeNode.has("usd")) {
            this.totalVolumeUsd = totalVolumeNode.get("usd").asLong();
        }


        JsonNode circulatingSupplyNode = marketData.get("circulating_supply");
        if (circulatingSupplyNode != null) {
            this.circulatingSupply = circulatingSupplyNode.asLong();
        }

        JsonNode totalSupplyNode = marketData.get("total_supply");
        if (totalSupplyNode != null) {
            this.totalSupply = totalSupplyNode.asLong();
        }

        JsonNode maxSupplyNode = marketData.get("max_supply");
        if (maxSupplyNode != null) {
            this.maxSupply = maxSupplyNode.asLong();
        }

    }

    public void setImage(Object image) {
        if (image instanceof String) {
            this.image = (String) image;  // Если это строка, сохраняем строку
        } else if (image instanceof JsonNode) {
            JsonNode node = (JsonNode) image;
            this.image = node.has("thumb") ? node.get("thumb").asText() : null;  // Если объект, сохраняем thumb
        }
    }
}