package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.Student_Course_Exception;
import com.app.dto.StudentDTO;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Override
	public ResponseEntity<?> addStudent(StudentDTO student, Long cid) throws Student_Course_Exception {
		Student s1 = mapper.map(student, Student.class);

		Course c = null;
		;
		try {
			c = courseRepository.findById(cid).orElseThrow(() -> new Student_Course_Exception("course not found"));
			if (student.getMarks() >= c.getMin_score()) {
				s1.setCourse(c);
				Student s = studentRepository.save(s1);
				System.out.println("addes student is " + s);
				return ResponseEntity.status(HttpStatus.OK).body(s);
			} else
				throw new Student_Course_Exception("NE");

		} catch (Student_Course_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.CONTINUE).body("Not able to add");
	}

	@Override
	public List<Student> getStudentByCourse(String title) {
		
		return   studentRepository.getStudentByCourse(title);
	}

	@Override
	public void deleteStudent(Long cid,Long sid) {
		studentRepository.deleteStudent(cid,sid);
		
	}
	
	

}
