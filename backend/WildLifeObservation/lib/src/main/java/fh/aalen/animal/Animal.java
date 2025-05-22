package fh.aalen.animal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Animal {

	@Id
private int id;
private String gender;
private int estimated_age;
private double estimated_weight;
private double estimated_size;


public Animal() {
	super();
}
public Animal(String gender, int estimated_age, double estimated_weight, double estimated_size, int id) {
	super();
	this.id = id;
	this.gender = gender;
	this.estimated_age = estimated_age;
	this.estimated_weight = estimated_weight;
	this.estimated_size = estimated_size;
}
public int getID() {
	return id;
}

public void setID(int id) {
	this.id = id;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public int getEstimated_age() {
	return estimated_age;
}

public void setEstimated_age(int estimated_age) {
	this.estimated_age = estimated_age;
}

public double getEstimated_weight() {
	return estimated_weight;
}

public void setEstimated_weight(double estimated_weight) {
	this.estimated_weight = estimated_weight;
}

public double getEstimated_size() {
	return estimated_size;
}

public void setEstimated_size(double estimated_size) {
	this.estimated_size = estimated_size;
}
}