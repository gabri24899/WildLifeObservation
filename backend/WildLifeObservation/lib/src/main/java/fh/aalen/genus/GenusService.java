package fh.aalen.genus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenusService {

    @Autowired
    private GenusRepository genusRepository;

    public List<Genus> getGenusList() {
        ArrayList<Genus> mylist = new ArrayList<>();
        Iterator<Genus> it = genusRepository.findAll().iterator();
        while (it.hasNext())
            mylist.add(it.next());
        return mylist;
    }

    public Genus getGenus(int id) {
        return genusRepository.findById(id).orElse(null);
    }

    public void addGenus(Genus genus) {
        genusRepository.save(genus);
    }

    public void updateGenus(int id, Genus genus) {
        genusRepository.save(genus);
    }

    public void deleteGenus(int id) {
        genusRepository.deleteById(id);
    }
}
