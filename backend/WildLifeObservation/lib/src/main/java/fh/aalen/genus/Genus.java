package fh.aalen.genus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fh.aalen.animal.Animal;

/**
 * Entität für Genus (Gattung). Stellt die Tabelle 'Genus' in der Datenbank dar.
 */
@Entity // Für die Datenbank: legt die Klasse als Entität fest
public class Genus {

    @Id  // Primärschlüssel
    private int id;

    private String latinDesignation;
    private String designation;

    @OneToMany(mappedBy = "genus") // Eine Gattung kann mehrere Tiere beinhalten (1:n)
    @JsonIgnoreProperties("genus") // Verhindert Endlosschleifen bei der Serialisierung
    private List<Animal> animals;

    // Standardkonstruktor
    public Genus() {
        super();
    }

    // Konstruktor mit Attributen
    public Genus(int id, String latinDesignation, String designation) {
        super();
        this.id = id;
        this.latinDesignation = latinDesignation;
        this.designation = designation;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatinDesignation() {
        return latinDesignation;
    }

    public void setLatinDesignation(String latinDesignation) {
        this.latinDesignation = latinDesignation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
