package com.pgs.apteka.medicaments.show;

import com.pgs.apteka.medicaments.Medicament;
import com.pgs.apteka.repositories.MedicamentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MedicamentShowController {
    private MedicamentRepository medicamentRepository;

    public MedicamentShowController() {
    }

    public MedicamentShowController(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    /**
     * Wyświetla listę rekordów z tabeli medicaments.
     *
     * @param sortBy pozwala sortować listę.
     *               "name" - sortowanie za pomocą tabeli name.
     *               "location" - za pomocą nazwy miejsca składowani leku
     *               inne - za pomocą id
     * @return obiekt klasy SimpleMedicamentShow, który parsowany jest do JSON.
     */
    public SimpleMedicamentShow getMedicaments(String sortBy) {
        ArrayList<SimpleMedicament> medicaments = new ArrayList<>();
        for (Medicament medicament :
                medicamentRepository.findAll()) {
            medicaments.add(new SimpleMedicament(medicament.getId(), medicament.getName(), medicament.getLocation().getName()));
        }
        switch (sortBy) {
            case "name":
                medicaments.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
                break;
            case "location":
                medicaments.sort((o1, o2) -> o1.getLocation().compareToIgnoreCase(o2.getLocation()));
                break;
            default:
                medicaments.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
        }
        return new SimpleMedicamentShow(medicaments);
    }

    /**
     * Jeżeli istnieje w tabeli rekord o podanym id, rekord ten wyświetlony jest za pomocą
     * obiektu Medicament. W przeciwnym wypadku wywoływana jest metoda <code>getMedicaments</code>
     * @param id id rekordu, który ma być wyświetlony
     * @return Medicament lub SimpleMedicamentShow, parsowany do JSON.
     */
    public IMedicaments getOne(Long id) {
        if (medicamentRepository.findById(id).isPresent())
            return medicamentRepository.findById(id).get();
        else
            return getMedicaments("id");
    }

    /**
     * Wyświetlana jest lista rekordów, poddana paginacji.
     * Ilośc obiektów na stronie ustawiona jest na 2.
     * @param page strona, która ma zostać wyświetlona
     * @return obiekt Klasy Page, zawierający obiekty klasy Medicament
     */
    public Page<Medicament> getMedicamentsPageable(int page) {
        return medicamentRepository.findAll(PageRequest.of(page, 2));
    }
}
