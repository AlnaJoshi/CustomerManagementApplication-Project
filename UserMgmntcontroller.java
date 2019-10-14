package com.cust_app.web.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cust_app.model.persistence.User;
import com.cust_app.model.persistence.UsernotFoundException;
import com.cust_app.model.service.UserService;

@Controller
public class UserMgmntcontroller {

	@Autowired
	private UserService userService;
	
	
	/*@PostConstruct
	public void init(){
		userService.addUser(new User("Renjini","renjini@gmail.com","renjini123","admin",true));
		userService.addUser(new User("Joshy","joshy@gmail.com","joshy123","mgr",true));
		userService.addUser(new User("Cilna","cilna@gmail.com","cilna123","emp",true));
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		
		return "redirect:login";
	}

	

	@RequestMapping(value = "logout")
	public String logout(ModelMap map) {
		map.addAttribute("userBean", new UserFormBean());
		map.addAttribute("message", "you are successfully logged out!!");
		return "login";

	}
	@RequestMapping(value = "login")
	public String loginGet(HttpServletRequest req,ModelMap map) {
		map.addAttribute("userBean", new UserFormBean());
		map.addAttribute("error", req.getParameter("error"));
		return "login";

	}


	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest req, @Valid @ModelAttribute(value="userBean") UserFormBean userBean, BindingResult bindingResult) {
		User user = null;
		if (bindingResult.hasErrors())
			return "login";
		else {
			try {
				user = userService.findUser(userBean.getUserEmail(), userBean.getPassword());
			} catch (UsernotFoundException e) {
				
				return "redirect:login?error=login failed";
			}
		
		
		HttpSession httpSession=req.getSession();
		httpSession.setAttribute("user", user);
		}
		return "redirect:allCustomers";
	}

}