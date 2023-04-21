package edu.bootcamp.academy.controller;

import edu.bootcamp.academy.model.Student;
import edu.bootcamp.academy.model.form.StudentForm;
import edu.bootcamp.academy.model.form.StudentFormUpdate;
import edu.bootcamp.academy.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<StudentForm> createStudent(@RequestBody StudentForm form) {
        studentService.createStudent(form);
        return ResponseEntity.ok(form);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentFormUpdate> updateStudent(@PathVariable Integer id, @RequestBody StudentFormUpdate form) {
        studentService.updateStudent(id, form);
        return ResponseEntity.ok(form);
    }

    @GetMapping
    public ResponseEntity<Iterable<Student>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id){
        return ResponseEntity.ok(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Student> deleteById(@PathVariable Integer id){
        studentService.deleteStudent(id);

        return ResponseEntity.ok().build();
    }




}
