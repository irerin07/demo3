package com.example.demo.domain.user;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description user service
 **********************************************************************************************************************/

import com.example.demo.domain.user.query.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserByUserId(String userId){
        return userRepository.findUserById(userId);
    }

}