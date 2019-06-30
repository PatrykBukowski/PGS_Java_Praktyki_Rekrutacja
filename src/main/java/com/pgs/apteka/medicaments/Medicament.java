package com.pgs.apteka.medicaments;

import com.pgs.apteka.locations.Location;
import com.pgs.apteka.medicaments.show.IMedicaments;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "medicaments", schema = "public")
public class Medicament implements IMedicaments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicament")
    private Long id;

    @NotBlank
    @Size(max = 250)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @ManyToOne(targetEntity = Location.class, fetch = FetchType.EAGER)
    @JoinColumn(name="id_location")
    Location location;

    public Medicament(@NotBlank @Size(max = 250) String name, @NotNull LocalDate expiryDate, Location location) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.location = location;
    }

    public Medicament() {
    }

    public Location getLocation() {
        return location;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
