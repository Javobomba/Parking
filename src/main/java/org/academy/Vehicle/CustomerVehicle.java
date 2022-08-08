package org.academy.Vehicle;

public class CustomerVehicle implements IPayTimeCustomer {
    private String plates;//Unmodified
    private String nameDriver;
    private int time;//minutes

    //Constructor method
    public CustomerVehicle(String plates, String nameDriver){
        this.plates=plates;
        this.nameDriver=nameDriver;
        this.time = 0;
    }

    //Setter for variable time
    public void setTime(int time) {
        this.time = time;
    }

    //Method to pay for parked time
    @Override
    public double bill(int time){
        if (time < 60) { time=60;} //Validate if the time is less than an hour
        int hours = time / 60; //Calculate if the time is equals to an hour
        int days = hours / 24; //Calculate if the time is equals to a day
        double cost = days * 150 + (hours - (days * 24)) * 20; //Calculate total cost
        System.out.println("The customer should pay "+cost+" for parking time");
        return cost;
    }
}
