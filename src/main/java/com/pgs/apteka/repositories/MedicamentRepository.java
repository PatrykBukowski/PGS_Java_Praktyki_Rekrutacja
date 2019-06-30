package com.pgs.apteka.repositories;

import com.pgs.apteka.medicaments.Medicament;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends CrudRepository<Medicament, Long> {
    Page<Medicament> findAll(Pageable pageable);
}
