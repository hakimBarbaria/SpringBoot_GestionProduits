package com.iset.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iset.entities.User;
import com.iset.services.UserService;

@Controller
public class SecurityController {
	@Autowired
	UserService userService;
	
	@GetMapping("/accessDenied") 
	public String geterror() { 
	 return "accessDenied"; 
	 } 
	 
	@PostMapping("/accessDenied") 
	public String posterror() { 
	 return "accessDenied"; 
	 } 
	
	@RequestMapping("/login") 
	public String login() 
	{ 
	return "login"; 
	} 
	
	@RequestMapping("/signup") 
	public String signup() 
	{ 
	return "signUp"; 
	} 
	
	@RequestMapping("/addUser") 
	public String addUser(@ModelAttribute("username") String userName,  @ModelAttribute("password") String password, 
			@ModelAttribute("passwordC") String confirmPassword,@ModelAttribute("role") String role, ModelMap modelMap) 
	{
		class UserForm{
			 private String username;
			 private String password;
			 private String confirmedPassword;
			} 
		try {
		userService.saveUser(userName, confirmPassword, password);
		}catch(RuntimeException e) {
			modelMap.addAttribute("msg", e.getMessage());
			return "signUp";
		}
		modelMap.addAttribute("msg", "utilisateur ajouté avec succées !");
		return "signUp";
	  
	} 

	@GetMapping("/logout") 
	public String logout(HttpServletRequest request) throws ServletException 
	{ 
	return "redirect:/login";
	}


}
