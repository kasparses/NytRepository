package model.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import sun.text.normalizer.NormalizerBase.Mode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Model;
import model.QueryBuild.*;


public class EstablishUserModel extends Model {
	

	QueryBuilder qb = new QueryBuilder(); 
	String stringToBeReturned = "";
	Gson gson = new GsonBuilder().create();
	ResultSet rs;
	JsonClasses.EstablishUser EU = new JsonClasses.EstablishUser(stringToBeReturned, stringToBeReturned, 0, stringToBeReturned, stringToBeReturned, stringToBeReturned, stringToBeReturned);

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
			String type,
			String password,
			String CPR,
			String UpdatedCbsEvents){
			
			String ac = String.valueOf(Active);

			
			String[] keys = { "email", "Active", "type", "password", "CPR", "UpdatedCbsEvents"};
			String[] values = { email, ac, type, password, CPR, UpdatedCbsEvents};
			try {
				resultSet = qb.selectFrom("users").where("email", "=", email).ExecuteQuery();
				String userExists = "";
				int userID = 0;
					while(resultSet.next())
					{
						userExists = resultSet.toString();
						userID = resultSet.getInt("userID");
						 
					}
				if (userExists.equals("")){
				
					qb.insertInto("users", keys).values(values).Execute();
					
										
					EU.setAnswer("The user has been succesfully established!");
				}
				else{
					EU.setAnswer("The name of the user has already been taken.");
				
				}
				} catch (SQLException e) {
					stringToBeReturned = "The user has NOT been established!!";
					e.printStackTrace();
				}
				String gsonString = gson.toJson(EU);
				return gsonString;	
					
	}			
				
	}
