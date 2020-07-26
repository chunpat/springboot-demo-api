package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.User;
import com.chunpat.fengxiuapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getById(Long id){
        return userRepository.findFirstById(id);
    }
}
