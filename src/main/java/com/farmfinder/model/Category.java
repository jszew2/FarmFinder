package com.farmfinder.model;

import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonIgnore;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * @author Group: FarmFinder
 * 
 */

public class Category {
	private String Id;
	private String name ;
	@JsonDeserialize(as=ArrayList.class, contentAs=String.class) private ArrayList<String> FarmID ;
	
	/*******************Setters and Getters***********************/
	public String getId() {
		return Id;
	}
	public void setId(String Id) {
		this.Id = Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonIgnore
	public ArrayList<String> getFarmID() {
		return FarmID;
	}
	public void setFarmID(ArrayList<String> farmID) {
		FarmID = farmID;
	}
}
