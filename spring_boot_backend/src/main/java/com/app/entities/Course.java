package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "courses")
@Setter
@Getter
@NoArgsConstructor
public class Course extends BaseEntity {
	@Column(name = "title")
	private String title;
	@Column(name = "start_date")
	private LocalDate start_date;
	@Column(name = "end_date")
	private LocalDate end_date;
	@Column(name = "fees")
	private String fees;
	@Column(name = "min_score")
	private Double min_score;
	public Course(String title, LocalDate start_date,
			LocalDate end_date, String fees, Double min_score) {
		this.title = title;
		this.start_date = start_date;
		this.end_date = end_date;
		this.fees = fees;
		this.min_score = min_score;
	}

//	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JsonIgnore
//	private List<Student> studentList = new ArrayList<>();

}
