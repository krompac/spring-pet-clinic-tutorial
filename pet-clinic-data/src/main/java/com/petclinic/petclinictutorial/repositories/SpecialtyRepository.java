package com.petclinic.petclinictutorial.repositories;

import com.petclinic.petclinictutorial.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
