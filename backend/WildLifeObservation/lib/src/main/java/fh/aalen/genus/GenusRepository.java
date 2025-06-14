package fh.aalen.genus;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository-Interface für Genus-Entität.
 * Ermöglicht CRUD-Operationen auf der Genus-Tabelle.
 */
public interface GenusRepository extends CrudRepository<Genus, Integer> {

}
