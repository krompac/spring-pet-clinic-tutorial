package com.petclinic.petclinictutorial.repositories;

import com.petclinic.petclinictutorial.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
