package com.petclinic.petclinictutorial.repositories;

import com.petclinic.petclinictutorial.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
