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
}
