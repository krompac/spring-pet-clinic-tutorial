package com.petclinic.petclinictutorial.services;

import com.petclinic.petclinictutorial.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
