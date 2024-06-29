package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.custom_exception.Student_Course_Exception;
import com.app.dto.StudentDTO;
import com.app.entities.Student;

public interface StudentService {

	public ResponseEntity<?> addStudent(StudentDTO s,Long cid) throws Student_Course_Exception;
	
	public List<Student> getStudentByCourse(String title);
	
	public void deleteStudent(Long cid,Long sid);
	
}
