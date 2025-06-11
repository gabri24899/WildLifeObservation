package fh.aalen.observed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservedService {

    @Autowired
    private ObservedRepository observedRepository;

    public List<Observed> getAllObservations() {
        ArrayList<Observed> mylist = new ArrayList<>();
        Iterator<Observed> it = observedRepository.findAll().iterator();
        while (it.hasNext()) {
            mylist.add(it.next());
        }
        return mylist;
    }

    public Observed getObservation(Long id) {
        return observedRepository.findById(id).orElse(null);
    }

    public void addObservation(Observed observed) {
        observedRepository.save(observed);
    }

    public void updateObservation(Long id, Observed observed) {
        observedRepository.save(observed);
    }

    public void deleteObservation(Long id) {
        observedRepository.deleteById(id);
    }
}
