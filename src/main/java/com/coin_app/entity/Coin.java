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