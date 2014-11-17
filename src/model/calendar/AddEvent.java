package model.calendar;

import java.sql.SQLException;

import model.Model;
import model.QueryBuild.*;
import model.note.NoteModel;
import model.calendar.*;

public class AddEvent {
	
//	Event event = new Event(0, null, null, null, 0);
	QueryBuilder qb = new QueryBuilder(); 
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
			String location)	{
			
			String nId = String.valueOf(ID);
			
			String[] fields = {"ID", "activityID", "eventID", "type", "title", "description", "start", "end", "location"};
			String[] values = {nId};
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
}
