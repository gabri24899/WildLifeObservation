package fh.aalen.genus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenusController {

    @Autowired
    private GenusService genusService;

    @RequestMapping("/genus")
    public List<Genus> getGenusList() {
        return genusService.getGenusList();
    }

    @RequestMapping("/genus/{id}")
    public Genus getGenus(@PathVariable(value = "id") int id) {
        return genusService.getGenus(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/genus")
    public void addGenus(@RequestBody Genus genus) {
        genusService.addGenus(genus);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/genus/{id}")
    public void updateGenus(@PathVariable(value = "id") int id, @RequestBody Genus genus) {
        genusService.updateGenus(id, genus);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/genus/{id}")
    public void deleteGenus(@PathVariable(value = "id") int id) {
        genusService.deleteGenus(id);
    }
}
