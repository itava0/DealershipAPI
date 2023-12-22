package org.pluralsight.controllers;

import org.pluralsight.dao.DealershipDao;
import org.pluralsight.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VehiclesController {
    private final DealershipDao dealershipDao;
    @Autowired
    public VehiclesController(DealershipDao dealershipDao) {
        this.dealershipDao = dealershipDao;
    }
    @RequestMapping(path="/vehicles", method= RequestMethod.GET)
    public List<Vehicle> getAllVehicles(){
        return dealershipDao.getAllVehicles();
    }
    @RequestMapping(path="/vehicle/price&range/{min}/{max}", method=RequestMethod.GET)
    public List<Vehicle> getAllVehiclesByPriceRange(@PathVariable double min,  @PathVariable double max){
        return dealershipDao.getAllVehiclesByPriceRange(min, max);
    }
    @RequestMapping(path="/vehicle/make&model/{make}/{model}", method=RequestMethod.GET)
    public ArrayList<Vehicle> getVehiclesByMakeModel(@PathVariable String make, @PathVariable String model){
        return dealershipDao.getVehiclesByMakeModel(make,model);
    }

    @RequestMapping(path="/vehicle/minYear&maxYear/{minYear}/{maxYear}", method=RequestMethod.GET)
    public  ArrayList<Vehicle> getVehiclesByYear(@PathVariable int minYear, @PathVariable int maxYear){
        return dealershipDao.getVehiclesByYear(minYear,maxYear);
    }

    @RequestMapping(path="/vehicle/car&color/{color}", method=RequestMethod.GET)
    public  ArrayList<Vehicle> getVehiclesByColor(@PathVariable String color){
        return dealershipDao.getVehiclesByColor(color);
    }

    @RequestMapping(path="/vehicle/minMiles&maxMiles/{minMiles}/{maxMiles}", method=RequestMethod.GET)
    public  ArrayList<Vehicle> getVehiclesByMilage(@PathVariable int minMiles, @PathVariable int maxMiles){
        return dealershipDao.getVehiclesByMilage(minMiles,maxMiles);
    }
    @RequestMapping(path="/vehicle/type/{type}", method=RequestMethod.GET)
    public ArrayList<Vehicle> getVehiclesByType(@PathVariable String type){
        return dealershipDao.getVehiclesByType(type);
    }

    @RequestMapping(path="/vehicle", method=RequestMethod.POST)
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        return dealershipDao.addVehicle(vehicle);
    }

    @RequestMapping(path="/vehicle", method=RequestMethod.PUT)
    public void updateVehicle(@RequestBody Vehicle vehicle){
        dealershipDao.updateVehicle(vehicle);
    }

    @RequestMapping(path="/vehicle/{vin}", method=RequestMethod.DELETE)
    public void deleteVehicle(@PathVariable String vin){
        dealershipDao.deleteVehicle(vin);
    }
}
