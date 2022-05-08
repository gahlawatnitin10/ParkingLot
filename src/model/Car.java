package model;

public class Car {
    private String registrationNumber;
    private String colour;

    public Car(final String registrationNumber,final String colour){
        this.registrationNumber = registrationNumber;
        this.colour = colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColour() {
        return colour;
    }
}
