package com.pgs.apteka.locations.edit;

import com.pgs.apteka.AptekaApplication;
import com.pgs.apteka.locations.Location;
import com.pgs.apteka.repositories.LocationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AptekaApplication.class)
public class LocationEditControllerTest {
    @Autowired LocationRepository locationRepository;

    @Test
    public void edit() {
        LocationEditController controller = new LocationEditController(locationRepository);

        locationRepository.save(new Location("OldLocation"));
        assertTrue(controller.edit(locationRepository.count(), "NewLocation"));
        assertFalse(controller.edit(locationRepository.count() + 5, "FailedLocation"));
        assertFalse(controller.edit(0L, "FailedLocation"));
        assertFalse(controller.edit(-1L, "FailedLocation"));
    }
}