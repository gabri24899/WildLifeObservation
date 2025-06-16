package fh.aalen.animal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

import fh.aalen.genus.Genus;
import fh.aalen.observed.Observed;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entität für Tiere. Stellt die Tabelle 'Animal' in der Datenbank dar.
 */
@Entity
public class Animal {

    @Id // Primärschlüssel
    
    private int id;

    private String gender;
    private int estimatedAge;
    private double estimatedWeight;
    private double estimatedSize;

    // 1:n Beziehung zu den Beobachtungen (Observed)
    @OneToMany(mappedBy = "animal")
    @JsonManagedReference("animal-observed") // Verhindert Endlosschleifen bei der Serialisierung
    private List<Observed> observations;

    // n:1 Beziehung zur Gattung (Genus)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genus_id")
    @JsonIgnoreProperties("animals") // Ignoriert die Liste animals, um Endlosschleifen zu vermeiden
    private Genus genus;

    // Standardkonstruktor
    public Animal() {
        super();
    }

    // Konstruktor mit Attributen
    public Animal(int id, String gender, int estimatedAge, double estimatedWeight, double estimatedSize) {
        super();
        this.id = id;
        this.gender = gender;
        this.estimatedAge = estimatedAge;
        this.estimatedWeight = estimatedWeight;
        this.estimatedSize = estimatedSize;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEstimatedAge() {
        return estimatedAge;
    }

    public void setEstimatedAge(int estimatedAge) {
        this.estimatedAge = estimatedAge;
    }

    public double getEstimatedWeight() {
        return estimatedWeight;
    }

    public void setEstimatedWeight(double estimatedWeight) {
        this.estimatedWeight = estimatedWeight;
    }

    public double getEstimatedSize() {
        return estimatedSize;
    }

    public void setEstimatedSize(double estimatedSize) {
        this.estimatedSize = estimatedSize;
    }

    public List<Observed> getObservations() {
        return observations;
    }

    public void setObservations(List<Observed> observations) {
        this.observations = observations;
    }

    public Genus getGenus() {
        return genus;
    }

    public void setGenus(Genus genus) {
        this.genus = genus;
    }
}
