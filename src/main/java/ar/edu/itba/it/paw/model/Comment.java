package ar.edu.itba.it.paw.model;


public class Comment {

	private User user;
	private String text;
	
	public Comment(User user,String text){
		this.user=user;
		this.text=text;
	}
	
	public Comment(){
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
