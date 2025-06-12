package fh.aalen.genus;

import org.springframework.data.repository.CrudRepository;
//Dadurch kann man die CRUD Operationen auf die Genus-Tabelle anwenden
public interface GenusRepository extends CrudRepository<Genus, Integer> {

}
