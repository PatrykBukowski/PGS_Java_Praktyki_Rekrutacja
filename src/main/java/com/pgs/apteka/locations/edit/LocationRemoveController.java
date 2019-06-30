package com.pgs.apteka.locations.edit;

import com.pgs.apteka.repositories.LocationRepository;

public class LocationRemoveController {
    private LocationRepository locationRepository;

    public LocationRemoveController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * Powoduje usunięcie reordu
     *
     * @param id rekordu, który ma być usunięty
     * @return true, jeżeli dany rekord istniał
     */
    public boolean remove(Long id) {
        if (locationRepository.findById(id).isPresent()) {
            locationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
