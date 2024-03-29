package com.petclinic.petclinictutorial.services.map;

import com.petclinic.petclinictutorial.model.BaseEntity;
import com.petclinic.petclinictutorial.model.Person;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<Long,T>();

    Set<T> findAll(){
        return new HashSet(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if (object != null){
            if (object.getId() == null){
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        }
        else{
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        return map.size() + 1L;
    }
}
