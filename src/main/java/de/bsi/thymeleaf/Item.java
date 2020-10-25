package de.bsi.thymeleaf;

import java.util.Date;

public class Item {
	private String id, name;
	private Date date = new Date();

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
}
