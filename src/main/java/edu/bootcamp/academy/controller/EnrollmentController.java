package edu.bootcamp.academy.controller;


import edu.bootcamp.academy.model.Enrollment;
import edu.bootcamp.academy.service.impl.EnrollmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentServiceImpl enrollmentService;

    @GetMapping
    public ResponseEntity<Iterable<Enrollment>> getAllEnrollment(){
        return ResponseEntity.ok(enrollmentService.getAllStudent());
    }
}
