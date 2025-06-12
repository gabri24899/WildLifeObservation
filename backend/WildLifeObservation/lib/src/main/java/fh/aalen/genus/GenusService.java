package fh.aalen.genus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //dadurch wird die Klasse als Service markiert
public class GenusService {

    @Autowired
    private GenusRepository genusRepository;

    //Gibt Liste aller Gatungen zurück
    public List<Genus> getGenusList() {
    	
    	//Erstellt neue Liste und füllt sie mit Datenbank einträgen
        ArrayList<Genus> mylist = new ArrayList<>();
        Iterator<Genus> it = genusRepository.findAll().iterator();
        while (it.hasNext())
            mylist.add(it.next());
        return mylist;
    }
    
    //Gibt Gattung anhand von ID zurück
    public Genus getGenus(int id) {
        return genusRepository.findById(id).orElse(null);
    }
    
    //fügt neue Gattung zur Datenbank hinzu
    public void addGenus(Genus genus) {
        genusRepository.save(genus);
    }
    
    //ändert vorhandene Gattung
    public void updateGenus(int id, Genus genus) {
        genusRepository.save(genus);
    }

    //löscht eine Gattung anhand von der ID
    public void deleteGenus(int id) {
        genusRepository.deleteById(id);
    }
}
