package edu.bootcamp.academy.service.impl;

import edu.bootcamp.academy.DTO.StudentInfo;
import edu.bootcamp.academy.model.Enrollment;
import edu.bootcamp.academy.repository.EnrollmentRepository;
import edu.bootcamp.academy.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnrollmentServiceImpl implements IEnrollmentService {
    @Autowired
    EnrollmentRepository enrollmentRepo;

    @Override
    public Iterable<Enrollment> getAllStudent() {

        return enrollmentRepo.findAll();
    }

    @Override
    public void updateEnrollment(StudentInfo info) {
        //TODO:
    }
}
