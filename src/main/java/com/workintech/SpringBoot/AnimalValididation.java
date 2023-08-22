package com.workintech.SpringBoot;

import com.workintech.SpringBoot.entity.Animal;

import java.util.Map;

public class AnimalValididation {
    public static boolean isValid(int id){
        return !(id<0);
    }
    public static boolean isMapContainsKey(Map<Integer, Animal> animals , int id){
        return animals.containsKey(id);

    }

    public static boolean isAnimalCredentialsValid(Animal animal){
        return !(animal.getId() < 0 || animal.getName() == null || animal.getName().isEmpty());
    }
}
