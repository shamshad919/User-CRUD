package com.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	
	@Id
	public int id;
	
	public String name;
	
	public String organization;

	public User(int id, String name, String organization) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", organization=" + organization + "]";
	}
	
	
	
}
