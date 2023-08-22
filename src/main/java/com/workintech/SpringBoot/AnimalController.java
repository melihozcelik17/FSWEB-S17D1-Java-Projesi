package com.workintech.SpringBoot;


import com.sun.source.tree.BreakTree;
import com.workintech.SpringBoot.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




    @RestController
    public class AnimalController {


        @Value("${instroctor.name}")
        private String name;


    private Map<Integer, Animal> animalMap;

        //PostConstruct
        @PostConstruct
        public void init(){
            animalMap=new HashMap<>();

        }

    // public AnimalController(){
    //  animalMap=new HashMap<>();
    // }

        public List<Animal> get(){
            return animalMap.values().stream().toList();
        }

        @GetMapping("/{id}")
        public Animal get (@PathVariable int id){
            if(!AnimalValididation.isValid(id)){
                //TODO id is not valid
                return new AnimalResponse(animalMap.get(id),success,200);
            }
            if(AnimalValididation.isMapContainsKey(animalMap,id)){
                //TODO map !cpntains id
            }
            return animalMap.get(id);
        }


    @PostMapping("/")
    public Animal save(@RequestBody Animal animal){
            if(AnimalValididation.isMapContainsKey(animalMap,animal.getId())){
                //TODO item already exits
            }
            if(AnimalValididation.isAnimalCredentialsValid(animal)){
                //TODO animal credentials are not valid
            }

            animalMap.put(animal.getId(),animal);
            return animalMap.get(animal.getId());
    }
    @PutMapping("/{id}")
    public Animal update(@PathVariable int id, @RequestBody Animal animal){
            if(!animalMap.containsKey(id)){
                //TODO item is not exist
            }
        if(animal.getId()<0||animal.getName() ==null ||animal.getName().isEmpty()) {
            //TODO animal credentials are not valid
        }
        animalMap.put(id,new Animal(id, animal.getName()));
        return animalMap.get(id);
    }

    @DeleteMapping
    public Animal delete(@PathVariable int id){
        if(!animalMap.containsKey(id)){
            //TODO item is not exist
        }
        Animal

    }

    @GetMapping("/")
    public List<Animal> getAll(){
        return animalMap.values().stream().toList();

    }

}
