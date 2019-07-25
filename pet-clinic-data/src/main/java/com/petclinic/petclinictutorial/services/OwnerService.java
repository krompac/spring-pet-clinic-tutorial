package com.petclinic.petclinictutorial.services;

import com.petclinic.petclinictutorial.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
