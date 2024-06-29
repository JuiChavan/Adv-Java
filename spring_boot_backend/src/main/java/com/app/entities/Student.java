package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="students")
@Entity
public class Student extends BaseEntity {

	//first name , last name , email , course id,score obtained , foreign key of course_id set.

	private String first_name;
	private String last_name;
	private String email;
	private double marks;

	
	
	public Student(String first_name, String last_name, String email, double marks, Course course) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.marks = marks;
		this.course = course;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;
	
	public void setCourse(Course course) {
		this.course=course;
	}
	
	    	
}
