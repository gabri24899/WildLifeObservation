package fh.aalen.animal;

import org.springframework.data.repository.CrudRepository;
//Repositors um Crud operationen auf Datenbank anzuwenden
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

}
