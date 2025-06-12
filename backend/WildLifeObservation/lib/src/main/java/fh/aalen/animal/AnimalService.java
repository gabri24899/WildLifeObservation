package fh.aalen.animal;

import java.util.ArrayList; // ist alles geändert mit import Genus repo 
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fh.aalen.genus.Genus;
import fh.aalen.genus.GenusRepository;

@Service // Dadurch wird Klasse als Service Komponente gekennzeichnet
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private GenusRepository genusRepository;

    // Gibt Liste der Tiere in Datenbank zurück
    public List<Animal> getAnimalList() {
        ArrayList<Animal> mylist = new ArrayList<>();
        Iterator<Animal> it = animalRepository.findAll().iterator();
        while (it.hasNext())
            mylist.add(it.next());
        return mylist;
    }

    // Gibt ein Tier anhand der ID zurück
    public Animal getAnimal(int id) {
        return animalRepository.findById(id).orElse(null);
    }

    // Fügt ein Tier hinzu
    public void addAnimal(Animal animal) {
        if (animal.getGenus() != null && animal.getGenus().getId() != 0) {
            Genus genus = genusRepository.findById(animal.getGenus().getId()).orElse(null);
            animal.setGenus(genus);
        } else {
            animal.setGenus(null);
        }
        animalRepository.save(animal);
    }

    // Aktualisiert ein Tier
    public void updateAnimal(int id, Animal animal) {
        if (animal.getGenus() != null && animal.getGenus().getId() != 0) {
            Genus genus = genusRepository.findById(animal.getGenus().getId()).orElse(null);
            animal.setGenus(genus);
        } else {
            animal.setGenus(null);
        }
        animalRepository.save(animal);
    }

    // Löscht ein Tier
    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }
}
