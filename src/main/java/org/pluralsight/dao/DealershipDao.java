package org.pluralsight.dao;

import org.pluralsight.model.LeaseContract;
import org.pluralsight.model.SalesContract;
import org.pluralsight.model.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface DealershipDao {
    ArrayList<Vehicle> getAllVehicles();
    Vehicle addVehicle(Vehicle vehicle);
    ArrayList<Vehicle> getAllVehiclesByPriceRange(double min, double max);
    ArrayList<Vehicle> getVehiclesByType(String type);
    ArrayList<Vehicle> getVehiclesByMilage(int minMiles, int maxMiles);
    ArrayList<Vehicle> getVehiclesByColor(String color);
    ArrayList<Vehicle> getVehiclesByYear(int min, int max);
    ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model);
    Vehicle getVehicleByVin(String vin);
    void updateVehicle(Vehicle vehicle);
    void deleteVehicle(String vin);
    List<SalesContract> getAllSalesContract();
    void addSalesContractDetails(SalesContract salesContract);
    void addLeaseContractDetails(LeaseContract leaseContract);
    List<LeaseContract> getAllLeaseContract();
}
