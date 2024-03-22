package com.estates.project.repository;

import com.estates.project.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer> {
    @Query("SELECT * FROM PROPERTY WHERE STATUS=SOLD")
    Optional<Property> findSoldProperty();

    @Query("SELECT * FROM PROPERTY WHERE STATUS=FOR SALE")
    Optional<Property> findForSaleProperty();
}
