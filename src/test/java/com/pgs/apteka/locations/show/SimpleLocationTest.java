package com.pgs.apteka.locations.show;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleLocationTest {
    private SimpleLocation simpleLocation = new SimpleLocation(1L, "Test");

    @Test
    public void getId() {
        assertEquals(Long.valueOf(1), simpleLocation.getId());
    }

    @Test
    public void getName() {
        assertEquals("Test", simpleLocation.getName());
    }
}