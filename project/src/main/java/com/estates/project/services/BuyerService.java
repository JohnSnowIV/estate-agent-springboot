package com.estates.project.services;

import com.estates.project.entities.Buyer;
import com.estates.project.repository.BuyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {
    private BuyerRepository buyerRepo;

    public BuyerService(BuyerRepository buyerRepo){
        this.buyerRepo = buyerRepo;
    }

    public List<Buyer> getAll() {
        return this.buyerRepo.findAll();
    }

    public Buyer getById(Integer id) {
        return this.buyerRepo.findById(id).get();
    }

    public Buyer createBuyer(Buyer buyer) {
        return this.buyerRepo.save(buyer);
    }

}
