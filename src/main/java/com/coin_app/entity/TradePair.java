package com.coin_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TradePair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Coin base;
    @OneToOne
    private Coin target;
    private String marketName;
    private double last; // or price, depends on functional of coingecko
    private double volume;
    private int trustScore;
}
