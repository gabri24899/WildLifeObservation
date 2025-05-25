package fh.aalen.location;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import fh.aalen.observed.Observed;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Location {
	
	@Id
	private int lnr;
	
	private String short_title;
	private String description;
	
	@OneToMany(mappedBy = "location")
	@JsonManagedReference ("location-observed")
    private List<Observed> observations;
	
	
	public Location () {
		super();
	}
	
	
	
	public int getLnr() {
		return lnr;
	}
	public void setLnr(int lnr) {
		this.lnr = lnr;
	}
	
	public String getShort_title() {
		return short_title;
	}
	public void setShort_title(String short_title) {
		this.short_title = short_title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Observed> getObservations() {
        return observations;
    }

    public void setObservations(List<Observed> observations) {
        this.observations = observations;
    }
}
