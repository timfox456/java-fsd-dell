package com.example.SpringData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }
    
    
}
