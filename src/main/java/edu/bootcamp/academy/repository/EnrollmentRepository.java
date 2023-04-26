package edu.bootcamp.academy.repository;

import edu.bootcamp.academy.model.Enrollment;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {
}
