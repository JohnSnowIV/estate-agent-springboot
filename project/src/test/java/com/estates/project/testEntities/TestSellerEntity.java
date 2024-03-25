package com.estates.project.testEntities;

import com.estates.project.entities.Seller;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.*;

public class TestSellerEntity {

    @Test
    public void testSeller(){

        Seller seller = new Seller(1,"Brian", "McCloudy", "Box", "Beach", "123456789" );

        assertEquals(seller.getId(), 1);
        assertEquals(seller.getFirstName(), "Brian");
        assertEquals(seller.getSurname(), "McCloudy");
        assertEquals(seller.getAddress(), "Box");
        assertEquals(seller.getPostcode(), "Beach");
        assertEquals(seller.getPhone(), "123456789");

        assertEquals(seller.getClass(), Seller.class, "Newly created seller is not of the same class as the Seller entity. ");
    }

}
