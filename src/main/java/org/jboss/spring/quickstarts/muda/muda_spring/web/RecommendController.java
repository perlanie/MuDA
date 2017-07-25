package org.jboss.spring.quickstarts.greeter.greeter_spring.web;

import java.util.HashSet;


import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Model;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.User;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;


@Controller
@RequestMapping("recommend")
public class RecommendController {
	
    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ModelAttribute("message")
    String getInitialMessage() {
        return "Enter a valid name";
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ModelAttribute("message")
    @ResponseBody  String getGreeting(@RequestParam("email") String email, @RequestParam("password") String password)  {
    	Model model = new Model("E:\\Aprioi\\Model.txt");
    	HashSet<String> mylikes = new HashSet<String>(){{add("0");}};
    	HashSet<String> recommendations=model.getRecommendations(mylikes,5);
        User user = userDao.getUserEmail(email);
        if (user != null) {
        	if(user.getPassword().equals(password)){
        		//response.sendRedirect("greet.jsp");
        		//return "redirect:greet";//"Hello, " + user.getFirstName() + " " + user.getLastName() + "!"+recommendations.toString();
        		return "works";
        	}else{
        		return "Invalid Password";
        	}
        } else {
            return "No such user exists! Use 'emuster' or 'jdoe'";
        } 
    }
    
   
}
