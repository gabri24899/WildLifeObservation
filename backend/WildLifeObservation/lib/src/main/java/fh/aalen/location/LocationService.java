package fh.aalen.location;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class LocationService {

    private static final Logger logger = LoggerFactory.getLogger(LocationService.class);

    @Autowired
    private LocationRepository locationRepository;
    
    private void validateLocation(Location location) {
        if (String.valueOf(location.getId()).length() > 6) {
            throw new IllegalArgumentException("ID darf höchstens 6-stellig sein.");
        }
    }
    /**
     * Gibt eine Liste aller Locations zurück.
     * 
     * @return Liste aller Locations aus der Datenbank
     */
    public List<Location> getLocationList() {
        logger.info("Rufe Liste aller Locations aus der Datenbank ab");
        ArrayList<Location> mylist = new ArrayList<>();
        Iterator<Location> it = locationRepository.findAll().iterator();
        while (it.hasNext()) {
            mylist.add(it.next());
        }
        logger.info("Anzahl gefundener Locations: {}", mylist.size());
        return mylist;
    }

    /**
     * Gibt eine Location anhand der ID zurück.
     * 
     * @param lnr ID der Location
     * @return Location-Objekt oder null, falls nicht gefunden
     */
    public Location getLocation(int lnr) {
        logger.info("Suche Location mit ID {}", lnr);
        return locationRepository.findById(lnr).orElse(null);
    }

    /**
     * Fügt eine neue Location hinzu.
     * 
     * @param location Location-Objekt, das gespeichert werden soll
     */
    public void addLocation(Location location) {
        logger.info("Füge neue Location hinzu: {}", location);
        validateLocation(location);
        if (locationRepository.existsById(location.getId())) {
            logger.warn("Location mit ID {} existiert bereits.", location.getId());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ort schon vorhanden");
        }
        locationRepository.save(location);
    }

    /**
     * Aktualisiert eine vorhandene Location.
     * 
     * @param lnr ID der Location (wird hier nicht direkt verwendet)
     * @param location Location-Objekt mit neuen Daten
     */
    public void updateLocation(int lnr, Location location) {
        logger.info("Aktualisiere Location mit ID {}", lnr);
        validateLocation(location);
        locationRepository.save(location);
    }

    /**
     * Löscht eine Location anhand der ID.
     * 
     * @param lnr ID der zu löschenden Location
     */
    public void deleteLocation(int lnr) {
        logger.info("Lösche Location mit ID {}", lnr);
        locationRepository.deleteById(lnr);
    }
}
