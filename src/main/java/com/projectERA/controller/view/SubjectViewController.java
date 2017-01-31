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
			
			return "subject_view";
		}
		

		@GetMapping("/subjects/consult")
		public String subjectConsult(Model model){
			
			return "subject_consult";
	}

		
		@GetMapping("/subjects/add")
		public String subjectadd(Model model){
			
			return "add_subject";
		}

		@GetMapping("/subjects/teacherView")
		public String subjectTeacher(Model model){
			
			return "teacher_subject";
		}
		
	


}
