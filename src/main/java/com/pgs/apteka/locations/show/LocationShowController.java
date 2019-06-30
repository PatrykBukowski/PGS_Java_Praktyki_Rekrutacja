package com.pgs.apteka.locations.show;

import com.pgs.apteka.locations.ILocations;
import com.pgs.apteka.locations.Location;
import com.pgs.apteka.medicaments.show.SimpleMedicamentShow;
import com.pgs.apteka.repositories.LocationRepository;

import java.util.ArrayList;

public class LocationShowController {
    private final LocationRepository locationRepository;

    public LocationShowController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * Wyświetlenie listy rekordów z tabeli Location
     * @param sortBy określa za pomocą jakiej kolumny mają być dane sortowane.
     *               "name" - za pomocą kolumny name;
     *               inne - za pomocą id;
     * @return Obiekt klasy SimpleLocationShow, który później jest parsowany na JSON
     */
    public SimpleLocationShow getLocation(String sortBy) {
        ArrayList<SimpleLocation> locations = new ArrayList<>();
        for (Location location :
                locationRepository.findAll()) {
            locations.add(new SimpleLocation(location.getId(), location.getName()));
        }
        switch (sortBy) {
            case "name":
                locations.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
                break;
            default:
                locations.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
                break;
        }

        return new SimpleLocationShow(locations);
    }

    /**
     * Jeżeli to możliwe (zgadza się id), wyśietlany jest pojedynczy rekord, w przeciwnym wypadku,
     * wywoływana jest funkcja <code>getLocation</code>.
     * @param id id rekordu, który ma być wyświetlony
     * @return obiekt klasy Location o podanym ID lub obiekt klasy SimpleLocationShow.
     */
    public ILocations getOne(Long id) {
        if (locationRepository.findById(id).isPresent())
            return locationRepository.findById(id).get();
        return getLocation("location-id");
    }
}
