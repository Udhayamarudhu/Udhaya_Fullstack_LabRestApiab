package com.greatlearning.authorisation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.authorisation.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	List<Student> findByCourse(String course);
}
