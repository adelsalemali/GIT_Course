package com.adel.DAO;

import java.util.List;

import com.adel.api.Student;

public interface StudentDAO {
 
	List<Student> loadStudents();
	void saveStudent(Student student);
	Student getStudent(int id);
	Student getStudentinfo(int id);
	void update(Student student);
	void deleteStudent(int id);
}

 