package com.petclinic.petclinictutorial.repositories;

import com.petclinic.petclinictutorial.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
