package com.coin_app.controller;

import com.coin_app.client.CoinGeckoApiClient;
import com.coin_app.entity.Coin;
import com.coin_app.service.CoinService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CoinController {

    private final CoinService coinService;
    private final CoinGeckoApiClient coinClient;

    @GetMapping("/market-data")
    public String getCoinMarketData(@RequestParam("currency") String currency) {
        List<Coin> coinData = coinClient.getCoinMarketData(currency);
        return "";
    }


}
