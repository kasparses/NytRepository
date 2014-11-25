package model.calendar;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Model;
import model.QueryBuild.*;
import model.note.NoteModel;
import model.calendar.*;
import JsonClasses.DeleteCalendar;

public class AddEventModel {
	
//	Event event = new Event(0, null, null, null, 0);
	QueryBuilder qb = new QueryBuilder(); 
	String stringToBeReturned = "";
	private DeleteCalendar DC = new DeleteCalendar();
	Gson gson = new GsonBuilder().create();
	ResultSet rs;

	public String CreateEvent(
			int ID,
			String activityID,
			String eventID,
			String type,
			String title,
			String description,
			String start,
			String end,
			String location)	{
			
			String Id = String.valueOf(ID);
			
			String[] fields = {"ID", "activityID", "eventID", "type", "title", "description", "start", "end", "location"};
			String[] values = {Id, activityID, eventID, type, title, description, start, end, location};
			try {
				qb.insertInto("events", fields).values(values).Execute();
				
				stringToBeReturned = "The event has been succesfully created!!";
				
			} catch (SQLException e) {
				stringToBeReturned = "The event has NOT been created!!";

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stringToBeReturned;
		}
	
	public String DeleteCalendar(
		
//			int CalendarID,
//			int type,
//			String Name,
			int Active) throws SQLException{
		try{
//			String CreatedBy,
//			int PrivatePublic)	{
			
//			String CalendarId = String.valueOf(CalendarID);
//			String ty = String.valueOf(type);
			String Ac = String.valueOf(Active);
//			String Pri = String.valueOf(PrivatePublic);
			
			String[] fields = {"Active"};
			String[] values = {Ac};
			qb.update("Calendar", fields, values).all();
			
			int Active1 = rs.getInt(Ac);
			
			if(Ac.equals(Active1)){
				String answer = "correct";
				DC.setAnswer(answer);
				DC.setActive(Active1);
			}		
			
			stringToBeReturned = "The calendar has been succesfully set inactive!!";
			return stringToBeReturned;
	}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			String gsonString = gson.toJson(DC);
			return gsonString;
		}
}
