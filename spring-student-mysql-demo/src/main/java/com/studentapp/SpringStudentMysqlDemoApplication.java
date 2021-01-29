package com.studentapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Address;
import com.studentapp.model.Course;
import com.studentapp.model.Gadgets;
import com.studentapp.model.Student;
import com.studentapp.service.CourseService;
import com.studentapp.service.StudentService;

@SpringBootApplication
public class SpringStudentMysqlDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentMysqlDemoApplication.class, args);
	}

	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;
	@Override
	public void run(String... args) throws Exception {
		Address address= new Address(2,"Bangalore","Kar");
		
		List<Gadgets> gadgetList =  Arrays.asList(
					new Gadgets(1003,"laptop","T450"),new Gadgets(1001,"mobile","A190"));
		Set<Gadgets> gadgets = new HashSet<>(gadgetList);
		
//		Course course1 = new Course("Java",90,9000);
//		Course course2 = new Course("Spring",91,7000);
//		Course course3 = new Course("node",92,3000);
//		Set<Course> courseList = new HashSet(Arrays.asList(course1,course2,course3));
//		
		Course course1 = courseService.findById(90);
		Course course2 = courseService.findById(91);
		Set<Course> courseList = new HashSet(Arrays.asList(course1,course2));
		
		Student student = new Student("Raghu",102,address,gadgets, courseList);
		studentService.addStudent(student);
		
		studentService.getAllStudents().forEach(System.out::println);
		studentService.getStudentByCity("Bangalore").forEach((nstudent)-> System.out.println(nstudent.getStudentName()));
//		studentService.getStudentByCourseName("Java").forEach(System.out::println);
		
		
	}
	

}
