package fh.aalen.genus;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service // Markiert die Klasse als Service-Komponente
public class GenusService {

    private static final Logger logger = LoggerFactory.getLogger(GenusService.class);

    @Autowired
    private GenusRepository genusRepository;
    private void validateGenus(Genus genus) {
        if (String.valueOf(genus.getId()).length() > 6) {
            throw new IllegalArgumentException("ID darf höchstens 6-stellig sein.");
        }
    }
    /**
     * Gibt eine Liste aller Gattungen zurück.
     * 
     * @return Liste aller Gattungen aus der Datenbank
     */
    public List<Genus> getGenusList() {
        logger.info("Rufe Liste aller Gattungen ab.");
        ArrayList<Genus> mylist = new ArrayList<>();
        Iterator<Genus> it = genusRepository.findAll().iterator();
        while (it.hasNext()) {
            mylist.add(it.next());
        }
        logger.debug("Anzahl gefundener Gattungen: {}", mylist.size());
        return mylist;
    }
    
    /**
     * Gibt eine Gattung anhand der ID zurück.
     * 
     * @param id ID der Gattung
     * @return Gattung mit der gegebenen ID oder null, falls nicht gefunden
     */
    public Genus getGenus(int id) {
        logger.info("Suche Gattung mit ID: {}", id);
        return genusRepository.findById(id).orElse(null);
    }
    
    /**
     * Fügt eine neue Gattung in die Datenbank ein.
     * 
     * @param genus Gattung, die hinzugefügt werden soll
     */
    public void addGenus(Genus genus) {
        logger.info("Füge neue Gattung hinzu: {}", genus.getDesignation());
        validateGenus(genus);
        if (genusRepository.existsById(genus.getId())) {
            logger.warn("Gattung mit ID {} existiert bereits.", genus.getId());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Gattung schon vorhanden");
        }
        genusRepository.save(genus);
    }
    
    /**
     * Aktualisiert eine vorhandene Gattung.
     * 
     * @param id ID der zu aktualisierenden Gattung
     * @param genus Gattung mit den neuen Daten
     */
    public void updateGenus(int id, Genus genus) {
        logger.info("Aktualisiere Gattung mit ID: {}", id);
        validateGenus(genus);
        genusRepository.save(genus);
    }

    /**
     * Löscht eine Gattung anhand der ID.
     * 
     * @param id ID der zu löschenden Gattung
     */
    public void deleteGenus(int id) {
        logger.info("Lösche Gattung mit ID: {}", id);
        genusRepository.deleteById(id);
    }
}
