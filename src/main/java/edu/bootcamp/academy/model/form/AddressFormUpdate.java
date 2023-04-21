package edu.bootcamp.academy.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressFormUpdate {
    private String cep;
    private String complemento;
}
