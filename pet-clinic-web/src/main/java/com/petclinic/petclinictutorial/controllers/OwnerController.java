package com.petclinic.petclinictutorial.controllers;

import com.petclinic.petclinictutorial.model.Owner;
import com.petclinic.petclinictutorial.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());

        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
        if (owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if (results.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1){
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable String ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");

        mav.addObject(ownerService.findById(Long.valueOf(ownerId)));

        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        Owner owner = Owner.builder().build();
        model.addAttribute("owner", owner);

        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result){
        if (result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        } else {
            ownerService.save(owner);

            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable String ownerId, Model model){
        model.addAttribute(ownerService.findById(Long.valueOf(ownerId)));

        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@PathVariable String ownerId, @Valid Owner owner, BindingResult result){
        if (result.hasErrors()) {
            return "owners/createOrUpdateOwnerForm";
        } else {
            owner.setId(Long.valueOf(ownerId));
            ownerService.save(owner);

            return "redirect:/owners/" + owner.getId();
        }
    }
}
