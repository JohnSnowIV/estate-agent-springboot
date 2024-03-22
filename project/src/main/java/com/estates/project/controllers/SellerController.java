package com.estates.project.controllers;

import com.estates.project.entities.Seller;
import com.estates.project.services.SellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  SellerController {

    private SellerService sellerService;

    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @GetMapping("/{id}")
    public Seller getById(@PathVariable int id){
        return this.sellerService.getById(id);
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
