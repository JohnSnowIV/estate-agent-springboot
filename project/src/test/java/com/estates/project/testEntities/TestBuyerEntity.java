package com.estates.project.testEntities;

import com.estates.project.entities.Buyer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBuyerEntity {


    @Test
    public void testBuyer() {
        Buyer buyer = new Buyer();
        buyer.setId(1);
        buyer.setFirstName("Bob");
        buyer.setSurname("Beans");
        buyer.setAddress("123 Oak Street");
        buyer.setPostcode("QW1 2OP");
        buyer.setPhone("1234567");

        assertEquals(buyer.getId(), 1);
        assertEquals(buyer.getFirstName(), "Bob");
        assertEquals(buyer.getSurname(), "Beans");
        assertEquals(buyer.getAddress(), "123 Oak Street");
        assertEquals(buyer.getPostcode(), "QW1 2OP");
        assertEquals(buyer.getPhone(), "1234567");

    }


}
