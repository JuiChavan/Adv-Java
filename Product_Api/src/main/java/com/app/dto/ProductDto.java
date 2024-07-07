package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.app.enums.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	private String name;
	@Column(unique = true,nullable = false)
	private String productCode;
	@Column(nullable = false)
	private LocalDate mfd;
	@Enumerated(EnumType.STRING)
	private Category category;
	
}
