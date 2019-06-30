package com.pgs.apteka.medicaments;

import com.pgs.apteka.medicaments.edit.MedicamentAddController;
import com.pgs.apteka.medicaments.edit.MedicamentEditController;
import com.pgs.apteka.medicaments.edit.MedicamentRemoveController;
import com.pgs.apteka.medicaments.show.IMedicaments;
import com.pgs.apteka.medicaments.show.MedicamentShowController;
import com.pgs.apteka.repositories.LocationRepository;
import com.pgs.apteka.repositories.MedicamentRepository;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicaments")
public class MedicamentRequest {
    private final MedicamentRepository medicamentRepository;
    private final LocationRepository locationRepository;

    public MedicamentRequest(MedicamentRepository medicamentRepository, LocationRepository locationRepository) {
        this.medicamentRepository = medicamentRepository;
        this.locationRepository = locationRepository;
    }

    /**
     * Wyświetlanie leków bez paginacji (w przypadku nie znalezienia podanego indexu) lub pojedynczego leku
     *
     * @param id     id leku, który ma być wyświetlony. W przypadku błędnego podania id, wyświetlone
     *               zostają wszystkie leki
     * @param sortBy "name" - sortowanie za pomocą tabeli name.
     *               "location" - za pomocą nazwy miejsca składowani leku
     *               inne - za pomocą id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    IMedicaments showMedicaments(@RequestParam(value = "id", defaultValue = "0") Long id, @RequestParam(value = "sort", defaultValue = "id") String sortBy) {
        MedicamentShowController controller = new MedicamentShowController(medicamentRepository);

        if (medicamentRepository.findById(id).isPresent()) {
            return controller.getOne(id);
        } else
            return controller.getMedicaments(sortBy);
    }

    /**
     * Wyświetlanie leków z paginacją, ilość obiektów ustawiona jest na dwa w klasie MedicamentShowController
     *
     * @param page strona, która ma być wyświetlona
     * @return Obiekt klasy Page, posiadający obiekty klasy Medicament
     */
    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    Page showPage(@PathVariable(value = "page") int page) {
        MedicamentShowController controller = new MedicamentShowController(medicamentRepository);
        return controller.getMedicamentsPageable(page);
    }

    /**
     * Dodanie leku do bazy
     *
     * @param name nazwa leku
     * @param date data ważności
     * @param locationId id miejsca składowania, tabeli locations
     * @return true, jeżeli operacjie zakończyły się sukcesem
     */
    @RequestMapping(method = RequestMethod.POST)
    Boolean addMedicament(@RequestParam(value = "name") String name,
                          @RequestParam(value = "date") String date,
                          @RequestParam(value = "location") Long locationId) {
        MedicamentAddController controller = new MedicamentAddController(medicamentRepository, locationRepository);
        return controller.add(name, date, locationId);
    }

    /**
     * Edycja leku o podanym id
     *
     * @param id leku, który ma być zmodyfikowany
     * @param newName nowa nazwa leku
     * @param newDate nowy termin ważności
     * @param locationId nowe id rekordu z tabeli locations
     * @return true, jeżeli operacje zakończyły się sukcesem
     */
    @RequestMapping(method = RequestMethod.PUT)
    Boolean editMedicament(@RequestParam(value = "id") Long id,
                           @RequestParam(value = "new-name") String newName,
                           @RequestParam(value = "new-date") String newDate,
                           @RequestParam(value = "new-location") Long locationId) {
        MedicamentEditController controller = new MedicamentEditController(medicamentRepository, locationRepository);
        return controller.edit(id, newName, newDate, locationId);
    }

    /**
     * Usunięcie leku o podanym id
     *
     * @param id rekordu, który ma zostać usunięty
     * @return true, jeżeli operacje zakończyły się sukcesem
     */
    @RequestMapping(method = RequestMethod.DELETE)
    Boolean removeMedicament(@RequestParam(value = "id") Long id) {
        MedicamentRemoveController controller = new MedicamentRemoveController(medicamentRepository);
        return controller.remove(id);
    }
}
