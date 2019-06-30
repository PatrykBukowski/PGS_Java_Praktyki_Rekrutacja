package com.pgs.apteka.locations.show;

import com.pgs.apteka.locations.ILocations;

import java.util.ArrayList;

public class SimpleLocationShow implements ILocations {
    private ArrayList<SimpleLocation> locations;

    public SimpleLocationShow(ArrayList<SimpleLocation> locations) {
        this.locations = locations;
    }

    public SimpleLocationShow() {
    }

    /**
     * Wyświetlenie listy obiektów klasy SimpleLocation
     * @return listę obiektów
     */
    public ArrayList<SimpleLocation> getLocations() {
        return locations;
    }
}
