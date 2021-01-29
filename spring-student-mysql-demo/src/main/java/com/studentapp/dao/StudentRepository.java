package com.studentapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	// derived 
//	List<Student> findByAddressCity(String city);
	
	@Query("from Student s inner join s.address a where a.city=?1")
	List<Student> findByAddressCity(String city);
	
//	@Query("from Student s inner join s.courses c where c.courseName=?1")
//	List<Student> findByCourses(String course);
}

//select * from student s inner join address a on s.address_id = a.address_id where s.address_city=?1;