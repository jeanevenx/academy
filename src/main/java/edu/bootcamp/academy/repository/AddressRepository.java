package edu.bootcamp.academy.repository;

import edu.bootcamp.academy.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {
}
