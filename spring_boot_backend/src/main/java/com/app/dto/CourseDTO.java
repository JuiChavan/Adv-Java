package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourseDTO extends BaseDTO {

	private String title;
	private LocalDate start_date;
	private LocalDate end_date;
	private String fees;
	private Double min_score;

}
