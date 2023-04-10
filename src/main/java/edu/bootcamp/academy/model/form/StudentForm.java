package edu.bootcamp.academy.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentForm {
    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String name;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @CPF(message = "'${validatedValue}' é inválido!")
    private String cpf;

    @NotNull(message = "Prencha o campo corretamente.")
    @Past(message = "Data '${validatedValue}' é inválida.")
    private LocalDate yearOfBirth;
    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(max =9, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String cep;

}
