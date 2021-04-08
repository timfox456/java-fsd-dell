package com.example.SpringData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

	
	@Autowired
	UserService userService;
	
	
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String printHello()
    {
    	return("index");
    }
    
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public String showUsers(ModelMap model)
    {
    	Iterable<User> users = userService.GetAllUsers();
    	
    	model.addAttribute("users", users);
    	
    	return("users");
    }
    
    
}