package com.projectERA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.model.User;
import com.projectERA.repository.UserRepository;

@Controller
public class UserController {


	  // Private fields
	  
	  // Wire the UserDao used inside this controller.
	  @Autowired
	  private UserRepository userRepo;
	  
	  /**
	   * Create a new user with an auto-generated id and email and name as passed 
	   * values.
	   */
	  @RequestMapping(value="/create")
	  @ResponseBody
	  public String create(String email, String userName) {
	    try {
	      User user = new User(email, userName);
//	      UserRepository.create(user);
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created!";
	  }
	  
	  /**
	   * Delete the user with the passed id.
	   */
	  @RequestMapping(value="/delete")
	  @ResponseBody
	  public String delete(int id) {
	    try {
	      User user = new User(id);
//	      userDao.delete(user);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user: " + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	  
	  /**
	   * Retrieve the id for the user with the passed email address.
	   */
	  @RequestMapping(value="/get-by-email")
	  @ResponseBody
	  public String getByEmail(String email) {
	    String userId;
	    try {
	      User user = userRepo.getByEmail(email);
	      userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return "User not found: " + ex.toString();
	    }
	    return "The user id is: " + userId;
	  }
	  
	  /**
	   * Update the email and the name for the user indentified by the passed id.
	   */
	  @RequestMapping(value="/update")
	  @ResponseBody
	  public String updateName(int id, String email, String userName) {
	    try {
	      User user = userRepo.getById(id);
	      user.setEmail(email);
	      user.setUserName(userName);
//	      userDao.update(user);
	    }
	    catch (Exception ex) {
	      return "Error updating the user: " + ex.toString();
	    }
	    return "User succesfully updated!";
	  } 
}
