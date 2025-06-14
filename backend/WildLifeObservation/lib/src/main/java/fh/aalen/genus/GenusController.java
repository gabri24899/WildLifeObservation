package fh.aalen.genus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Stellt HTTP-Endpunkte für Genus-Ressourcen bereit.
 */
@RestController
public class GenusController {

    @Autowired
    private GenusService genusService;

    /**
     * GET-Anfrage: Gibt eine Liste aller Gattungen zurück.
     * 
     * @return Liste von Genus-Objekten
     */
    @RequestMapping("/genus")
    public List<Genus> getGenusList() {
        return genusService.getGenusList();
    }

    /**
     * GET-Anfrage: Gibt eine Gattung anhand der ID zurück.
     * 
     * @param id ID der gesuchten Gattung
     * @return Genus-Objekt
     */
    @RequestMapping("/genus/{id}")
    public Genus getGenus(@PathVariable(value = "id") int id) {
        return genusService.getGenus(id);
    }

    /**
     * POST-Anfrage: Fügt eine neue Gattung hinzu.
     * 
     * @param genus Genus-Objekt zum Hinzufügen
     */
    @RequestMapping(method = RequestMethod.POST, value = "/genus")
    public void addGenus(@RequestBody Genus genus) {
        genusService.addGenus(genus);
    }

    /**
     * PUT-Anfrage: Aktualisiert eine bestehende Gattung anhand der ID.
     * 
     * @param id ID der zu aktualisierenden Gattung
     * @param genus Aktualisierte Genus-Daten
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/genus/{id}")
    public void updateGenus(@PathVariable(value = "id") int id, @RequestBody Genus genus) {
        genusService.updateGenus(id, genus);
    }

    /**
     * DELETE-Anfrage: Löscht eine Gattung anhand der ID.
     * 
     * @param id ID der zu löschenden Gattung
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/genus/{id}")
    public void deleteGenus(@PathVariable(value = "id") int id) {
        genusService.deleteGenus(id);
    }
}
