package fh.aalen.observed;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository-Schnittstelle für CRUD-Operationen auf Observed-Entitäten.
 */
public interface ObservedRepository extends CrudRepository<Observed, Long> {
}
