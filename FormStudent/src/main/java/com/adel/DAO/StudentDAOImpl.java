package com.adel.DAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.adel.api.Student;
import com.adel.rowMapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO{
    
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	@Override
	public List<Student> loadStudents() {
		
		//I will write some logic to get me the studentData from the database
		
	     String sql = "select * from students"; 
	     
	     List<Student> theListOfStudent = jdbcTemplate.query(sql, new StudentRowMapper());
		 
		return theListOfStudent;
	}
    
	@Override
	public void saveStudent(Student student) {
		
		//write the logic to store the student object into the dataBase
		Object[] sqlParametar = {student.getName() , student.getMobile() , student.getCountry()}; 
		
		String sql = "insert into students (name , mobile , country) values (?,?,?)";
		
		jdbcTemplate.update(sql , sqlParametar);
		System.out.println("one record inserted");
	}

	@Override
	public Student getStudent(int id) { 
		
		String sql = "SELECT * FROM students WHERE id = ?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper() ,id);
		return student;
	}
	
	@Override
	public Student getStudentinfo(int id) { 
		
		String sql = "SELECT * FROM students WHERE id = ?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper() ,id); 
		return student;   
		
	}
 
	@Override
	public void update(Student student) {
		
		String sql = "update students set name = ? , mobile = ? , country= ?  where id = ?";
		jdbcTemplate.update(sql , student.getName() ,student.getMobile() , student.getCountry() ,  student.getId()); 
		System.out.println("one record updated..");
	} 

	@Override
	public void deleteStudent(int id) {
		
		String sql = "DELETE FROM students WHERE id = ?";
		jdbcTemplate.update(sql , id);
		System.out.println("One record deleted");
	}

	
}
