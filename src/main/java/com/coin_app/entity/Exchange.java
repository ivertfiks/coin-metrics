package com.coin_app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Exchange {
    @Id
    private String id;

    @JsonProperty("name")
    private String name; // Название обмена

    @JsonProperty("year_established")
    private int yearEstablished; // Год основания

    @JsonProperty("description")
    private String description; // Описание

    @JsonProperty("url")
    private String url; // URL сайта

    @JsonProperty("image")
    private String image; // URL изображения

    @JsonProperty("has_trading_incentive")
    private boolean hasTradingIncentive; // Наличие торговых стимулов

    @JsonProperty("trust_score")
    private int trustScore; // Рейтинг доверия

    @JsonProperty("trust_score_rank")
    private int trustScoreRank; // Ранг рейтинга доверия

    @JsonProperty("trade_volume_24h_btc")
    private double tradeVolume24hBtc; // Объем торгов за 24 часа в BTC

    @JsonProperty("trade_volume_24h_btc_normalized")
    private double tradeVolume24hBtcNormalized; // Нормализованный объем торгов за 24 часа в BTC
}