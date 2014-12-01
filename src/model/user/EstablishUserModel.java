package model.user;

import java.sql.SQLException;
import model.QueryBuild.*;

public class EstablishUserModel {
	

	QueryBuilder qb = new QueryBuilder(); 
	String stringToBeReturned = "";

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
