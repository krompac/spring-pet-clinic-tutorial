package com.petclinic.petclinictutorial.Bootstrap;

import com.petclinic.petclinictutorial.model.Owner;
import com.petclinic.petclinictutorial.model.Vet;
import com.petclinic.petclinictutorial.services.OwnerService;
import com.petclinic.petclinictutorial.services.VetService;
import com.petclinic.petclinictutorial.services.map.OwnerServiceMap;
import com.petclinic.petclinictutorial.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Pero");
        owner1.setLastName("Peric");
        owner1.setId(1L);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ivan");
        owner2.setLastName("Ivic");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(3l);
        vet1.setFirstName("Marko");
        vet1.setLastName("Maric");

        Vet vet2 = new Vet();
        vet2.setId(4l);
        vet2.setFirstName("Ivan");
        vet2.setLastName("Horvat");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
