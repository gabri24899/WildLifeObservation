package fh.aalen.genus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import fh.aalen.animal.Animal;

@Entity //Für die Datenbank dadurch wird die Klasse als entität festegelegt
public class Genus {

    @Id  //Dient zur festlegung des Primärschlüssels
    private int id;

    private String latinDesignation;
    private String designation;

    @OneToMany(mappedBy = "genus") //Eine Gattung kann mehrere Tiere beinhalten daher 1:m
    @JsonManagedReference("genus-animal")//Zur Verhinderung von Endlosschleifen dadurch geht genus-> Animal aber der Zurückverweis wird ignoriert animal-> genus 
    private List<Animal> animals;

    // Konstruktoren
    public Genus() {
        super();
    }

    public Genus(int id, String latinDesignation, String designation) {
        super();
        this.id = id;
        this.latinDesignation = latinDesignation;
        this.designation = designation;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatinDesignation() {
        return latinDesignation;
    }

    public void setLatinDesignation(String latinDesignation) {
        this.latinDesignation = latinDesignation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
