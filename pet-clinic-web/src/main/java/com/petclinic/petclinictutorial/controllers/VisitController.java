package com.petclinic.petclinictutorial.controllers;

import com.petclinic.petclinictutorial.model.Pet;
import com.petclinic.petclinictutorial.model.Visit;
import com.petclinic.petclinictutorial.services.PetService;
import com.petclinic.petclinictutorial.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/owners")
public class VisitController {
    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable Long petId, Model model){
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);

        Visit visit = Visit.builder().build();
        pet.addVisit(visit);
        return visit;
    }

    @GetMapping("/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable long petId, Model model){
        return "pets/CreateOrUpdateVisitForm";
    }

    @PostMapping("/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result, @PathVariable Long ownerId){
        if (result.hasErrors()){
            return "pets/CreateOrUpdateVisitForm";
        } else {
            visitService.save(visit);
            return "redirect:/owners" + ownerId;
        }
    }
}
