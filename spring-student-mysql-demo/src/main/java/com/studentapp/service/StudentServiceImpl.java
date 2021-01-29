package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentapp.dao.StudentRepository;
import com.studentapp.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepo;
	@Override
	public void addStudent(Student student) {
		studentRepo.save(student);
	}

	@Override
	public List<Student> getStudentByCity(String city) {
		return studentRepo.findByAddressCity(city);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
	public List<Student> getStudentByCourseName(String courseName){
		return null;//studentRepo.findByCourses(courseName);
	}
	
	

}
