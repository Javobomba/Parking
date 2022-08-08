package org.academy;

import org.academy.Parking.Parking;
import org.academy.Vehicle.CustomerVehicle;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean onOff = true;
        //Create Parking Object
        Parking parking = new Parking();
        System.out.println("Welcome to Parking");

        while (onOff==true){
            InputStream stream = System.in;
            Scanner scanner = new Scanner(stream);
            int action=0;
            System.out.println("Actions: \n[1]Check availability \n[2]Register and park vehicle" +
                    "\n[3]Billing \n[4]Exit");
            System.out.print("Enter an option: ");
            try{
                action = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Only Numbers!");
            }
            if(action>=1 && action<=4){
                switch (action) {
                    case 1: {
                        parking.therePlace();
                    }
                    break;
                    case 2: {
                        CustomerVehicle vehicle;
                        if(parking.therePlace()==true){
                            vehicle = parking.registerVehicle();
                            System.out.println("Enter the place in parking");
                            try{
                                int place = scanner.nextInt();
                                parking.park(vehicle, place);
                            } catch (InputMismatchException e){
                                System.out.println("Only numbers!");
                            }
                        } else {
                            System.out.println("There aren't places");
                        }
                    }
                    break;
                    case 3:{
                        CustomerVehicle vehicle = new CustomerVehicle("aa-1","aaa");
                        System.out.print("Enter time: ");
                        try{
                            int time = scanner.nextInt();
                            vehicle.bill(time);
                        } catch (InputMismatchException e){
                            System.out.println("Only minutes like numbers!");
                        }
                    }
                    break;
                    case 4:{
                        onOff = false;
                    }
                    break;
                }
            } else{
                System.out.println("This option doesn´t exist in the list");
            }

        }
    }
}