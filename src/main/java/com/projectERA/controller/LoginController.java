package com.projectERA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectERA.model.User;
import com.projectERA.repository.UserRepository;

@Controller
public class LoginController {

	protected UserRepository userRepository;

	@Autowired
	public LoginController(UserRepository userRepo) {
		this.userRepository = userRepo;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String login(Model model) {
		return "connect";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/checkLogin")
	public String checkLogin(
			@RequestParam(value = "login", required = false) 
			String login,
			@RequestParam(value = "password", required = false) 
			String password, 
			Model model
			) {

			User user = this.userRepository.findByUserName(login);

			if (user != null && 
				user.getPassword().equals(password)) {
				model.addAttribute("login", login);
				return "home";
			}
				model.addAttribute("fail", true);
				return "connect";
			
	}

	@RequestMapping(method = RequestMethod.GET, path = "/logout")
	public String logout(Model model) {
		return "connect";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/reset")
	public String resetPassword(Model model) {
		return null;
	}
}
