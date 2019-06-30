package com.pgs.apteka.locations;

import com.pgs.apteka.locations.edit.LocationAddController;
import com.pgs.apteka.locations.edit.LocationEditController;
import com.pgs.apteka.locations.edit.LocationRemoveController;
import com.pgs.apteka.locations.show.LocationShowController;
import com.pgs.apteka.repositories.LocationRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationRequest {
    private final LocationRepository locationRepository;


    public LocationRequest(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * Po wysłaniu żądania metodą GET wywoływana jest ta metoda. W zależności od parametru id zostanie wyświetlona
     * lista rekordów z tabeli lób pojedynczy rekord.
     * @param id id rekordu, który ma zwrócony. w przypadku braku rekordu o podanym id zwracana jest lista wszystkich rekordów
     * @param sortBy "name" - sortowanie za pomocą kolumny name.
     *               inne - sortowanie za pomocą kolumny id.
     * @return Obiekt klasy SimpleLocationShow lub Location parsowany na JSON
     */
    @RequestMapping(method = RequestMethod.GET)
    ILocations showLocation(@RequestParam(value = "id", defaultValue = "0") Long id, @RequestParam(value = "sort", defaultValue = "id") String sortBy) {
        LocationShowController controller = new LocationShowController(locationRepository);
        if(locationRepository.findById(id).isPresent())
            return controller.getOne(id);
        else return controller.getLocation(sortBy);
    }

    /**
     * Po wysłaniu żądania metodą POST dodany jest nowy rekord w tabeli Location
     * @param name wartość kolumny <code>name</code>
     * @return true, jeżeli udało się dodać nowy rekord
     */
    @RequestMapping(method = RequestMethod.POST)
    boolean addLocation(@RequestParam(value = "name") String name) {
        LocationAddController controller = new LocationAddController(locationRepository);
        return controller.add(name);
    }

    /**
     * Po wysłaniu żądania metodą PUT, wartość kolumny <code>name</code> jest modyfikowana
     * @param id rekordu, który ma być zmodyfikowany
     * @param newName nowa wartość kolumny <code>name</code>
     * @return true, jeżeli operacja się powiodła
     */
    @RequestMapping(method = RequestMethod.PUT)
    boolean editLocation(@RequestParam(value = "id") Long id,
                         @RequestParam(value = "name") String newName) {
        LocationEditController controller = new LocationEditController(locationRepository);
        return controller.edit(id, newName);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    boolean removeLocation(@RequestParam(value = "id") Long id) {
        LocationRemoveController controller = new LocationRemoveController(locationRepository);
        return controller.remove(id);
    }

}
