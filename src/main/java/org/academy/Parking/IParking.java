package org.academy.Parking;

import org.academy.Vehicle.CustomerVehicle;

public interface IParking {
    //Method for validate places
    default boolean therePlace(){
        return false;
    }

    //Method for park a vehicle
    default void park(CustomerVehicle customerVehicle, int i){

    }

    default CustomerVehicle registerVehicle(){
        return null;
    }
}
