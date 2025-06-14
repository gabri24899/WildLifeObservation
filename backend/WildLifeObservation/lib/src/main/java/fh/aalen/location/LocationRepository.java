package fh.aalen.location;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository-Schnittstelle für Location-Entitäten.
 * Erbt CRUD-Operationen für Location mit Integer als ID-Typ.
 */
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
