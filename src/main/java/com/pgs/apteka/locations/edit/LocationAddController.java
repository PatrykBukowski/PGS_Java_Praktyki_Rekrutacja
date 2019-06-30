package com.pgs.apteka.locations.edit;

import com.pgs.apteka.locations.Location;
import com.pgs.apteka.repositories.LocationRepository;

public class LocationAddController {
    private LocationRepository locationRepository;

    public LocationAddController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * Dodaje do tabeli Location nowy rekord
     *
     * @param name nazwa lokalizacji
     * @return true, jeżeli nie wystąpił żaden błąd
     */
    public boolean add(String name) {
        try {
            locationRepository.save(new Location(name));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
