package fh.aalen.location;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    LocationService locationService;

    /**
     * Liefert die Liste aller Locations.
     * 
     * @return Liste aller Locations
     */
    @RequestMapping("/location")
    public List<Location> getLocationList() {
        logger.info("GET /location - Rufe Liste aller Locations ab");
        return locationService.getLocationList();
    }

    /**
     * Liefert eine Location anhand der übergebenen ID (lnr).
     * 
     * @param lnr ID der Location
     * @return Location-Objekt mit der angegebenen ID
     */
    @RequestMapping("/location/{lnr}")
    public Location getLocation(@PathVariable(value = "lnr") int lnr) {
        logger.info("GET /location/{} - Rufe Location mit ID {} ab", lnr, lnr);
        return locationService.getLocation(lnr);
    }

    /**
     * Fügt eine neue Location hinzu.
     * 
     * @param location Location-Objekt, das hinzugefügt werden soll
     */
    @RequestMapping(method = RequestMethod.POST, value = "/location")
    public void addLocation(@RequestBody Location location) {
        logger.info("POST /location - Füge neue Location hinzu: {}", location);
        locationService.addLocation(location);
    }

    /**
     * Aktualisiert eine vorhandene Location anhand der ID (lnr).
     * 
     * @param lnr ID der Location, die aktualisiert werden soll
     * @param location Location-Objekt mit neuen Daten
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/location/{lnr}")
    public void updateLocation(@PathVariable(value = "lnr") int lnr, @RequestBody Location location) {
        logger.info("PUT /location/{} - Aktualisiere Location mit ID {}", lnr, lnr);
        locationService.updateLocation(lnr, location);
    }

    /**
     * Löscht eine Location anhand der ID (lnr).
     * 
     * @param lnr ID der Location, die gelöscht werden soll
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/location/{lnr}")
    public void deleteLocation(@PathVariable(value = "lnr") int lnr) {
        logger.info("DELETE /location/{} - Lösche Location mit ID {}", lnr, lnr);
        locationService.deleteLocation(lnr);
    }
}
