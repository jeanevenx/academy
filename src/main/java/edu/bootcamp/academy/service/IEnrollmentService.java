package edu.bootcamp.academy.service;

import edu.bootcamp.academy.DTO.StudentInfo;
import edu.bootcamp.academy.model.Enrollment;

public interface IEnrollmentService {
    Iterable<Enrollment> getAllStudent();
    void updateEnrollment(StudentInfo info);
}
