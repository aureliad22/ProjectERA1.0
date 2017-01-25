package com.projectERA.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectERA.manager.interfaces.IAdministratorManager;
import com.projectERA.model.Administrator;
import com.projectERA.model.DumpFields;


@Controller
public class AdministratorViewController {
	@Autowired
	private IAdministratorManager administratorManager;
	
	@GetMapping("/administrators/create")
	public String userCreate(Model model) {
		model.addAttribute("attributs", DumpFields.<Administrator>inspect(Administrator.class));
		return "administrators/administratorCreate";
	}
	
	@PostMapping("/administrators/create")
	public String itemTestRetreiver(@ModelAttribute Administrator administrator){

		System.out.println(administrator);
		administratorManager.create(administrator);

		String redirectUrl = "/";
	    return "redirect:" + redirectUrl;
	}

	

}
