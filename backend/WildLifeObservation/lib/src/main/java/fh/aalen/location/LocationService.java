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

    public List<Location> getLocationList() {
        ArrayList<Location> mylist = new ArrayList<>();
        Iterator<Location> it = locationRepository.findAll().iterator();
        while (it.hasNext())
            mylist.add(it.next());
        return mylist;
    }

    public Location getLocation(int lnr) {
        return locationRepository.findById(lnr).orElse(null);
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public void updateLocation(int lnr, Location location) {
        locationRepository.save(location);
    }

    public void deleteLocation(int lnr) {
        locationRepository.deleteById(lnr);
    }
}
