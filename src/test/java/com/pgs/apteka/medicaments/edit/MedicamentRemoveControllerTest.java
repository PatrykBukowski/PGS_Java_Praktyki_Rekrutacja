package com.pgs.apteka.medicaments.edit;

import com.pgs.apteka.AptekaApplication;
import com.pgs.apteka.medicaments.Medicament;
import com.pgs.apteka.repositories.LocationRepository;
import com.pgs.apteka.repositories.MedicamentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AptekaApplication.class)
public class MedicamentRemoveControllerTest {
    @Autowired MedicamentRepository medicamentRepository;
    @Autowired LocationRepository locationRepository;

    @Test
    public void remove() {
        MedicamentRemoveController controller = new MedicamentRemoveController(medicamentRepository);
        medicamentRepository.save(new Medicament("Apap", LocalDate.parse("2020-10-10"), locationRepository.findById(1L).get()));
        Assert.assertTrue(controller.remove(1L));
    }
}