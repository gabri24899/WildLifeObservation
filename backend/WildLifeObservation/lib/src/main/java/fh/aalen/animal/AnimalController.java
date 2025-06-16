package fh.aalen.animal;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);

    @Autowired
    AnimalService animalService;

    @RequestMapping("/animal")
    public List<Animal> getAnimalList() {
        logger.info("GET /animal - Rufe Liste aller Tiere ab");
        return animalService.getAnimalList();
    }

    @RequestMapping("/animal/{id}")
    public Animal getAnimal(@PathVariable(value = "id") int id) {
        logger.info("GET /animal/{} - Rufe Tier mit ID {} ab", id, id);
        return animalService.getAnimal(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/animal")
    public void addAnimal(@RequestBody Animal animal) {
        logger.info("POST /animal - Füge neues Tier hinzu: {}", animal);
        animalService.addAnimal(animal);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/animal/{id}")
    public void updateAnimal(@PathVariable(value = "id") int id, @RequestBody Animal animal) {
        logger.info("PUT /animal/{} - Aktualisiere Tier mit ID {}", id, id);
        animalService.updateAnimal(id, animal);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/animal/{id}")
    public void deleteAnimal(@PathVariable(value = "id") int id) {
        logger.info("DELETE /animal/{} - Lösche Tier mit ID {}", id, id);
        animalService.deleteAnimal(id);
    }
}
