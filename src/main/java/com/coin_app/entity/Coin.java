package com.coin_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String symbol;
    private double currentPrice;
    private double maxForDay;
    private double minForDay;
}
