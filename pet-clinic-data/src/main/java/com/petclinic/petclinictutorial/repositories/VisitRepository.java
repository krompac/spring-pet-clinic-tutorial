package com.petclinic.petclinictutorial.repositories;

import com.petclinic.petclinictutorial.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
