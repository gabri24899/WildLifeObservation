package fh.aalen.observed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fh.aalen.animal.Animal;
import fh.aalen.animal.AnimalRepository;
import fh.aalen.location.Location;
import fh.aalen.location.LocationRepository;

@RestController
public class ObservedController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ObservedService observedService;

    /**
     * Liefert die Liste aller Beobachtungen.
     * 
     * @return Liste aller Observed-Objekte
     */
    @RequestMapping("/observed")
    public List<Observed> getObservedList() {
        return observedService.getAllObservations();
    }

    /**
     * Liefert eine einzelne Beobachtung anhand der ID.
     * 
     * @param id ID der Beobachtung
     * @return Observed-Objekt oder null, falls nicht gefunden
     */
    @RequestMapping("/observed/{id}")
    public Observed getObserved(@PathVariable(value = "id") Long id) {
        return observedService.getObservation(id);
    }

    /**
     * Fügt eine neue Beobachtung hinzu.
     * Lädt dabei Tier und Ort anhand der IDs aus der Datenbank nach.
     * 
     * @param observed Beobachtungsobjekt mit Tier- und Orts-IDs
     */
    @RequestMapping(method = RequestMethod.POST, value = "/observed")
    public void addObserved(@RequestBody Observed observed) {
        // Tier anhand der ID laden, falls gesetzt
        if (observed.getAnimal() != null && observed.getAnimal().getId() != 0) {
            Animal animal = animalRepository.findById(observed.getAnimal().getId())
                .orElseThrow(() -> new IllegalArgumentException("Tier nicht gefunden"));
            observed.setAnimal(animal);
        }

        // Ort anhand der ID laden, falls gesetzt
        if (observed.getLocation() != null && observed.getLocation().getId() != 0) {
            Location location = locationRepository.findById(observed.getLocation().getId())
                .orElseThrow(() -> new IllegalArgumentException("Ort nicht gefunden"));
            observed.setLocation(location);
        }

        observedService.addObservation(observed);
    }

    /**
     * Aktualisiert eine vorhandene Beobachtung.
     * 
     * @param id ID der Beobachtung
     * @param observed Beobachtungsobjekt mit neuen Daten
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/observed/{id}")
    public void updateObserved(@PathVariable(value = "id") Long id, @RequestBody Observed observed) {
        observedService.updateObservation(id, observed);
    }

    /**
     * Löscht eine Beobachtung anhand der ID.
     * 
     * @param id ID der zu löschenden Beobachtung
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/observed/{id}")
    public void deleteObserved(@PathVariable(value = "id") Long id) {
        observedService.deleteObservation(id);
    }
}
