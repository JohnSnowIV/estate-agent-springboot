package com.estates.project.controllers;

import com.estates.project.entities.Buyer;
import com.estates.project.entities.Seller;
import com.estates.project.services.BuyerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    public BuyerController(BuyerService service){
        this.buyerService = service;
    }

    @GetMapping("/buyer")
    public List<Buyer> getAll() {
        return this.buyerService.getAll();
    }

    @GetMapping("/buyer/{id}")
    public Buyer getById(@PathVariable int id) {
        return this.buyerService.getById(id);
    }

    @PostMapping("/buyer")
    public Buyer createBuyer(@RequestBody @Valid Buyer buyer){
        return this.buyerService.createBuyer(buyer);
    }

    @DeleteMapping("/buyer/{id}")
    public void deleteBuyer(@PathVariable Integer id) {
        this.buyerService.deleteBuyer(id);
    }

    @PatchMapping("/buyer/{id}")
    public Buyer updateBuyer(@PathVariable Integer id,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String surname,
                               @RequestParam(required = false) String address,
                               @RequestParam(required = false) String postcode,
                               @RequestParam(required = false) String phone){
        return this.buyerService.updateBuyer(id,firstName,surname,address,postcode,phone);
    }
}

