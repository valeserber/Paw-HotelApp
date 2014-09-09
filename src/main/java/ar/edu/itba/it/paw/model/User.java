package ar.edu.itba.it.paw.model;

public class User {

	private String name;
	private String email;
	private String pass;
	private boolean authentication;
	
	public User(){
		
	}
	
	public User(String name,String email){
		this.name=name;
		this.email=email;
	}
	
	public User(String name,String email,String pass){
		this.name=name;
		this.email=email;
		this.pass=pass;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean getAuthentication() {
		return authentication;
	}

	public void setAuthentication(boolean authentication) {
		this.authentication =authentication;
	}
}
