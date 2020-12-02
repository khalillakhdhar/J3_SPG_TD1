package com.rappel.repository;

import org.springframework.data.repository.CrudRepository;

import com.rappel.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
