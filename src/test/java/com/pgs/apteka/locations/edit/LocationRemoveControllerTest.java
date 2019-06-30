package com.pgs.apteka.locations.edit;

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
public class LocationRemoveControllerTest {
    @Autowired LocationRepository locationRepository;

    @Test
    public void remove() {
        LocationRemoveController controller = new LocationRemoveController(locationRepository);
        Location location = new Location("ToDelete");
        locationRepository.save(location);
        long howmany = locationRepository.count();

        assertTrue(controller.remove(howmany));
        assertEquals(howmany-1, locationRepository.count());
    }
}