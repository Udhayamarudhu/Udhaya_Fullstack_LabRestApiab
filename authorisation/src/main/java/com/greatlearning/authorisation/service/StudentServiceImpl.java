package com.greatlearning.authorisation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.authorisation.dao.StudentRepository;
import com.greatlearning.authorisation.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public Student getById(int id) {

		Optional<Student> opt = repository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {

		return repository.findAll();
	}

	public void deleteById(int id) {
		repository.deleteById(id);

	}

	@Override
	public void save(Student student) {
		repository.save(student);

	}

	@Override
	public List<Student> searchByCourse(String course) {

		return repository.findByCourse(course);
	}

}
