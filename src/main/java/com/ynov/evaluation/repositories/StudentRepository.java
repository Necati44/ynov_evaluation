package com.ynov.evaluation.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ynov.evaluation.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	public Student findByName(String name);
	
}
