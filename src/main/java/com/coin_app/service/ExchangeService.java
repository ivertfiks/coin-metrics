package com.coin_app.service;

import com.coin_app.repository.ExchangeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;

}
