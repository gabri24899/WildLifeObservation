package fh.aalen.observed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObservedController {

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
