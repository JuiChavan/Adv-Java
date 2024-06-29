package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentDTO {
	private String first_name;
	private String last_name;
	private String email;
	private double marks;
	//private double course;
	
	public StudentDTO(String first_name, String last_name, String email, double marks,double courseid) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.marks = marks;
		//this.course=courseid;
	}
	
	

}
