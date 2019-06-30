package com.pgs.apteka.locations.show;

class SimpleLocation {
    private Long id;
    private String name;

    public SimpleLocation(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Wyświetlenie id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Wyśietlenie nazwy
     * @return nazwę
     */
    public String getName() {
        return name;
    }
}
