package com.estates.project.controllers;

import com.estates.project.entities.Buyer;
import com.estates.project.services.BuyerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
    private BuyerService service;

    public BuyerController(BuyerService service){
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Buyer> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Buyer getById(@PathVariable int id) {
        return this.service.getById(id);
    }

    @PostMapping("/create")
    public Buyer createBuyer(@RequestBody Buyer buyer){
        return this.service.createBuyer(buyer);
    }

}
