package com.petclinic.petclinictutorial.services;

import com.petclinic.petclinictutorial.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
