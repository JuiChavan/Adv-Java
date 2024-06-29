package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("select s from Student s join fetch s.course c where c.title =:ctitle")
	List<Student> getStudentByCourse(String ctitle);
	
	@Modifying
	@Transactional
	@Query("delete  from Student s where s.course.id=:cid and s.id=:sid")
	void deleteStudent(Long cid,Long sid);
	
	

}
