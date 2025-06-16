package fh.aalen.observed;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fh.aalen.animal.Animal;
import fh.aalen.animal.AnimalRepository;
import fh.aalen.location.Location;
import fh.aalen.location.LocationRepository;

@RestController
public class ObservedController {

    private static final Logger logger = LoggerFactory.getLogger(ObservedController.class);

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
        logger.info("GET /observed - Rufe Liste aller Beobachtungen ab");
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
        logger.info("GET /observed/{} - Rufe Beobachtung mit ID {} ab", id, id);
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
        logger.info("POST /observed - Füge neue Beobachtung hinzu");

        if (observed.getAnimal() != null && observed.getAnimal().getId() != 0) {
            logger.info("Lade Tier mit ID {}", observed.getAnimal().getId());
            Animal animal = animalRepository.findById(observed.getAnimal().getId())
                .orElseThrow(() -> new IllegalArgumentException("Tier nicht gefunden"));
            observed.setAnimal(animal);
        }

        if (observed.getLocation() != null && observed.getLocation().getId() != 0) {
            logger.info("Lade Location mit ID {}", observed.getLocation().getId());
            Location location = locationRepository.findById(observed.getLocation().getId())
                .orElseThrow(() -> new IllegalArgumentException("Ort nicht gefunden"));
            observed.setLocation(location);
        }

        observedService.addObservation(observed);
        logger.info("Beobachtung erfolgreich hinzugefügt");
    }

    /**
     * Aktualisiert eine vorhandene Beobachtung.
     * 
     * @param id ID der Beobachtung
     * @param observed Beobachtungsobjekt mit neuen Daten
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/observed/{id}")
    public void updateObserved(@PathVariable(value = "id") Long id, @RequestBody Observed observed) {
        logger.info("PUT /observed/{} - Aktualisiere Beobachtung mit ID {}", id, id);
        observedService.updateObservation(id, observed);
    }

    /**
     * Löscht eine Beobachtung anhand der ID.
     * 
     * @param id ID der zu löschenden Beobachtung
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/observed/{id}")
    public void deleteObserved(@PathVariable(value = "id") Long id) {
        logger.info("DELETE /observed/{} - Lösche Beobachtung mit ID {}", id, id);
        observedService.deleteObservation(id);
    }
}
