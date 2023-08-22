package com.workintech.SpringBoot;

public class AnimalResponse {
    private String animal;
    private String message;
    private int Status;

    public AnimalResponse() {
    }

    public AnimalResponse(String animal, String message, int status) {
        this.animal = animal;
        this.message = message;
        Status = status;
    }
}
