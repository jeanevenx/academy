package edu.bootcamp.academy.model;

import edu.bootcamp.academy.DTO.StudentInfo;
import edu.bootcamp.academy.model.form.StudentForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Embedded
    private StudentInfo StudentInfo;

    private LocalDateTime enrollmentDate = LocalDateTime.now();
}
