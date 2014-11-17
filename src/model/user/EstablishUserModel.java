package model.user;

import java.sql.SQLException;

import model.Model;
import model.QueryBuild.*;
import model.note.NoteModel;
import model.calendar.*;

public class EstablishUserModel {
	
//	Event event = new Event(0, null, null, null, 0);
	QueryBuilder qb = new QueryBuilder(); 
	String stringToBeReturned = "";

	public String EstablishUser(
			int userID,
			String email,
			int Active,
			String created,
			String type,
			String password,
			String CPR){
//			String LastUpdateTime)	{
			
			String Id = String.valueOf(userID);
			String ac = String.valueOf(Active);

			
			String[] fields = {"userID", "email", "Active", "created", "type", "password", "CPR"};
			String[] values = {Id, email, ac, created, type, password, CPR};
			try {
				qb.insertInto("users", fields).values(values).Execute();
				
				stringToBeReturned = "The user has been succesfully established!!";
				
			} catch (SQLException e) {
				stringToBeReturned = "The user has NOT been established!!";

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stringToBeReturned;
		}
}
