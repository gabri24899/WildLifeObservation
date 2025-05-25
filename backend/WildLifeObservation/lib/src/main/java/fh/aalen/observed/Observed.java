package fh.aalen.observed;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import fh.aalen.animal.Animal;
import fh.aalen.location.Location;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Observed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    @JsonBackReference ("animal-observed") // weil child seite animal und Location sind Parent
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "location_lnr")
    @JsonBackReference ("location-observed")
    private Location location;

    private LocalDate date;
    private LocalTime time;

    public Observed() {}

    public Observed(Animal animal, Location location, LocalDate date, LocalTime time) {
        this.animal = animal;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    // Getter und Setter

    public Long getId() {
        return id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
