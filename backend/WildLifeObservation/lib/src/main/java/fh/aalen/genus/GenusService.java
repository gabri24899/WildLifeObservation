package fh.aalen.genus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Markiert die Klasse als Service-Komponente
public class GenusService {

    @Autowired
    private GenusRepository genusRepository;

    /**
     * Gibt eine Liste aller Gattungen zurück.
     * 
     * @return Liste aller Gattungen aus der Datenbank
     */
    public List<Genus> getGenusList() {
        // Erzeugt eine neue Liste und füllt sie mit Einträgen aus der Datenbank
        ArrayList<Genus> mylist = new ArrayList<>();
        Iterator<Genus> it = genusRepository.findAll().iterator();
        while (it.hasNext()) {
            mylist.add(it.next());
        }
        return mylist;
    }
    
    /**
     * Gibt eine Gattung anhand der ID zurück.
     * 
     * @param id ID der Gattung
     * @return Gattung mit der gegebenen ID oder null, falls nicht gefunden
     */
    public Genus getGenus(int id) {
        return genusRepository.findById(id).orElse(null);
    }
    
    /**
     * Fügt eine neue Gattung in die Datenbank ein.
     * 
     * @param genus Gattung, die hinzugefügt werden soll
     */
    public void addGenus(Genus genus) {
        genusRepository.save(genus);
    }
    
    /**
     * Aktualisiert eine vorhandene Gattung.
     * 
     * @param id ID der zu aktualisierenden Gattung
     * @param genus Gattung mit den neuen Daten
     */
    public void updateGenus(int id, Genus genus) {
        genusRepository.save(genus);
    }

    /**
     * Löscht eine Gattung anhand der ID.
     * 
     * @param id ID der zu löschenden Gattung
     */
    public void deleteGenus(int id) {
        genusRepository.deleteById(id);
    }
}
