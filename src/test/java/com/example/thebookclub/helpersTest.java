package com.example.thebookclub;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class helpersTest {
    helpers check = new helpers();

    @Test
    void getTimestamp() {
//        test wouldn't work as the seconds will always be different at every moment its executed
        assertEquals("",check.getTimestamp());
    }

    @Test
    void generateID() {
        String ID = check.generateID("FinalDestination");
        assertEquals(ID,check.generateID("FinalDestination"));
    }
}