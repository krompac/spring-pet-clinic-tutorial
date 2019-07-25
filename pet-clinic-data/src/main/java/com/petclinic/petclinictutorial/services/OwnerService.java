package com.petclinic.petclinictutorial.services;

import com.petclinic.petclinictutorial.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
