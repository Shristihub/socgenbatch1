package com.studentapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String studentName;
	@Id
	private Integer studentId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="student_id")
	private Set<Gadgets> gadgets;
	
	@JoinTable(name="student_course",
			joinColumns = @JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="course_id"))
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Course> courses;

}








