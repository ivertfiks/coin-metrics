package com.coin_app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.text.DecimalFormat;

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

    private double priceChangePercentage24h;

    private double priceChangePercentage7d;

    private double priceChangePercentage14d;

    private double priceChangePercentage30d;

    private double priceChangePercentage1y;

    @JsonProperty("total_supply")
    private long totalSupply;

    @JsonProperty("high_24h")
    private long highDay;

    @JsonProperty("low_24h")
    private long lowDay;

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

        JsonNode high24hNode = marketData.get("high_24h");
        if (high24hNode != null && high24hNode.has("usd")) {
            this.highDay = high24hNode.get("usd").asLong();
        }

        JsonNode low24hNode = marketData.get("low_24h");
        if (low24hNode != null && low24hNode.has("usd")) {
            this.lowDay = low24hNode.get("usd").asLong();
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

        JsonNode priceChange24hNode = marketData.get("price_change_percentage_24h");
        if (priceChange24hNode != null) {
            this.priceChangePercentage24h = priceChange24hNode.asDouble();
        }

        JsonNode priceChange7dNode = marketData.get("price_change_percentage_7d");
        if (priceChange7dNode != null) {
            this.priceChangePercentage7d = priceChange7dNode.asDouble();
        }

        JsonNode priceChange14dNode = marketData.get("price_change_percentage_14d");
        if (priceChange14dNode != null) {
            this.priceChangePercentage14d = priceChange14dNode.asDouble();
        }

        JsonNode priceChange30dNode = marketData.get("price_change_percentage_30d");
        if (priceChange30dNode != null) {
            this.priceChangePercentage30d = priceChange30dNode.asDouble();
        }

        JsonNode priceChange1yNode = marketData.get("price_change_percentage_1y");
        if (priceChange1yNode != null) {
            this.priceChangePercentage1y = priceChange1yNode.asDouble();
        }
    }

    public void setImage(Object image) {
        if (image instanceof String) {
            this.image = (String) image;
        } else if (image instanceof JsonNode) {
            JsonNode node = (JsonNode) image;
            this.image = node.has("thumb") ? node.get("thumb").asText() : null;
        }
    }

    private String formatWithThousandsSeparator(long value) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(value);
    }

    public String getFormattedMarketCapUsd() {
        return formatWithThousandsSeparator(marketCapUsd);
    }

    public String getFormattedFullyDilutedValuationUsd() {
        return formatWithThousandsSeparator(fullyDilutedValuationUsd);
    }

    public String getFormattedTotalVolumeUsd() {
        return formatWithThousandsSeparator(totalVolumeUsd);
    }

    public String getFormattedCirculatingSupply() {
        return formatWithThousandsSeparator(circulatingSupply);
    }

    public String getFormattedTotalSupply() {
        return formatWithThousandsSeparator(totalSupply);
    }

    public String getFormattedHighDay() {
        return formatWithThousandsSeparator(highDay);
    }

    public String getFormattedLowDay() {
        return formatWithThousandsSeparator(lowDay);
    }
}