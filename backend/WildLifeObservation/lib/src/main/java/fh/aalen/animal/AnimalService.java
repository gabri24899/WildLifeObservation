package fh.aalen.animal;

import java.util.ArrayList;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fh.aalen.genus.Genus;
import fh.aalen.genus.GenusRepository;

/**
 * Serviceklasse für Geschäftslogik rund um Animal-Entitäten.
 */
@Service
public class AnimalService {

    private static final Logger logger = LoggerFactory.getLogger(AnimalService.class);

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private GenusRepository genusRepository;

    private void validateAnimal(Animal animal) {
        if (String.valueOf(animal.getId()).length() > 6) {
            throw new IllegalArgumentException("ID darf höchstens 6-stellig sein.");
        }
        if (animal.getEstimatedAge() > 999) {
            throw new IllegalArgumentException("Alter darf höchstens 3-stellig sein.");
        }
        if (animal.getEstimatedWeight() > 999999) {
            throw new IllegalArgumentException("Gewicht darf höchstens 6-stellig sein.");
        }
        if (animal.getEstimatedSize() > 9999) {
            throw new IllegalArgumentException("Größe darf höchstens 4-stellig sein.");
        }
    }
    public List<Animal> getAnimalList() {
        logger.info("Rufe Liste aller Tiere ab.");
        ArrayList<Animal> mylist = new ArrayList<>();
        Iterator<Animal> it = animalRepository.findAll().iterator();
        while (it.hasNext()) {
            mylist.add(it.next());
        }
        logger.debug("Anzahl gefundener Tiere: {}", mylist.size());
        return mylist;
    }

    public Animal getAnimal(int id) {
        logger.info("Suche Tier mit ID: {}", id);
        Animal animal = animalRepository.findById(id).orElse(null);
        if (animal == null) {
            logger.warn("Kein Tier mit ID {} gefunden.", id);
        }
        return animal;
    }

    public void addAnimal(Animal animal) {
        logger.info("Füge neues Tier hinzu: {}", animal);
        validateAnimal(animal);
        if (animalRepository.existsById(animal.getId())) {
            logger.warn("Tier mit ID {} existiert bereits.", animal.getId());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Tier schon vorhanden");
        }
        if (animal.getGenus() != null && animal.getGenus().getId() != 0) {
            Genus genus = genusRepository.findById(animal.getGenus().getId()).orElse(null);
            animal.setGenus(genus);
        } else {
            animal.setGenus(null);
        }
        animalRepository.save(animal);
        logger.debug("Tier erfolgreich gespeichert: {}", animal);
    }

    public void updateAnimal(int id, Animal animal) {
        logger.info("Aktualisiere Tier mit ID: {}", id);
        validateAnimal(animal);
        if (animal.getGenus() != null && animal.getGenus().getId() != 0) {
            Genus genus = genusRepository.findById(animal.getGenus().getId()).orElse(null);
            animal.setGenus(genus);
        } else {
            animal.setGenus(null);
        }
        animalRepository.save(animal);
        logger.debug("Tier mit ID {} erfolgreich aktualisiert.", id);
    }

    public void deleteAnimal(int id) {
        logger.info("Lösche Tier mit ID: {}", id);
        animalRepository.deleteById(id);
        logger.debug("Tier mit ID {} wurde gelöscht.", id);
    }
}
