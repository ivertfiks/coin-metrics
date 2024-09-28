package com.coin_app.controller;


import com.coin_app.service.TradePairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/tradePair")
public class TradePairController {

    private final TradePairService tradePairService;

}
