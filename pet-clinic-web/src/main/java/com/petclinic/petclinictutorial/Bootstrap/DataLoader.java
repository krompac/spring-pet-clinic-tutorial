package com.petclinic.petclinictutorial.Bootstrap;

import com.petclinic.petclinictutorial.model.Owner;
import com.petclinic.petclinictutorial.model.PetType;
import com.petclinic.petclinictutorial.model.Vet;
import com.petclinic.petclinictutorial.services.OwnerService;
import com.petclinic.petclinictutorial.services.PetTypeService;
import com.petclinic.petclinictutorial.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Pero");
        owner1.setLastName("Peric");

        Owner owner2 = new Owner();
        owner2.setFirstName("Ivan");
        owner2.setLastName("Ivic");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Marko");
        vet1.setLastName("Maric");

        Vet vet2 = new Vet();
        vet2.setFirstName("Ivan");
        vet2.setLastName("Horvat");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
