package edu.bootcamp.academy.service.impl;

import edu.bootcamp.academy.model.Evaluation;
import edu.bootcamp.academy.model.Student;
import edu.bootcamp.academy.model.form.EvaluationForm;
import edu.bootcamp.academy.repository.EvaluationRepository;
import edu.bootcamp.academy.repository.StudentRepository;
import edu.bootcamp.academy.service.IEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationServiceImpl implements IEvaluationService {

    @Autowired
    EvaluationRepository evaluationRepo;

    @Autowired
    StudentRepository studentRepo;

    @Override
    public void createEvaluation(EvaluationForm form) {
        Evaluation evaluation = new Evaluation();

        Integer id = form.getStudentId();
        Student studentBD = studentRepo.findById(id).get();

        if(studentBD.getId() != null){
            evaluation.setStudent(studentBD);
            evaluation.setWeight(form.getWeight());
            evaluation.setHeight(form.getHeight());

            evaluationRepo.save(evaluation);
        }

    }

    @Override
    public Iterable<Evaluation> findAllEvaluation() {
        return evaluationRepo.findAll();
    }

    @Override
    public Evaluation findByStudentId(Integer id) {
        Student studentBD = studentRepo.findById(id).orElse(null);

        if(studentBD != null){

            for(Evaluation evaluation : evaluationRepo.findAll()){
                if(evaluation.getStudent().getId().equals(studentBD.getId())){
                    return  evaluation;
                }
            }
        }

        return null;

    }
}
