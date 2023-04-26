package edu.bootcamp.academy.controller;


import edu.bootcamp.academy.model.Evaluation;
import edu.bootcamp.academy.model.form.EvaluationForm;
import edu.bootcamp.academy.service.impl.EvaluationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationServiceImpl service;


    @PostMapping
    public ResponseEntity<EvaluationForm> create(@RequestBody EvaluationForm form){
        service.createEvaluation(form);
        return ResponseEntity.ok(form);

    }

    @GetMapping
    public ResponseEntity<Iterable<Evaluation>> getAllEvaluation(){
        return ResponseEntity.ok(service.findAllEvaluation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluationByStudentId(@PathVariable Integer id){

        return ResponseEntity.ok(service.findByStudentId(id));
    }


}
