package com.coin_app.service;

import com.coin_app.repository.TradePairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TradePairService {

    private final TradePairRepository tradePairRepository;

}
