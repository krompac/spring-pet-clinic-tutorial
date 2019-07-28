package com.petclinic.petclinictutorial.Bootstrap;

import com.petclinic.petclinictutorial.model.*;
import com.petclinic.petclinictutorial.services.OwnerService;
import com.petclinic.petclinictutorial.services.PetTypeService;
import com.petclinic.petclinictutorial.services.SpecialtyService;
import com.petclinic.petclinictutorial.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final SpecialtyService specialtyService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, SpecialtyService specialtyService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.specialtyService = specialtyService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Arrays.asList(new Specialty[]{radiology, surgery, dentistry}).forEach(specialty -> specialtyService.save(specialty));

        PetType dog = new PetType("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner pero = new Owner();
        pero.setFirstName("Pero");
        pero.setLastName("Peric");
        pero.setAddress("Ulica1");
        pero.setCity("Grad1");
        pero.setTelephone("12345");

        Pet perosDog = new Pet();
        perosDog.setPetType(savedDogPetType);
        perosDog.setOwner(pero);
        perosDog.setName("Medo");
        perosDog.setBirthDate(LocalDate.now());
        pero.getPets().add(perosDog);

        Owner ivan = new Owner();
        ivan.setFirstName("Ivan");
        ivan.setLastName("Ivic");
        ivan.setAddress("Ulica2");
        ivan.setCity("Grad2");
        ivan.setTelephone("543341");

        Pet ivansCat = new Pet();
        ivansCat.setPetType(savedCatType);
        ivansCat.setOwner(ivan);
        ivansCat.setName("mica");
        ivansCat.setBirthDate(LocalDate.now());
        ivan.getPets().add(ivansCat);

        ownerService.save(pero);
        ownerService.save(ivan);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Marko");
        vet1.setLastName("Maric");
        vet1.getSpecialties().add(radiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ivan");
        vet2.setLastName("Horvat");
        vet2.getSpecialties().add(surgery);
        vet2.getSpecialties().add(dentistry);

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
