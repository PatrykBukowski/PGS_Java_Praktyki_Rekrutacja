package com.pgs.apteka.locations;

import com.pgs.apteka.medicaments.Medicament;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "locations", schema = "public")
public class Location implements ILocations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private Long id;

    @NotBlank
    @Size(max = 250)
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE)
    private List<Medicament> medicamentList;

    public Location(@NotBlank @Size(max = 250) String name) {
        this.name = name;
    }

    public Location() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
