package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Corey Connor - cconnor3
 * CIS175 - Spring 2022
 * Feb 3, 2022
 */

@Entity
@Table(name="pets")
public class Pet {
	
	// Attributes
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="TYPE")
	private String type;
	@Column(name="NAME")
	private String name;
	@Column(name="OWNER")
	private String owner;
	
	// Constructors
	public Pet() {
		super();
	}

	public Pet(String type, String name, String owner) {
		super();
		this.type = type;
		this.name = name;
		this.owner = owner;
	}
	
	// Getters/Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	// Helper methods
	public String returnPetDetails() {
		return "type: " + type + "; name: " + name + "; owner: " + owner;
	}
}