package com.pgs.apteka.medicaments.edit;

import com.pgs.apteka.repositories.MedicamentRepository;

public class MedicamentRemoveController {
    private MedicamentRepository medicamentRepository;

    public MedicamentRemoveController(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    /**
     * usuwa rekord z tabeli
     *
     * @param id rekordu, który ma być usunięty
     * @return tue, jeżeli w tabeli Medicaments znajdował się rekord o podanym id
     */
    public boolean remove(Long id) {
        if (medicamentRepository.findById(id).isPresent()) {
            medicamentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
