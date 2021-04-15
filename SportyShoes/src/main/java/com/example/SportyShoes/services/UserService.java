package com.example.SportyShoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SportyShoes.entities.User;
import com.example.SportyShoes.repositories.UserRepository;



@Service
public class UserService {

        @Autowired
         private UserRepository userRepository;



    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }

}