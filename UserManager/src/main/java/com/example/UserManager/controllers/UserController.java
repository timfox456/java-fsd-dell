package com.example.UserManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;


@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;

    @RequestMapping(value="/userquery", method = RequestMethod.GET)
    public String showUsers()
    {
    	return("userquery");
    }
    

}
