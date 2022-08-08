package org.academy.Parking;


import org.academy.Vehicle.CustomerVehicle;

import java.io.InputStream;
import java.util.Scanner;

public class Parking implements IParking{
    private int places = 10;
    CustomerVehicle[] listPlaces = new CustomerVehicle[places];
    public Parking(){}


    //Validate if there are places available
    @Override
    public boolean therePlace() {
        boolean there = true;
        System.out.println("List of places");
        for(int i = 0 ; i< listPlaces.length ; i++)
        {
            there = listPlaces[i]==null? true: false; //Validate if place in i is busy or not
            if(there){
                System.out.println("There are places in "+ i);
            } else {
                System.out.println(i + " is busy");
            }
        }
        return there;
    }

    @Override
    public CustomerVehicle registerVehicle() {
        String nameDriver="";
        InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        System.out.println("Enter name driver");
        try{
            nameDriver = scanner.next();
        } catch (Exception e){
            System.out.println("Only words!");
        }
        System.out.println("Enter plates vehicle");
        String plates = scanner.next();
        CustomerVehicle vehicle = new CustomerVehicle(plates, nameDriver);
        return vehicle;
    }

    //Method to park a vehicle
    @Override
    public void park(CustomerVehicle customerVehicle, int i) {
        try{
            listPlaces[i]=customerVehicle;
            System.out.println("You have parked successfully");

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Doesn't exist this place");
        }

    }
}
