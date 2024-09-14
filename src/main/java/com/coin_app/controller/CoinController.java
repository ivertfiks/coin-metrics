package com.coin_app.controller;

import com.coin_app.service.CoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
@Slf4j
@RequiredArgsConstructor
public class CoinController {

    private final CoinService coinService;



}
