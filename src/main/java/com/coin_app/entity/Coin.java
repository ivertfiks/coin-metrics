package com.coin_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Coin {

    @Id
    private String id;

    private String symbol;
    private double currentPrice;
    private double maxForDay;
    private double minForDay;
    private String image;
    private int marketCapRank;
    private double highDay;
    private double lowDay;
    private double priceChangeDayInCurrency;
    private double priceChangePercentageDayInCurrency;

}
