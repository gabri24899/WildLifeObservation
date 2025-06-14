package fh.aalen.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-Controller für die Verwaltung von Animal-Entitäten.
 */
@RestController
public class AnimalController {

    @Autowired
    AnimalService animalService;

    /**
     * Gibt die Liste aller Tiere zurück.
     * 
     * @return Liste aller Animals
     */
    @RequestMapping("/animal")
    public List<Animal> getAnimalList() {
        return animalService.getAnimalList();
    }

    /**
     * Gibt ein einzelnes Tier anhand der ID zurück.
     * 
     * @param id ID des gesuchten Tiers
     * @return Animal-Objekt
     */
    @RequestMapping("/animal/{id}")
    public Animal getAnimal(@PathVariable(value = "id") int id) {
        return animalService.getAnimal(id);
    }

    /**
     * Fügt ein neues Tier hinzu.
     * 
     * @param animal Neues Animal-Objekt
     */
    @RequestMapping(method = RequestMethod.POST, value = "/animal")
    public void addAnimal(@RequestBody Animal animal) {
        animalService.addAnimal(animal);
    }

    /**
     * Aktualisiert ein vorhandenes Tier anhand der ID.
     * 
     * @param id ID des zu aktualisierenden Tiers
     * @param animal Aktualisierte Daten
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/animal/{id}")
    public void updateAnimal(@PathVariable(value = "id") int id, @RequestBody Animal animal) {
        animalService.updateAnimal(id, animal);
    }

    /**
     * Löscht ein Tier anhand der ID.
     * 
     * @param id ID des zu löschenden Tiers
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/animal/{id}")
    public void deleteAnimal(@PathVariable(value = "id") int id) {
        animalService.deleteAnimal(id);
    }
}
