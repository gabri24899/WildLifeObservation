package fh.aalen.animal;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository-Interface für Animal-Entitäten.
 * Ermöglicht CRUD-Operationen auf der Datenbank.
 */
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

}
