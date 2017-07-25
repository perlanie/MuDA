package org.jboss.spring.quickstarts.greeter.greeter_spring.web;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.servlet.ModelAndView;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

@Controller
//@RequestMapping("initialChoices")
public class InitialChoicesController {

	@Autowired
	private UserDao userDao;

	// @RequestMapping(method = RequestMethod.GET)
	// public
	// @ModelAttribute("message")
	// String getInitialMessage() {
	// return "Enter a valid name";
	// }
	//
	// @RequestMapping(method = RequestMethod.POST)
	// public
	// @ModelAttribute("message")
	// String getGreeting(@RequestParam("username") String username) {
	// Model model = new Model("E:\\Aprioi\\Model.txt");
	// HashSet<String> mylikes = new HashSet<String>(){{add("0");}};
	// HashSet<String> recommendations=model.getRecommendations(mylikes,5);
	// User user = userDao.getUserEmail(username);
	// if (user != null) {
	// //response.sendRedirect("greet.jsp");
	// return"works";
	// //return "redirect:choicesGreet";//"Hello, " + user.getFirstName() + " "
	// + user.getLastName() + "!"+recommendations.toString();
	// } else {
	// return "No such user exists! Use 'emuster' or 'jdoe'";
	// }
	// }

	@RequestMapping(value = "/initialChoices", method = RequestMethod.GET)
	public ModelAndView displayRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("initialChoices");
		User user = new User();
		model.addObject("userRegister", user);
		return model;
	}

	@RequestMapping(value = "/initialChoices", method = RequestMethod.POST)
	public ModelAndView executeInitialChoices(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loggedInUser") String username, @RequestParam("a0") String a0,
			@RequestParam("a1") String a1, @RequestParam("a2") String a2,@RequestParam("a3") String a3) {
		ModelAndView model = null;
		try {
			// userDao.createUser(user);
			User user = userDao.getUserEmail(username);
			System.out.println("Added Initial Likes");
			System.out.println("Form output: "+a0+","+a1+","+a2+","+a3);
			model = new ModelAndView("redirect:addLikes");

		} catch (Exception e) {
			model = new ModelAndView("register");
			request.setAttribute("message", "Error: Unable to create new user. Please try again.");
			e.printStackTrace();

		}

		return model;
	}

}
