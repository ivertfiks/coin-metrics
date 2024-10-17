package com.coin_app.service;

import com.coin_app.entity.User;
import com.coin_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User save(User user){
        if(userRepository.findUserByUsername(user.getUsername()) == null && userRepository.findUserByEmail(user.getEmail()) == null){
            return userRepository.save(user);
        }
        if(userRepository.findUserByEmail(user.getEmail()) == userRepository.findUserByUsername(user.getUsername())){
            return userRepository.findUserByUsername(user.getUsername());
        }
        return null;
    }
}
