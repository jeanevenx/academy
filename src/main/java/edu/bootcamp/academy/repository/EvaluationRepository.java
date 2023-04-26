package edu.bootcamp.academy.repository;

import edu.bootcamp.academy.model.Evaluation;
import edu.bootcamp.academy.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {

}
