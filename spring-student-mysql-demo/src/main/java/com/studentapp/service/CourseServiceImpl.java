package com.studentapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentapp.dao.CourseRepository;
import com.studentapp.model.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepo;
	@Override
	public Course findById(Integer courseId) {
		
		Optional<Course> courseOpt = courseRepo.findById(courseId);
		if(courseOpt.isPresent())
			return courseOpt.get();
		else
			return null;
	}

	
}
