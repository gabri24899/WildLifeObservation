package fh.aalen.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
@Autowired
AnimalService animalService;
@RequestMapping("/animal")
public List<Animal> getAnimalList() {
return animalService.getAnimalList();
}
@RequestMapping("/animal/{id}")
public Animal getAnimal(@PathVariable(value="id")int id) {
return animalService.getAnimal(id);
}
@RequestMapping(method=RequestMethod.POST, value="/animal")
public void addAnimal(@RequestBody Animal animal) {
animalService.addAnimal(animal);
}
@RequestMapping(method=RequestMethod.PUT, value="/animal/{id}")
public void updateAnimal(@PathVariable(value="id")int id, @RequestBody Animal animal) {
animalService.updateAnimal(id, animal);
}
@RequestMapping(method=RequestMethod.DELETE, value="/animal/{id}")
public void deleteAnimal(@PathVariable(value="id") int id) {
animalService.deleteAnimal(id);
}
}