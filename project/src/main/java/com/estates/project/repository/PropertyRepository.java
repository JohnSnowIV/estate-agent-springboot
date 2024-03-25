package com.estates.project.repository;

import com.estates.project.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer> {

    @Query("SELECT p FROM Property p WHERE p.status='FOR SALE'")
    List<Property> findForSale();

    @Query("SELECT p FROM Property p WHERE p.status='SOLD'")
    List<Property> findSold();

    @Query("SELECT p FROM Property p WHERE p.type='DETACHED'")
    List<Property> findDetached();
    @Query("SELECT p FROM Property p WHERE p.type='SEMI-DETACHED'")
    List<Property> findSemiDetached();
    @Query("SELECT p FROM Property p WHERE p.type='TERRACE'")
    List<Property> findTerrace();
    @Query("SELECT p FROM Property p WHERE p.type='APARTMENT'")
    List<Property> findApartment();

}
