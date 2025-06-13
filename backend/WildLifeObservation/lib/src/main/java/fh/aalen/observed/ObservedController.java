package fh.aalen.observed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/observed")
    public List<Observed> getObservedList() {
        return observedService.getAllObservations();
    }

    @RequestMapping("/observed/{id}")
    public Observed getObserved(@PathVariable(value = "id") Long id) {
        return observedService.getObservation(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/observed")
    public void addObserved(@RequestBody Observed observed) {
        // Tier und Ort anhand der ID nachladen (wenn gesetzt)
        if (observed.getAnimal() != null && observed.getAnimal().getId() != 0) {
            Animal animal = animalRepository.findById(observed.getAnimal().getId())
                .orElseThrow(() -> new IllegalArgumentException("Tier nicht gefunden"));
            observed.setAnimal(animal);
        }

        if (observed.getLocation() != null && observed.getLocation().getId() != 0) {
            Location location = locationRepository.findById(observed.getLocation().getId())
                .orElseThrow(() -> new IllegalArgumentException("Ort nicht gefunden"));
            observed.setLocation(location);
        }

        observedService.addObservation(observed);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/observed/{id}")
    public void updateObserved(@PathVariable(value = "id") Long id, @RequestBody Observed observed) {
        observedService.updateObservation(id, observed);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/observed/{id}")
    public void deleteObserved(@PathVariable(value = "id") Long id) {
        observedService.deleteObservation(id);
    }
}
