package com.pgs.apteka.medicaments.edit;

import com.pgs.apteka.medicaments.Medicament;
import com.pgs.apteka.repositories.LocationRepository;
import com.pgs.apteka.repositories.MedicamentRepository;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MedicamentAddController {
    private MedicamentRepository medicamentRepository;
    private LocationRepository locationRepository;

    public MedicamentAddController(MedicamentRepository medicamentRepository, LocationRepository locationRepository) {
        this.medicamentRepository = medicamentRepository;
        this.locationRepository = locationRepository;
    }

    /**
     * Dodaje do tabeli Medicament nowy rekord
     *
     * @param name       nazwa leku
     * @param date       data ważności
     * @param locationId id rekordu z tabeli Location
     * @return true, jeżeli w tabeli Location znajdował się rekord o podanym id
     */
    public boolean add(String name, String date, Long locationId) {
        if (locationRepository.findById(locationId).isPresent()) {
            try {
                Medicament medicament = new Medicament(name, LocalDate.parse(date), locationRepository.findById(locationId).get());
                medicamentRepository.save(medicament);
            } catch (DateTimeParseException e) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
