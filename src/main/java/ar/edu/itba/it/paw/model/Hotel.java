package ar.edu.itba.it.paw.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

	private int code;
	private String name;
	private String description;
	//private List<Comment> comments;
	
	public Hotel(int code, String name, String description){
		this.code=code;
		this.name=name;
		this.description=description;
		//this.comments=new ArrayList<Comment>();
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
	
	/*public List<Comment> getComments(){
		return comments;
	}
	
	public void setComments(List<Comment> list){
		comments.addAll(list);
	}
	
	public void addComment(Comment c){
		comments.add(c);
	}
	
	public void addComment(String comment,String name,String email){
		User user= new User(name,email);
		addComment(new Comment(user,comment));
	}*/
	
}
