package com.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseDTO;
import com.app.entities.Course;
import com.app.service.CourseService;
import com.app.service.CourseServiceImpl;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Getter;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	public CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> addNewCourse(@RequestBody CourseDTO c) {
		System.out.println("this is "+c);
		return  courseService.addCourse(c);
	}

	@PutMapping("/{id}/{fees}")
	public ResponseEntity<?> updateCourseByFee(@PathVariable Long id,@PathVariable String fees){
		courseService.updateFees(id, fees);
		return ResponseEntity.status(HttpStatus.OK).body("done");
	}
}
