package com.coin_app.service;

import com.coin_app.repository.TradePairRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TradePairService {

    private final TradePairRepository tradePairRepository;

}
