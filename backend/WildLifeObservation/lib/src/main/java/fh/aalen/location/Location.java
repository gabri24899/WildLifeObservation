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

    /**
     * Standardkonstruktor.
     */
    public Location() {
        super();
    }

    // Getter und Setter

    /**
     * Liefert die ID der Location.
     * 
     * @return id der Location
     */
    public int getId() {
        return id;
    }

    /**
     * Setzt die ID der Location.
     * 
     * @param id neue ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Liefert den kurzen Titel der Location.
     * 
     * @return shortTitle
     */
    public String getShortTitle() {
        return shortTitle;
    }

    /**
     * Setzt den kurzen Titel der Location.
     * 
     * @param shortTitle neuer kurzer Titel
     */
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    /**
     * Liefert die Beschreibung der Location.
     * 
     * @return Beschreibung
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setzt die Beschreibung der Location.
     * 
     * @param description neue Beschreibung
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Liefert die Liste der Beobachtungen, die mit dieser Location verbunden sind.
     * 
     * @return Liste von Observed-Objekten
     */
    public List<Observed> getObservations() {
        return observations;
    }

    /**
     * Setzt die Liste der Beobachtungen.
     * 
     * @param observations neue Liste von Observed-Objekten
     */
    public void setObservations(List<Observed> observations) {
        this.observations = observations;
    }
}
