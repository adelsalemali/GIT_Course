package com.adel.service;

import java.util.List;

import com.adel.api.Student;

public interface StudentService {

	List<Student> loadStudents();
	void saveStudent(Student student);
    Student getStudent(int id);
    Student getStudentinfo(int id);
	void update(Student student);
	void deleteStudent(int id);
}
