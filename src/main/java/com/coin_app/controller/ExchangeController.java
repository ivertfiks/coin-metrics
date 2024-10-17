package com.coin_app.controller;

import com.coin_app.client.CoinGeckoApiClient;
import com.coin_app.entity.Exchange;
import com.coin_app.service.ExchangeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
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
