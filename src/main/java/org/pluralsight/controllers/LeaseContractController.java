package org.pluralsight.controllers;

import org.pluralsight.dao.DealershipDao;
import org.pluralsight.model.LeaseContract;
import org.pluralsight.model.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class LeaseContractController {
    private final DealershipDao dealershipDao;
    @Autowired
    public LeaseContractController(DealershipDao dealershipDao) {
        this.dealershipDao = dealershipDao;
    }

    @RequestMapping(path="/lease&contract", method= RequestMethod.GET)
    public List<LeaseContract> getAllLeaseContract(){
        return dealershipDao.getAllLeaseContract();
    }

    @RequestMapping(path="/lease&contract", method=RequestMethod.POST)
    public void addLeaseContractDetails(@RequestBody LeaseContract leaseContract){
        dealershipDao.addLeaseContractDetails(leaseContract);
    }
}
