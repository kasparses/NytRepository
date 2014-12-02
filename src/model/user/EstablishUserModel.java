package model.user;

import java.sql.SQLException;
import model.QueryBuild.*;


public class EstablishUserModel {
	

	QueryBuilder qb = new QueryBuilder(); 
	String stringToBeReturned = "";

	/**
	 * This method allows the user or superAdmin to create a new user. 
	 * @param email, a String with the email that the user has typed in the user interface. 
	 * @param Active, an Integer that decides whether the created user is to be active or not. 
	 * @param created, a String with the time that the user is created. 
	 * @param type,
	 * @param password, a String with the email that the user has typed in the user interface. 
	 * @param CPR, a String with the email that the user has typed in the user interface. 
	 * @param UpdatedCbsEvents, a String with the email that the user has typed in the user interface. 
	 * @return
	 */
	public String EstablishUser(
			String email,
			int Active,
			String created,
			String type,
			String password,
			String CPR,
			String UpdatedCbsEvents){
			
			String ac = String.valueOf(Active);

			
			String[] keys = { "email", "Active", "created", "type", "password", "CPR", "UpdatedCbsEvents"};
			String[] values = { email, ac, created, type, password, CPR, UpdatedCbsEvents};
			try {
				qb.insertInto("users", keys).values(values).Execute();
				
				
				stringToBeReturned = "The user has been succesfully established!!";
				
			} catch (SQLException e) {
				stringToBeReturned = "The user has NOT been established!!";
				
				e.printStackTrace();
			}
			return stringToBeReturned;
		}
}
