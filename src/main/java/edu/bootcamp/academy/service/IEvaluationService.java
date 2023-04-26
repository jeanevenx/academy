package edu.bootcamp.academy.service;

import edu.bootcamp.academy.model.Evaluation;
import edu.bootcamp.academy.model.Student;
import edu.bootcamp.academy.model.form.EvaluationForm;

public interface IEvaluationService {
    void createEvaluation(EvaluationForm form);
    Iterable<Evaluation> findAllEvaluation();
    Evaluation findByStudentId(Integer id);
}
