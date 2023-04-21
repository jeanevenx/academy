package edu.bootcamp.academy.repository;

import edu.bootcamp.academy.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
