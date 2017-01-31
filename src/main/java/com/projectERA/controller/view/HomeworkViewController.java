package com.projectERA.controller.view;
import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectERA.controller.FileUploadController;
import com.projectERA.dao.interfaces.IHomeworkDao;
import com.projectERA.storage.StorageFileNotFoundException;
import com.projectERA.storage.StorageService;


@Controller
public class HomeworkViewController {

    @Autowired
    private IHomeworkDao homeworkDao;
   
	@GetMapping("/homeworks/create")
	public String homeworkCreate(Model model){
	
		return "homework_deposit";
	}
	
	
	@GetMapping("/homeworks/teacherdeposit")
	public String homeworkTeacherDeposit(Model model){
		
		return "teacher_deposit";
	}
	
	
}



