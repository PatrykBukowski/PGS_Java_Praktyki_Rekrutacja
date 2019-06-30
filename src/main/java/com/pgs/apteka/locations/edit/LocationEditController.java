package com.pgs.apteka.locations.edit;

import com.pgs.apteka.locations.Location;
import com.pgs.apteka.repositories.LocationRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class LocationEditController {
    private LocationRepository locationRepository;

    public LocationEditController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * Za pomocą tej metody można edytować nazwę w tabeli Location
     * @param id id rekordu, który użytkownik chce zminić
     * @param newName nowa nazwa
     * @return true, jeżeli istnieje rekord o podanym id
     */
    public boolean edit(Long id, String newName) {
        if (locationRepository.findById(id).isPresent()) {
            Location location = locationRepository.findById(id).get();
            location.setName(newName);
            locationRepository.save(location);
            return true;
        }
        else return false;
    }
}
