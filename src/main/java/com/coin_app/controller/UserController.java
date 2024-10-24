package com.coin_app.controller;

import com.coin_app.entity.User;
import com.coin_app.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@Slf4j
public class UserController {

    private UserService userService;

    public User createUser(@RequestParam String name,
                           @RequestParam String email){
        User user = new User(name, email);
        return userService.save(user);
    }

}
