package com.coin_app.controller;

import com.coin_app.client.CoinGeckoApiClient;
import com.coin_app.entity.Coin;
import com.coin_app.service.CoinService;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@AllArgsConstructor
public class CoinController {

    private final CoinService coinService;
    private final CoinGeckoApiClient coinClient;

    @GetMapping(value = {"/market-data", "/"})
    public String getCoinMarketData(@RequestParam(value="currency", required = false, defaultValue = "usd") String currency, Model model) {
        List<Coin> coinData = coinClient.getCoinMarketData(currency);
        model.addAttribute("coins", coinData);
        return "coins";
    }

    @GetMapping("/coin-data/{id}")
    public String getCoinDataById(@PathVariable(value = "id") String id, Model model) {
        Coin coinData = coinClient.getCoinDataById(id);
        model.addAttribute("coin", coinData);
        return "crypto_detail";
    }


}
