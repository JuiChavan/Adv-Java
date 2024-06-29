package com.app.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exception.Student_Course_Exception;
import com.app.dto.StudentDTO;
import com.app.entities.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	public StudentService studentService;

	@PostMapping("/{id}")
	public ResponseEntity<?> addStudent(@RequestBody StudentDTO s,@PathVariable("id") Long courseId) {
		try {
			return studentService.addStudent(s,courseId);
		} catch (Student_Course_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@GetMapping("/{title}")
	public ResponseEntity<List<Student>> getStudentByCourses(@PathVariable String title){
		List<Student> slist=studentService.getStudentByCourse(title);
		
		return ResponseEntity.status(HttpStatus.OK).body(slist);
		
	}
	
	@DeleteMapping("/{cid}/{sid}")
	public void deleteStudent(@PathVariable Long cid,@PathVariable Long sid) {
		studentService.deleteStudent(cid, sid);
	}
	
}
