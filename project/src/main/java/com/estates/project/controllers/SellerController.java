package com.estates.project.controllers;

import com.estates.project.entities.Seller;
import com.estates.project.services.SellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

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

    // TODO Update Seller Comment:
    //  This api call will only work locally and has been written to meet
    //  the minimum MVP requirements.
    //  Will need to modify this to work with the frontend in due course.
    @PatchMapping("/update/{id}")
    public Seller updateSeller(@PathVariable Integer id,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String surname,
                               @RequestParam(required = false) String address,
                               @RequestParam(required = false) String postcode,
                               @RequestParam(required = false) String phone){
        return this.sellerService.updateSeller(id,firstName,surname,address,postcode,phone);
    }

    @DeleteMapping("/remove/{id}")
    public Seller removeSeller(@PathVariable int id){
        return this.sellerService.removeSeller(id);
    }
}
