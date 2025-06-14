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
    @JsonBackReference("animal-observed") // Verhindert zirkuläre Referenzen bei JSON-Serialisierung
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "location_lnr")
    @JsonBackReference("location-observed") // Verhindert zirkuläre Referenzen bei JSON-Serialisierung
    private Location location;

    private LocalDate date;
    private LocalTime time;

    /**
     * Standardkonstruktor.
     */
    public Observed() {}

    /**
     * Konstruktor mit Parametern zur Initialisierung von Tier, Location, Datum und Zeit.
     * Setzt nur IDs bei Animal und Location, nicht die gesamten Objekte.
     * 
     * @param animalId ID des beobachteten Tiers
     * @param locationId ID der Location der Beobachtung
     * @param date Datum der Beobachtung
     * @param time Uhrzeit der Beobachtung
     */
    public Observed(Integer animalId, Integer locationId, LocalDate date, LocalTime time) {
        this.animal = new Animal();
        this.animal.setId(animalId);

        this.location = new Location();
        this.location.setId(locationId);

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

    /**
     * Hilfsmethode zum Abrufen der Tier-ID.
     * 
     * @return ID des Tiers oder null, falls kein Tier gesetzt
     */
    public Integer getAnimalId() {
        return animal != null ? animal.getId() : null;
    }

    /**
     * Hilfsmethode zum Abrufen der Location-ID.
     * 
     * @return ID der Location oder null, falls keine Location gesetzt
     */
    public Integer getLocationId() {
        return location != null ? location.getId() : null;
    }
}
