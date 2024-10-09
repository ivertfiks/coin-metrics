package com.coin_app.controller;

import com.coin_app.client.CoinGeckoApiClient;
import com.coin_app.entity.Coin;
import com.coin_app.entity.Exchange;
import com.coin_app.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ExchangeController {

    private final ExchangeService exchangeService;
    private final CoinGeckoApiClient coinClient;


    @GetMapping("/exchanges-data")
    public String getExchangeData(Model model){
        List<Exchange> exchangesData = coinClient.getExchangesData();
        model.addAttribute("exchanges", exchangesData);
        return "exchanges";
    }

}
