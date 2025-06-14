package fh.aalen.location;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    /**
     * Gibt eine Liste aller Locations zurück.
     * 
     * @return Liste aller Locations aus der Datenbank
     */
    public List<Location> getLocationList() {
        ArrayList<Location> mylist = new ArrayList<>();
        Iterator<Location> it = locationRepository.findAll().iterator();
        while (it.hasNext()) {
            mylist.add(it.next());
        }
        return mylist;
    }

    /**
     * Gibt eine Location anhand der ID zurück.
     * 
     * @param lnr ID der Location
     * @return Location-Objekt oder null, falls nicht gefunden
     */
    public Location getLocation(int lnr) {
        return locationRepository.findById(lnr).orElse(null);
    }

    /**
     * Fügt eine neue Location hinzu.
     * 
     * @param location Location-Objekt, das gespeichert werden soll
     */
    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    /**
     * Aktualisiert eine vorhandene Location.
     * 
     * @param lnr ID der Location (wird hier nicht direkt verwendet)
     * @param location Location-Objekt mit neuen Daten
     */
    public void updateLocation(int lnr, Location location) {
        locationRepository.save(location);
    }

    /**
     * Löscht eine Location anhand der ID.
     * 
     * @param lnr ID der zu löschenden Location
     */
    public void deleteLocation(int lnr) {
        locationRepository.deleteById(lnr);
    }
}
