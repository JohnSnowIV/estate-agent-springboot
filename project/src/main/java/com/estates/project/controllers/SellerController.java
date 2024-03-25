package com.estates.project.controllers;

import com.estates.project.entities.Seller;
import com.estates.project.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

//    public SellerController(SellerService sellerService){
//        this.sellerService = sellerService;
//    }

    @GetMapping("/seller/{id}")
    public Seller getById(@PathVariable int id){
        return this.sellerService.getById(id);
    }

    @GetMapping("/seller")
    public List<Seller> getAll(){
        return this.sellerService.getAll();
    }

    @PostMapping("/seller")
    public Seller createSeller(@RequestBody Seller newSeller){
        return this.sellerService.createSeller(newSeller);
    }

    // TODO Update Seller Comment:
    //  This api call will only work locally and has been written to meet
    //  the minimum MVP requirements.
    //  Will need to modify this to work with the frontend in due course.
    @PatchMapping("/seller/{id}")
    public Seller updateSeller(@PathVariable Integer id,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String surname,
                               @RequestParam(required = false) String address,
                               @RequestParam(required = false) String postcode,
                               @RequestParam(required = false) String phone){
        return this.sellerService.updateSeller(id,firstName,surname,address,postcode,phone);
    }

    @DeleteMapping("/seller/{id}")
    public Seller removeSeller(@PathVariable int id){
        return this.sellerService.removeSeller(id);
    }
}
