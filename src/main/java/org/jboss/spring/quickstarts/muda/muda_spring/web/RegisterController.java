package org.jboss.spring.quickstarts.greeter.greeter_spring.web;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.LoginBean;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Model;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.User;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;


@Controller
public class RegisterController {
	
    @Autowired
    private UserDao userDao;

    @RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView displayRegister(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("register");
		User user = new User();
		model.addObject("userRegister", user);
		return model;
	}
    
    @RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView executeRegister(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("userRegister")User user)
	{
			ModelAndView model= null;
			try
			{
					userDao.createUser(user);
					System.out.println("Created New User Successfully");
					request.setAttribute("loggedInUser", "Welcome "+user.getEmail());
					model = new ModelAndView("redirect:initialChoices");
					

			}
			catch(Exception e)
			{		
					model = new ModelAndView("register");
					request.setAttribute("message", "Error: Unable to create new user. Please try again.");
					e.printStackTrace();
					
			}

			return model;
	}
    
}
