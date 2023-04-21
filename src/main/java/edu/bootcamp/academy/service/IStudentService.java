package edu.bootcamp.academy.service;

import edu.bootcamp.academy.model.Evaluation;
import edu.bootcamp.academy.model.Student;
import edu.bootcamp.academy.model.form.StudentForm;
import edu.bootcamp.academy.model.form.StudentFormUpdate;

import java.util.List;

public interface IStudentService {
    public void createStudent(StudentForm form);
    public void updateStudent(Integer id, StudentFormUpdate form);
    public void deleteStudent(Integer id);
    public Student getById(Integer id);
    public Iterable<Student> getAllStudent();
    public List<Evaluation> getAllEvaluationById(Integer id);
}
