package com.petclinic.petclinictutorial.services.map;

import com.petclinic.petclinictutorial.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {

    private PetServiceMap petServiceMap;

    private final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        Pet pet = Pet.builder().build();
        pet.setId(petId);
        petServiceMap.save(pet);
    }

    @Test
    void findById() {
        Pet pet = petServiceMap.findById(petId);

        assertEquals(petId, pet.getId());
    }

    @Test
    void findByNonExistingId(){
        Pet pet = petServiceMap.findById(5L);

        assertNull(pet);
    }

    @Test
    void save() {
        Pet pet = Pet.builder().build();
        pet.setId(2L);

        Pet savedPet = petServiceMap.save(pet);

        assertEquals(pet.getId(), savedPet.getId());
    }

    @Test
    void findAll() {

        Set<Pet> petSet = petServiceMap.findAll();

        assertEquals(1, petSet.size());
    }

    @Test
    void delete() {
        Pet pet = Pet.builder().build();
        pet.setId(2L);

        Pet petToDelete = petServiceMap.save(pet);
        int sizeBeforeDelete = petServiceMap.findAll().size();

        petServiceMap.delete(petToDelete);
        int sizeAfterDelete = petServiceMap.findAll().size();

        assertNotEquals(sizeBeforeDelete, sizeAfterDelete);
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(petId);

        assertEquals(petServiceMap.findAll().size(), 0);
    }
}