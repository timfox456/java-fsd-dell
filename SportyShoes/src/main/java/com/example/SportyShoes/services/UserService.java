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


    public User GetUserByName(String name) {
    	return userRepository.findByName(name);
    }
     
    public boolean ConfirmUserPassword(User user, String password) {
    	return(user.getPassword() == password);
    }
    
    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }

}