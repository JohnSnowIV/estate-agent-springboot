package com.estates.project.services;

import com.estates.project.entities.Seller;
import com.estates.project.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private SellerRepository sellerRepo;

    public SellerService(SellerRepository sellerRepo){
        this.sellerRepo = sellerRepo;
    }

    public List<Seller> getAll() {
        return this.sellerRepo.findAll();
    }

    public Seller createSeller(Seller newSeller) {
        return this.sellerRepo.save(newSeller);
    }

    public Seller getById(int id) {
        return this.sellerRepo.findById(id).get();
    }

    public Seller updateSeller(int id, String firstName, String surname, String address, String postcode, String phone) {
        Seller toUpdate = this.getById(id);

        if(firstName != null) toUpdate.setFirstName(firstName);
        if(surname != null) toUpdate.setFirstName(surname);
        if(address != null) toUpdate.setFirstName(address);
        if(postcode != null) toUpdate.setFirstName(postcode);
        if(phone != null) toUpdate.setFirstName(phone);

        return this.sellerRepo.save(toUpdate);
    }

    public Seller removeSeller(int id) {
        Seller toRemove = this.getById(id);
        this.sellerRepo.deleteById(id);
        return toRemove;
    }
}
