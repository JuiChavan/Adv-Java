package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CourseDTO;
import com.app.entities.Course;
import com.app.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseEntity<?> addCourse(CourseDTO c) {
		System.out.println("dto objj " + c);
		Course course = mapper.map(c, Course.class);

		// Log the mapped course object to verify
		System.out.println("Mapped Course Object: " + course.toString());

		Course c1 = courseRepository.save(course);

		// Log saved course object to verify
		System.out.println("Saved Course Object: " + c1);

		return ResponseEntity.status(HttpStatus.OK).body(c1);

	}

	@Override
	public void updateFees(Long id, String fees) {
		
	 courseRepository.UpdateCourseFees(id, fees);
	}
}
