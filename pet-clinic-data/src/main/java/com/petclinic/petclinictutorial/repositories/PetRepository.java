package com.petclinic.petclinictutorial.repositories;

import com.petclinic.petclinictutorial.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
