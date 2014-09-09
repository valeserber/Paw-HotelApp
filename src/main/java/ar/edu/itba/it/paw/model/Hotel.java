package ar.edu.itba.it.paw.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

	private int code;
	private String name;
	private String description;
	
	public Hotel(int code, String name, String description){
		this.code=code;
		this.name=name;
		this.description=description;
	}
	
	public Hotel(){
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
