package com.projectERA.controller.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.dao.interfaces.ISubjectDao;
import com.projectERA.model.Grade;
import com.projectERA.model.Subject;
import com.projectERA.model.Teacher;

@Controller
@RequestMapping("/api/subjects")
public class SubjectAPIController {
	
	/**
	 * Recover the SubjectDao from ISubjectDao to use within this controller.
	 */
	@Autowired
	private ISubjectDao subjectDao;
	
	/**
	 * Create a subject with the title/deadline/groupSize/secription/idPromo/specialty/authorList as passed values.
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(Integer id, String title, Date deadline, Integer groupSize, String description,
			Grade grade, String specialty, Teacher author) {
		try {
			Subject subject = new Subject(id, title, deadline, groupSize, description, grade, specialty, author);
			subjectDao.create(subject);
		} catch (Exception ex) {
			return "Error creating the subject: " + ex.toString();
		}
		return "Subject succesfully created!";
	}

	/**
	 * Delete the identified subject.
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Subject subject = new Subject(id);
			subjectDao.delete(subject );
		} catch (Exception ex) {
			return "Error deleting the subject : " + ex.toString();
		}
		return "subject succesfully deleted!";
	}

	/**
	 * Update the parameters for the identified subject.
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(Integer id, String title, Date deadline, Integer groupSize, String description,
			Grade grade, String specialty) {
		try {
			Subject subject = subjectDao.getById(id);
			subject.setTitle(title);;
			subject.setDeadline(deadline);
			subject.setGroupSize(groupSize);
			subject.setDescription(description);
			subject.setGrade(grade);
			subject.setSpecialty(specialty);
			subjectDao.update(subject);
		} catch (Exception ex) {
			return "Error updating the subject: " + ex.toString();
		}
		return "Subject succesfully updated!";
	}
	
	/**
	 * Download a homework.
	 */
	@RequestMapping(method = RequestMethod.GET, path="/teachers/download")
	public void downloadDocument(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/**
		 * Size of a byte buffer to read/write file
		 */
		final int BUFFER_SIZE = 4096;
		
		/**
		 * Path of the file to be downloaded.
		 */
		String filePath = "/downloads/SpringProject.zip";
		// get absolute path of the application
		ServletContext context = request.getServletContext();
		String appPath = context.getRealPath("");
		System.out.println("appPath = " + appPath);

		// construct the complete absolute path of the file
		String fullPath = appPath + filePath;
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);

		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();
	}
}
