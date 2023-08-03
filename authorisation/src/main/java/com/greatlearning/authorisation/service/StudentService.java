package com.greatlearning.authorisation.service;

import java.util.List;

import com.greatlearning.authorisation.model.Student;

public interface StudentService {
	Student getById(int id);
	
	List<Student> getAllStudents();
	
	void deleteById(int id);
	
	void save(Student student);
	
	List<Student> searchByCourse(String course);
}
