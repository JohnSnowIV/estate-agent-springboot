package com.estates.project.controllers;

import com.estates.project.entities.Seller;
import com.estates.project.services.SellerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellerController {

    private SellerService sellerService;

    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @GetMapping("/getAll")
    public List<Seller> getAll(){
        return this.sellerService.getAll();
    }

    @PostMapping("/create")
    public Seller createSeller(@RequestBody Seller newSeller){
        return this.sellerService.createSeller(newSeller);
    }
}
