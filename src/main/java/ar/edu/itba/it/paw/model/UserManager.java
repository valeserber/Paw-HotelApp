package ar.edu.itba.it.paw.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {
	
	private static UserManager usermanager = null;

	protected UserManager() {
		
	}

	public static UserManager getInstance() {
		if(usermanager == null) {
			usermanager = new UserManager();
		}
		return usermanager;
	}
	
	public void addUser(String name, String email,String pass){
		User user=new User(name,email,pass);
		addUser(user);
	}

	public void addUser(User user){
		String query= "INSERT INTO USERNAME VALUES('"+user.getName()+"', '"+user.getEmail()+"', '"+user.getPass()+"');";
		DatabaseManager dbm=DatabaseManager.getInstance();
		ResultSet result= dbm.executeQuery(query);
	}
	
	public boolean isRegistered(String user,String pass){
		User realUser= getUser(user);
		if(realUser!=null){
			if(realUser.getPass().equals(pass)){
				return true;
			}
		}
		return false;
	}
	
	public boolean exists(String user){
		User realUser=getUser(user);
		if(realUser!=null){
			return true;
		}
		return false;
	}
	
	public User getUser(String username){
		DatabaseManager dbm=DatabaseManager.getInstance();
		User realUser=null;
		
		if(username!=null){
			try {
				String query="SELECT * FROM USERNAME WHERE NAME="+"'"+username+"'";
				ResultSet result= dbm.executeQuery(query);
				if(result!=null){
						while(result.next()){//deberia dar false si no hay nada
							String realName=result.getString("NAME");
							String realEmail=result.getString("EMAIL");
							String realPass=result.getString("PASS");
							realUser= new User(realName,realEmail,realPass);
							System.out.println(realName+" "+realEmail+" "+realPass);
						}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return realUser;
	}
}
