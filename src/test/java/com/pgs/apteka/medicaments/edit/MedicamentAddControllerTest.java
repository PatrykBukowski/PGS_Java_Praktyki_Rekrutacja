package com.pgs.apteka.medicaments.edit;

import com.pgs.apteka.AptekaApplication;
import com.pgs.apteka.locations.Location;
import com.pgs.apteka.repositories.LocationRepository;
import com.pgs.apteka.repositories.MedicamentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AptekaApplication.class)
public class MedicamentAddControllerTest {
    @Autowired MedicamentRepository medicamentRepository;
    @Autowired LocationRepository locationRepository;
    @Test
    public void add() {
        locationRepository.save(new Location("Stół"));
        MedicamentAddController controller = new MedicamentAddController(medicamentRepository, locationRepository);
        assertTrue(controller.add("Apap", "2020-01-01", 1L));
        assertFalse(controller.add("Apap", "2020-01-01", -1L));
        assertFalse(controller.add("Apap", "01-01-2020", 1L));
    }
}