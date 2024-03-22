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
}
