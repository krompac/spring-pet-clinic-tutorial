package com.petclinic.petclinictutorial.services.map;

import com.petclinic.petclinictutorial.model.Specialty;
import com.petclinic.petclinictutorial.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtiesServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
