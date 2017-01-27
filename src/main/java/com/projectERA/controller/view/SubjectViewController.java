package com.projectERA.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectERA.dao.interfaces.ISubjectDao;
import com.projectERA.manager.interfaces.ISubjectManager;
import com.projectERA.model.DumpFields;
import com.projectERA.model.Subject;


	@Controller
	public class SubjectViewController {
		@Autowired
		private ISubjectDao subjectDao;
		
		@GetMapping("/subjects/create")
		public String subjectCreate(Model model){
			model.addAttribute("attributs",DumpFields.<Subject>inspect(Subject.class));
			return "";
		}
		
		@PostMapping("/subjects/create")
		public String itemTestRetreiver(@ModelAttribute Subject subject){
			System.out.println(subject);
			subjectDao.create(subject);

			String redirectUrl = "/";
		    return "redirect:" + redirectUrl;
		}


}
