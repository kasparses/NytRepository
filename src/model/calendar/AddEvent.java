package model.calendar;

import java.sql.SQLException;

import model.Model;
import model.QueryBuild.*;
import model.note.NoteModel;
import model.calendar.*;

public class AddEvent {
	
	Event event = new Event(0, null, null, null, 0);
	QueryBuilder qb = new QueryBuilder(); 

	public void CreateEvent(
			int noteID,
			String text, 
			String dateTime, 
			String createdBy, 
//			int isActive,
			int eventID)	{
			
			String nId = String.valueOf(noteID);
			String eId = String.valueOf(eventID);
			
			String[] fields = {"noteId", "eventId", "createdBy", "text", "dateTime"};
			String[] values = {nId, eId, createdBy, text, dateTime};
			try {
				qb.insertInto("events", fields).values(values).Execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
