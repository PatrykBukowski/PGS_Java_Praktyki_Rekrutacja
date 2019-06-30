package com.pgs.apteka.locations.show;

import com.pgs.apteka.AptekaApplication;
import com.pgs.apteka.locations.Location;
import com.pgs.apteka.repositories.LocationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AptekaApplication.class)
public class LocationShowControllerTest {
    @Autowired LocationRepository locationRepository;

    @Test
    public void getOne() {
        LocationShowController controller = new LocationShowController(locationRepository);
        locationRepository.save(new Location("Dywan"));

        assertNotEquals("NaPewnoNieSzafa", ((Location) controller.getOne(1L)).getName());
        locationRepository.save(new Location("Dywan"));
        assertTrue(controller.getOne(-1L) instanceof Location || controller.getOne(-1L) instanceof SimpleLocationShow);
        assertTrue(controller.getOne(0L) instanceof Location || controller.getOne(0L) instanceof SimpleLocationShow);
        assertTrue(controller.getOne(1L) instanceof Location || controller.getOne(1L) instanceof SimpleLocationShow);
        assertTrue(controller.getOne(2L) instanceof Location || controller.getOne(2L) instanceof SimpleLocationShow);
    }
}