package com.adel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adel.api.Student;
import com.adel.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/showStudent")
	public String showStudentList(Model model) {

		//Call the DAO method to get the data
		List<Student> studentsList = studentService.loadStudents();

		for (Student tempStudent : studentsList) {

			System.out.println("---" + tempStudent);

		}
		model.addAttribute("student", studentsList);
		return "student-list";
	}

	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) { 

		Student student = new Student();
		// studentDTO : carrying the data to the frontEnd
		model.addAttribute("student", student);

		return "add-student";
	}

	// Extract these data from the URL and save these data to DB

	@PostMapping("/save-student")
	public String saveStudent(Student student) {

		System.out.println(student);
		// Do a service call to save the students

		// do a condition check
		// if the user doesn't have an id then do an insert
		// if the user does have an id then do a update

		if (student.getId() == 0) {// if id is 0 (default value of id) do an insert (new record) 
			studentService.saveStudent(student);
		} else {// if id is not 0 , if we already have an id ,do a update
				// do a update
			studentService.update(student);
		}
//		

		return "redirect:/showStudent";
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id , Model model) {

		// We should give the user object who clicked on the update button.

		Student updateStudent = studentService.getStudent(id);// Getting the data from DataBase
		System.out.println("Update Student :" + updateStudent);
		System.out.println("Looking data for the student having id :" + id);

		model.addAttribute("student", updateStudent);
		return "add-student";//Once the data is fetched,sending the data to view.
	}
	
	
	
	@GetMapping("/getInfo")
	public String getInfo(@RequestParam("userId") int id , Model model) {

		// We should give the user object who clicked on the update button.

		Student getStudent = studentService.getStudentinfo(id);//Getting the data from DataBase
		System.out.println("getStudent Student :" + getStudent);
		System.out.println("Looking data for the getStudent having id :" + id); 

		model.addAttribute("student", getStudent);
		return "studentInfo";//Once the data is fetched,sending the data to view. 
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		
		//capture the id of the student who you are trying to delete.
		//Once captured the id do Service call to delete the student 
		studentService.deleteStudent(id);
		return "redirect:/showStudent";
	}
	
}
