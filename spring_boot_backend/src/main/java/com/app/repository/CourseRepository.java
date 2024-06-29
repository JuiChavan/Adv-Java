package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	@Query("select c from Course c where c.title=:title")
	Course finByTitle(String title);

	@Modifying
	@Transactional
	@Query("update Course c set c.fees=:cfees where c.id=:id")
	void UpdateCourseFees(Long id,String cfees);
}
