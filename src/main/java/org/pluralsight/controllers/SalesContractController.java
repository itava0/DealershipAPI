package org.pluralsight.controllers;

import org.pluralsight.dao.DealershipDao;
import org.pluralsight.model.SalesContract;
import org.pluralsight.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SalesContractController {
    private final DealershipDao dealershipDao;
    @Autowired
    public SalesContractController(DealershipDao dealershipDao) {
        this.dealershipDao = dealershipDao;
    }

    @RequestMapping(path="/sales&contract", method= RequestMethod.GET)
    public List<SalesContract> getAllSalesContract(){
        return dealershipDao.getAllSalesContract();
    }

    @RequestMapping(path="/sales&contract", method=RequestMethod.POST)
    public void addSalesContractDetails(@RequestBody SalesContract salesContract){
        dealershipDao.addSalesContractDetails(salesContract);
    }
}
