package model.calendar;

import java.sql.SQLException;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;
import model.Model;
import model.QueryBuild.*;
import model.note.NoteModel;
import model.calendar.*;
import JsonClasses.Answer;

public class AddEventModel extends Model {
	Gson gson = new GsonBuilder().create();
	

	QueryBuilder qb = new QueryBuilder(); 
	Answer A = new Answer();
	
	QOTDModel qm = new QOTDModel();
	String stringToBeReturned = "";

	public String CreateEvent(
			int ID,
			String activityID,
			String eventID,
			String type,
			String title,
			String description,
			String start,
			String end,
			String location,
			String calendarName)	{
			
			String Id = String.valueOf(ID);
			
			try {
				resultSet = qb.selectFrom("Calendar").where("Name", "=", calendarName).ExecuteQuery();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			String calendarID = "";
			try {
				while(resultSet.next())
				{
					 calendarID = resultSet.toString();
					
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			
			String[] fields = {"ID", "activityID", "eventID", "type", "title", "description", "start", "end", "location"};
			String[] values = {calendarID, activityID, eventID, type, title, description, start, end, location};
			try {
				qb.insertInto("events", fields).values(values).Execute();
				
				A.setAnswer("The event has been succesfully created!!");
//				stringToBeReturned = "The event has been succesfully created!!";
				
			} catch (SQLException e) {
				A.setAnswer("The event has NOT been created!!");
//				stringToBeReturned = "The event has NOT been created!!";

		
				e.printStackTrace();
			}
			String gsonString = gson.toJson(A);
			return gsonString;
			
		}
}
