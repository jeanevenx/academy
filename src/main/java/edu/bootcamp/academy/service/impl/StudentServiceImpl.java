package edu.bootcamp.academy.service.impl;

import edu.bootcamp.academy.client.ViaCepService;
import edu.bootcamp.academy.model.Address;
import edu.bootcamp.academy.model.Evaluation;
import edu.bootcamp.academy.model.Student;
import edu.bootcamp.academy.model.form.StudentForm;
import edu.bootcamp.academy.model.form.StudentFormUpdate;
import edu.bootcamp.academy.repository.AddressRepository;
import edu.bootcamp.academy.repository.StudentRepository;
import edu.bootcamp.academy.service.IStudentService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    //Singleton pattern

    @Autowired
    StudentRepository studentRepo;
    @Autowired
    AddressRepository addressRepo;
    @Autowired
    ViaCepService viacep;
    @Override
    public void createStudent(StudentForm form) {
        Student student = new Student();

        student.setName(form.getName());
        student.setCpf(form.getCpf());
        student.setYearOfBirth(form.getYearOfBirth());

        Address address = new Address();
        address.setCep(form.getCep());
        student.setAddress(address);

        saveStudentWithAddress(student);

    }

    @Override
    public void updateStudent(Integer id, StudentFormUpdate form) {
        Optional<Student> studentBD = studentRepo.findById(id);

        if(studentBD.isPresent()){
            Student studentData = new Student();
            studentData.setName(form.getName());
            studentData.setYearOfBirth(form.getYearOfBirth());

            Address address = new Address();
            address.setCep(form.getCep());
            address.setComplemento(form.getComplemento());
            studentData.setAddress(address);
        }

    }

    @Override
    public Iterable<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(Integer id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public List<Evaluation> getAllEvaluationById(Integer id) {
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepo.deleteById(id);

    }

    private void saveStudentWithAddress(Student student) {
        String cep = student.getAddress().getCep();
        Address address = addressRepo.findById(cep).orElseGet(() -> {
            Address newAddress = viacep.getCepClient(cep);
            addressRepo.save(newAddress);
            return newAddress;
        });

        student.setAddress(address);
        studentRepo.save(student);
    }
}
