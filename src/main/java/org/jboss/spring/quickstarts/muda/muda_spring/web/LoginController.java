package org.jboss.spring.quickstarts.greeter.greeter_spring.web;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.LoginBean;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Model;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.UserDao;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;


@Controller
//@RequestMapping("login")
public class LoginController {
	
    @Autowired
    private UserDao userDao;
       
    @RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		//User user=new User();
		model.addObject("loginBean", loginBean);
		return model;
	}
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
	{
			ModelAndView model= null;
			try
			{
					User user = userDao.getUserEmail(loginBean.getEmail());
					String pswd=loginBean.getPassword();
					if(user!=null&& pswd.equals(user.getPassword())){
							System.out.println("User Login Successful");
							request.setAttribute("loggedInUser", "Welcome "+user.getEmail());
							model = new ModelAndView("redirect:recommend");
							
					}
					else{
						model = new ModelAndView("login");
						request.setAttribute("message", "Login Information is incorrect. Please try again.");
					}

			}
			catch(Exception e)
			{
					e.printStackTrace();
			}

			return model;
	}
    


    
   
}
