package com.pgs.apteka.locations.edit;

import com.pgs.apteka.AptekaApplication;
import com.pgs.apteka.repositories.LocationRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AptekaApplication.class)
public class LocationAddControllerTest {
    @Autowired LocationRepository locationRepository;

    @Test
    public void add() {
        String name = "newLocation";
        LocationAddController controller = new LocationAddController(locationRepository);
        long counter = locationRepository.count();
        assertTrue(controller.add(name));
        assertEquals(locationRepository.count(), counter+1);
    }
}