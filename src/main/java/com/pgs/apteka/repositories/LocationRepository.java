package com.pgs.apteka.repositories;

import com.pgs.apteka.locations.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
    Page<Location> findAll(Pageable pageable);
}
