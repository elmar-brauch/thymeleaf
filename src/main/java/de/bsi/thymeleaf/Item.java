package de.bsi.thymeleaf;

import java.io.Serializable;

public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id, name;

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}
