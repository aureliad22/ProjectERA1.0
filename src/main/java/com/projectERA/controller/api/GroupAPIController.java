package com.projectERA.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.manager.interfaces.IGroupManager;
import com.projectERA.model.Group;



@Controller
public class GroupAPIController {
	@Autowired
	private IGroupManager groupManager;
	
	@RequestMapping(value = "/groups/create")
	@ResponseBody
	public String create(Integer id) {
		try {
			Group group = new Group(id);
			groupManager.create(group);
		} catch (Exception ex) {
			return "Error creating the group: " + ex.toString();
		}
		return "Group succesfully created!";
	}
	@RequestMapping(value = "/groups/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Group group = new Group(id);
			groupManager.delete(group);
		} catch (Exception ex) {
			return "Error deleting the group: " + ex.toString();
		}
		return "Group succesfully deleted!";
	}

}
