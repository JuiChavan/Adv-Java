package com.app.service;

import org.springframework.http.ResponseEntity;

import com.app.dto.CourseDTO;
import com.app.entities.Course;

public interface CourseService {

	public ResponseEntity<?> addCourse(CourseDTO c) ;
	
	public void updateFees(Long id,String fees);
}
