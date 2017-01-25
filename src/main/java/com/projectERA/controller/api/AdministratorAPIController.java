package com.projectERA.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.manager.interfaces.IAdministratorManager;
import com.projectERA.model.Administrator;
import com.projectERA.model.Student;

@Controller
public class AdministratorAPIController {
	@Autowired
	private IAdministratorManager administratorManager;
	/**
	 * Create a new user with an auto-generated id and email and name as passed
	 * values.
	 */
	
	@RequestMapping(value = "/administrators/create")
	@ResponseBody
	public String create(String firstname, String lastname, String login, String password, String email) {
		try {
			Administrator administrator = new Administrator(firstname, lastname, login, password, email);
			administratorManager.create(administrator);
		} catch (Exception ex) {
			return "Error creating the administrator: " + ex.toString();
		}
		return "Administrator succesfully created!";
	}

	/**
	 * Delete the user with the passed id.
	 */
	
	@RequestMapping(value = "/administrators/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Administrator administrator = new Administrator(id);
			administratorManager.delete(administrator);
		} catch (Exception ex) {
			return "Error deleting the administrator: " + ex.toString();
		}
		return "Administrator succesfully deleted!";
	}
	
	/**
	 * Update the email and the name for the user indentified by the passed id.
	 */
	@RequestMapping(value = "/administrators/update")
	@ResponseBody
	public String updateName(Integer id, String firstname, String lastname, String login, String password, String email) {
		try {
			Administrator administrator =administratorManager.getById(id);
			administrator.setFirstName(firstname);
			administrator.setLastName(lastname);
			administrator.setLogin(login);
			administrator.setPassword(password);
			administrator.setEmail(email);
			administratorManager.update(administrator);
		} catch (Exception ex) {
			return "Error updating the administrator: " + ex.toString();
		}
		return "Administrator succesfully updated!";
	}
	


}
