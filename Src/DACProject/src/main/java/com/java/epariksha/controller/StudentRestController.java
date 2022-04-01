package com.java.epariksha.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.epariksha.dao.LoginDAO;
import com.java.epariksha.dao.StudentDAOImpl;
import com.java.epariksha.entity.Student;
import com.java.epariksha.entity.Teacher;

public class StudentRestController {

	@Autowired
	LoginDAO loginDao;
	
	@Autowired
	StudentDAOImpl studentDao;
	//--------------------------------------------------------------
	//	STUDENT CONTROLLERS


	//test plz
	@PostMapping("/login")
	public Student student_login(@RequestBody Student student, HttpServletRequest request) 
	{
		System.out.println(student);
		Student stud = loginDao.validateStudent(student.getUserName(), student.getPassword());
		if(stud != null)
		{
			request.getSession().setAttribute("student", stud);
		//	System.out.println("student login success");
			return stud;
		}
		else
		{
			return null;
		}
		
	}


	//test plz
	@GetMapping("/student")
	public Student student_getDetails(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		return student;
	}
}
