package com.petclinic.petclinictutorial.services.springdatajpa;

import com.petclinic.petclinictutorial.model.Pet;
import com.petclinic.petclinictutorial.model.Visit;
import com.petclinic.petclinictutorial.repositories.VisitRepository;
import com.petclinic.petclinictutorial.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VisitSDJpaService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        Pet pet = object.getPet();
        if (pet == null || pet.getId() == null || pet.getOwner() == null || pet.getOwner().getId() == null){
            throw new RuntimeException("Invalid visit");
        }

        return visitRepository.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);

        return visits;
    }

    @Override
    public void delete(Visit object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
