package fh.aalen.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    /**
     * Liefert die Liste aller Locations.
     * 
     * @return Liste aller Locations
     */
    @RequestMapping("/location")
    public List<Location> getLocationList() {
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
        return locationService.getLocation(lnr);
    }

    /**
     * Fügt eine neue Location hinzu.
     * 
     * @param location Location-Objekt, das hinzugefügt werden soll
     */
    @RequestMapping(method = RequestMethod.POST, value = "/location")
    public void addLocation(@RequestBody Location location) {
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
        locationService.updateLocation(lnr, location);
    }

    /**
     * Löscht eine Location anhand der ID (lnr).
     * 
     * @param lnr ID der Location, die gelöscht werden soll
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/location/{lnr}")
    public void deleteLocation(@PathVariable(value = "lnr") int lnr) {
        locationService.deleteLocation(lnr);
    }
}
