package ar.edu.itba.it.paw.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelManager {

	private static HotelManager hotelmanager = null;

	protected HotelManager() {
		
	}

	public static HotelManager getInstance() {
		if(hotelmanager == null) {
			hotelmanager = new HotelManager();
		}
		return hotelmanager;
	}
	
	public void addComment(String comment,String code,String username){
		String query="INSERT INTO COMMENTS VALUES('"+username+"', "+Integer.valueOf(code)+" ,'"+comment+"');";
		DatabaseManager dbm= DatabaseManager.getInstance();
		ResultSet result= dbm.executeQuery(query);
	}
	
	public List<Comment> getComments(int code){
		List<Comment> commentlist= new ArrayList<Comment>();
		UserManager um= UserManager.getInstance();
		String query="SELECT USERNAME, TEXT FROM COMMENTS WHERE CODE="+code+";";
		DatabaseManager dbm= DatabaseManager.getInstance();
		ResultSet result= dbm.executeQuery(query);
		if(result!=null){
			try {
				while(result.next()){
					String username= result.getString("USERNAME");
					String text= result.getString("TEXT");
					User realUser=um.getUser(username);
					Comment comment= new Comment(realUser,text);
					commentlist.add(comment);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commentlist;
	}
	public void addHotel(Hotel hotel){
		String query="INSERT INTO HOTEL VALUES('"+hotel.getCode()+"', "+hotel.getName()+"' ,"+hotel.getDescription()+"');";
		DatabaseManager dbm= DatabaseManager.getInstance();
		ResultSet result= dbm.executeQuery(query);
	}
	
	public List<Hotel> getHotelList(){
		String query="SELECT * FROM HOTEL";
		DatabaseManager dbm= DatabaseManager.getInstance();
		ResultSet result=null;
		List<Hotel> hotels= new ArrayList<Hotel>();
		try {
			result= dbm.executeQuery(query);
			if(result!=null){
				while(result.next()){//deberia dar false si no hay nada
					Integer realCode=result.getInt("CODE");
					String realName=result.getString("NAME");
					String realDescription=result.getString("DESCRIPTION");
					Hotel hotel= new Hotel(realCode,realName,realDescription);
					hotels.add(hotel);
					System.out.println(realCode+" "+realName+" "+realDescription);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hotels;
	}
	
	public Hotel getHotel(String code){
		String query="SELECT * FROM HOTEL WHERE CODE="+code+";";
		DatabaseManager dbm= DatabaseManager.getInstance();
		ResultSet result=null;
		Hotel hotel=null;
		try {
			result= dbm.executeQuery(query);
			if(result!=null){
				while(result.next()){//deberia dar false si no hay nada
					Integer realCode=result.getInt("CODE");
					String realName=result.getString("NAME");
					String realDescription=result.getString("DESCRIPTION");
					hotel= new Hotel(realCode,realName,realDescription);
					System.out.println(realCode+" "+realName+" "+realDescription);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hotel;
	}

}
