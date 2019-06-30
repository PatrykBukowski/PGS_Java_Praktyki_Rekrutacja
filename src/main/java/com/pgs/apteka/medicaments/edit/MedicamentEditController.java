package com.pgs.apteka.medicaments.edit;

import com.pgs.apteka.medicaments.Medicament;
import com.pgs.apteka.repositories.LocationRepository;
import com.pgs.apteka.repositories.MedicamentRepository;

import java.time.LocalDate;

public class MedicamentEditController {
    private MedicamentRepository medicamentRepository;
    private LocationRepository locationRepository;

    public MedicamentEditController(MedicamentRepository medicamentRepository, LocationRepository locationRepository) {
        this.medicamentRepository = medicamentRepository;
        this.locationRepository = locationRepository;
    }

    /**
     * Edytuje wartości kolumn w rekordzie o podanym id
     *
     * @param id         rekordu, który ma być zmodyfikowany
     * @param newName    nowa nazwa leku
     * @param newDate    nowa data ważności
     * @param locationId nowe id z tabeli Location
     * @return true, jeżeli w tabeli Location znajdował się rekord o podanym id
     */
    public boolean edit(Long id, String newName, String newDate, Long locationId) {
        if (medicamentRepository.findById(id).isPresent()
                && locationRepository.findById(locationId).isPresent()) {
            Medicament medicament = medicamentRepository.findById(id).get();
            medicament.setName(newName);
            medicament.setExpiryDate(LocalDate.parse(newDate));
            medicamentRepository.save(medicament);
            return true;
        } else return false;
    }
}
