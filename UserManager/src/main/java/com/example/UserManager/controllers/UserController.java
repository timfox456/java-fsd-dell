package com.example.UserManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping(value="/userquery", method = RequestMethod.POST)
    public String handleQuery(
    		@RequestParam(value = "uid", required = true) Integer uid,
    		ModelMap model) {
    
    	
    	
    	//TODO: Handle empty or invalid UserId
    	User user = userService.GetUserById(uid);
    	
    	model.addAttribute("user", user);
    
    	return("useredit");
    }
    
    @RequestMapping(value="/useredit", method = RequestMethod.POST)
    public String handleEdit(
    		@RequestParam(value = "uid", required = true) Integer uid,
    		@RequestParam(value = "email", required = true) String email,
    		@RequestParam(value = "username", required = true) String username,
    		@RequestParam(value = "password", required = true) String password
    		) {
    	//TODO: Handle empty or invalid UserId
    	User user = userService.GetUserById(uid);
    	    
    	user.setEmail(email);
    	user.setName(username);
    	user.setPassword(password);
    	
    	userService.EditUser(user);
    	return("userquery");
    }
    

}
