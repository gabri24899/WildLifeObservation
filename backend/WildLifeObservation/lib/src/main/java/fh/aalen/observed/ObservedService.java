package fh.aalen.observed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservedService {

    private static final Logger logger = LoggerFactory.getLogger(ObservedService.class);

    @Autowired
    private ObservedRepository observedRepository;

    /**
     * Gibt eine Liste aller Beobachtungen zurück.
     * 
     * @return Liste aller Observed-Objekte
     */
    public List<Observed> getAllObservations() {
        logger.info("Rufe alle Beobachtungen ab");
        ArrayList<Observed> mylist = new ArrayList<>();
        Iterator<Observed> it = observedRepository.findAll().iterator();
        while (it.hasNext()) {
            mylist.add(it.next());
        }
        
        logger.info("Anzahl gefundener Beobachtungen: {}", mylist.size());
        return mylist;
    }

    /**
     * Gibt eine einzelne Beobachtung anhand der ID zurück.
     * 
     * @param id ID der Beobachtung
     * @return Observed-Objekt oder null, falls nicht gefunden
     */
    public Observed getObservation(Long id) {
        logger.info("Suche Beobachtung mit ID {}", id);
        return observedRepository.findById(id).orElse(null);
    }

    /**
     * Fügt eine neue Beobachtung hinzu.
     * 
     * @param observed Beobachtungsobjekt
     */
    public void addObservation(Observed observed) {
        logger.info("Füge neue Beobachtung hinzu: {}", observed);
        observedRepository.save(observed);
    }

    /**
     * Aktualisiert eine bestehende Beobachtung.
     * 
     * @param id ID der Beobachtung
     * @param observed Beobachtungsobjekt mit aktualisierten Daten
     */
    public void updateObservation(Long id, Observed observed) {
        logger.info("Aktualisiere Beobachtung mit ID {}", id);
        observedRepository.save(observed);
    }

    /**
     * Löscht eine Beobachtung anhand der ID.
     * 
     * @param id ID der Beobachtung
     */
    public void deleteObservation(Long id) {
        logger.info("Lösche Beobachtung mit ID {}", id);
        observedRepository.deleteById(id);
    }
}
