package com.coin_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TradePair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Coin base;
    private Coin target;
    private String marketName;
    private double last; // or price, depends on functional of coingecko
    private double volume;
    private int trustScore;
}
