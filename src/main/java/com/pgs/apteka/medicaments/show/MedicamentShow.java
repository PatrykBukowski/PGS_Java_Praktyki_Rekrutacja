package com.pgs.apteka.medicaments.show;

import com.pgs.apteka.locations.Location;
import com.pgs.apteka.medicaments.Medicament;

import java.time.LocalDate;

public class MedicamentShow implements IMedicaments {
    private Medicament medicament;
    private Location location;

    public MedicamentShow() {
    }

    MedicamentShow(Medicament medicament, Location location) {
        this.medicament = medicament;
        this.location = location;
    }

    /**
     * @return id leku
     */
    public Long getId() {
        return medicament.getId();
    }

    /**
     * @return nazwę leku
     */
    public String getName() {
        return medicament.getName();
    }

    /**
     * @return datę ważności leku
     */
    public LocalDate getExpiryDate() {
        return medicament.getExpiryDate();
    }

    /**
     * @return mejsce składowania leku
     */
    public Location getLocation() {
        return location;
    }
}
