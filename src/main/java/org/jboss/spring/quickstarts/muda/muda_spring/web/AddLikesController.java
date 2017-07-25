package org.jboss.spring.quickstarts.greeter.greeter_spring.web;

import java.util.Arrays;
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
//@RequestMapping("addLikes")
public class AddLikesController {
	
    @Autowired
    private UserDao userDao;

//    @RequestMapping(method = RequestMethod.GET)
//    public
//    @ModelAttribute("message")
//    String getInitialMessage() {
//        return "Enter a valid name";
//    }

//    @RequestMapping(value="/register", method = RequestMethod.POST)
//    public
//    @ModelAttribute("message")
//    String create(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, @RequestParam("email") String email, @RequestParam("password") String password) {
////        try {
////            userDao.createUser(user);
////            return "A new user with id "+user.getUid()+" has been created successfully";
////        } catch (Exception e) {
////            return "An error has occured while creating the user (see log for details)";
////        }
//    	return firstname +" "+lastname;
//    }
    
    
//    @RequestMapping(method = RequestMethod.POST)
//    public
//    @ModelAttribute("message")
//    String create(User user) {
//        try {
//            userDao.createUser(user);
//            return "A new user has been created successfully";
//        } catch (Exception e) {
//            return "An error has occured while creating the user (see log for details)";
//        }
//    }
    
    @RequestMapping(value="/addLikes",method=RequestMethod.GET)
  	public ModelAndView displayAddLikes(HttpServletRequest request, HttpServletResponse response){
  		ModelAndView model = new ModelAndView("addLikes");
  		//LoginBean loginBean = new LoginBean();
  		User user=new User();
  		model.addObject("user", user);
  		return model;
  	}
      
     @RequestMapping(value="/addLikes",method=RequestMethod.POST)
  	public ModelAndView AddNewLikes(HttpServletRequest request, HttpServletResponse response, @RequestParam("select")String addedLikes)
  	{
  			ModelAndView model= null;
  			try
  			{	
  				Model aprioriModel = new Model("D:\\Aprioi\\Model.txt");
  				String[] newLikes=addedLikes.split(",");
  		    	HashSet<String> mylikes = new HashSet<String>(Arrays.asList(newLikes));
  		    	HashSet<String> recommendations=aprioriModel.getRecommendations(mylikes,5);
  				
  		    	//after getting recommendations then redirect to recommend page and display suggestions
  				
//  					User user = userDao.getUserEmail(loginBean.getEmail());
//  					String pswd=loginBean.getPassword();
//  					if(user!=null&& pswd.equals(user.getPassword())){
//  							System.out.println("User Login Successful");
//  							request.setAttribute("loggedInUser", "Welcome "+user.getEmail());
//  							model = new ModelAndView("redirect:recommend");
//  							
//  					}
//  					else{
//  						model = new ModelAndView("login");
//  						request.setAttribute("message", "Login Information is incorrect. Please try again.");
//  					}
  				System.out.println(addedLikes);
  				System.out.println(recommendations);

  			}
  			catch(Exception e)
  			{
  					e.printStackTrace();
  			}

  			return model;
  	}
   
}
