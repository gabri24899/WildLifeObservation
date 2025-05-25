package fh.aalen.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping("/location")
    public List<Location> getLocationList() {
        return locationService.getLocationList();
    }

    @RequestMapping("/location/{lnr}")
    public Location getLocation(@PathVariable(value = "lnr") int lnr) {
        return locationService.getLocation(lnr);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/location")
    public void addLocation(@RequestBody Location location) {
        locationService.addLocation(location);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/location/{lnr}")
    public void updateLocation(@PathVariable(value = "lnr") int lnr, @RequestBody Location location) {
        locationService.updateLocation(lnr, location);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/location/{lnr}")
    public void deleteLocation(@PathVariable(value = "lnr") int lnr) {
        locationService.deleteLocation(lnr);
    }
}
