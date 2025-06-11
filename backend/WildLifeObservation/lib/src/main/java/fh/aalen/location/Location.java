package fh.aalen.location;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

import fh.aalen.observed.Observed;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Location {

    @Id
    
    private int id;

    private String shortTitle;
    private String description;

    @OneToMany(mappedBy = "location")
    @JsonManagedReference("location-observed")
    private List<Observed> observations;

    // Standardkonstruktor
    public Location() {
        super();
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Observed> getObservations() {
        return observations;
    }

    public void setObservations(List<Observed> observations) {
        this.observations = observations;
    }
}
