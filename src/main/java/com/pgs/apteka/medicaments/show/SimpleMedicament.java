package com.pgs.apteka.medicaments.show;

public class SimpleMedicament {
    private Long id;
    private String name;
    private String location;


    SimpleMedicament(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public SimpleMedicament() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
