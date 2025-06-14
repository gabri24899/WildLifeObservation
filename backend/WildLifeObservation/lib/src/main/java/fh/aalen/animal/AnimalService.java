package fh.aalen.animal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fh.aalen.genus.Genus;
import fh.aalen.genus.GenusRepository;

/**
 * Serviceklasse für Geschäftslogik rund um Animal-Entitäten.
 */
@Service // Dadurch wird die Klasse als Service-Komponente gekennzeichnet
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private GenusRepository genusRepository;

    /**
     * Gibt eine Liste aller Tiere in der Datenbank zurück.
     * 
     * @return Liste von Animal-Objekten
     */
    public List<Animal> getAnimalList() {
        ArrayList<Animal> mylist = new ArrayList<>();
        Iterator<Animal> it = animalRepository.findAll().iterator();
        while (it.hasNext()) {
            mylist.add(it.next());
        }
        return mylist;
    }

    /**
     * Gibt ein Tier anhand der ID zurück.
     * 
     * @param id ID des gesuchten Tiers
     * @return Animal-Objekt oder null, falls nicht gefunden
     */
    public Animal getAnimal(int id) {
        return animalRepository.findById(id).orElse(null);
    }

    /**
     * Fügt ein neues Tier in die Datenbank ein.
     * Prüft dabei, ob eine gültige Genus-ID vorhanden ist.
     * 
     * @param animal Neues Animal-Objekt
     */
    public void addAnimal(Animal animal) {
        if (animal.getGenus() != null && animal.getGenus().getId() != 0) {
            Genus genus = genusRepository.findById(animal.getGenus().getId()).orElse(null);
            animal.setGenus(genus);
        } else {
            animal.setGenus(null);
        }
        animalRepository.save(animal);
    }

    /**
     * Aktualisiert ein bestehendes Tier anhand der ID.
     * 
     * @param id ID des zu aktualisierenden Tiers
     * @param animal Aktualisierte Daten des Tiers
     */
    public void updateAnimal(int id, Animal animal) {
        if (animal.getGenus() != null && animal.getGenus().getId() != 0) {
            Genus genus = genusRepository.findById(animal.getGenus().getId()).orElse(null);
            animal.setGenus(genus);
        } else {
            animal.setGenus(null);
        }
        animalRepository.save(animal);
    }

    /**
     * Löscht ein Tier anhand der ID.
     * 
     * @param id ID des zu löschenden Tiers
     */
    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }
}
