package com.petclinic.petclinictutorial.services.map;

import com.petclinic.petclinictutorial.model.Pet;
import com.petclinic.petclinictutorial.model.Visit;
import com.petclinic.petclinictutorial.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        Pet pet = object.getPet();
        if (pet == null || pet.getId() == null || pet.getOwner() == null || pet.getOwner().getId() == null){
            throw new RuntimeException("Invalid visit");
        }

        return super.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
