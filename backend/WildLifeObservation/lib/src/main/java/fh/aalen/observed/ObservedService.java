package fh.aalen.observed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservedService {

    @Autowired
    private ObservedRepository observedRepository;

    /**
     * Gibt eine Liste aller Beobachtungen zurück.
     * 
     * @return Liste aller Observed-Objekte
     */
    public List<Observed> getAllObservations() {
        ArrayList<Observed> mylist = new ArrayList<>();
        Iterator<Observed> it = observedRepository.findAll().iterator();
        while (it.hasNext()) {
            mylist.add(it.next());
        }
        return mylist;
    }

    /**
     * Gibt eine einzelne Beobachtung anhand der ID zurück.
     * 
     * @param id ID der Beobachtung
     * @return Observed-Objekt oder null, falls nicht gefunden
     */
    public Observed getObservation(Long id) {
        return observedRepository.findById(id).orElse(null);
    }

    /**
     * Fügt eine neue Beobachtung hinzu.
     * 
     * @param observed Beobachtungsobjekt
     */
    public void addObservation(Observed observed) {
        observedRepository.save(observed);
    }

    /**
     * Aktualisiert eine bestehende Beobachtung.
     * 
     * @param id ID der Beobachtung
     * @param observed Beobachtungsobjekt mit aktualisierten Daten
     */
    public void updateObservation(Long id, Observed observed) {
        observedRepository.save(observed);
    }

    /**
     * Löscht eine Beobachtung anhand der ID.
     * 
     * @param id ID der Beobachtung
     */
    public void deleteObservation(Long id) {
        observedRepository.deleteById(id);
    }
}
