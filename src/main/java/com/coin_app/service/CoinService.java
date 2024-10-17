package com.coin_app.service;

import com.coin_app.repository.CoinRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoinService {
    private final CoinRepository newsRepository;
}
