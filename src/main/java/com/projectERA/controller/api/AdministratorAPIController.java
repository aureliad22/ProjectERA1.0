package com.projectERA.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.dao.interfaces.IAdministratorDao;
import com.projectERA.model.Administrator;

@Controller
public class AdministratorAPIController {
	
	/**
	 * Recover the AdministratorDao from IAdministratorDao to use within this controller.
	 */
	@Autowired
	private IAdministratorDao administratorDao;
	
	/**
	 * Create a new Administratir with an auto-generated id, and email/lastname/firstname as passed
	 * values.
	 */
	
	@RequestMapping(value = "/administrators/create")
	@ResponseBody
	public String create(String firstname, String lastname, String email) {
		try {
			Administrator administrator = new Administrator(firstname, lastname, email);
			administratorDao.create(administrator);
		} catch (Exception ex) {
			return "Error creating the administrator: " + ex.toString();
		}
		return "Administrator succesfully created!";
	}

	/**
	 * Delete the identified administrator.
	 */
	
	@RequestMapping(value = "/administrators/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Administrator administrator = new Administrator(id);
			administratorDao.delete(administrator);
		} catch (Exception ex) {
			return "Error deleting the administrator: " + ex.toString();
		}
		return "Administrator succesfully deleted!";
	}
	
	/**
	 * Update the email and names for the identified administrator.
	 */
	@RequestMapping(value = "/administrators/update")
	@ResponseBody
	public String updateName(Integer id, String firstname, String lastname, String email) {
		try {
			Administrator administrator = administratorDao.getById(id);
			administrator.setFirstName(firstname);
			administrator.setLastName(lastname);
			administrator.setEmail(email);
			administratorDao.update(administrator);
		} catch (Exception ex) {
			return "Error updating the administrator: " + ex.toString();
		}
		return "Administrator succesfully updated!";
	}
	
}
