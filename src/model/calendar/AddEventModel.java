package model.calendar;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;
import model.Model;
import JsonClasses.Answer;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Model;
import model.QueryBuild.*;
import model.note.NoteModel;
import model.calendar.*;
import JsonClasses.DeleteCalendar;

public class AddEventModel extends Model {
	
//	Event event = new Event(0, null, null, null, 0);
	QueryBuilder qb = new QueryBuilder(); 
	String stringToBeReturned = "";
	private DeleteCalendar DC = new DeleteCalendar();
	Gson gson = new GsonBuilder().create();
	ResultSet rs;
Answer A = new Answer();
	
	QOTDModel qm = new QOTDModel();

	public String CreateEvent(
			int ID,
			String activityID,
			String EventID,
			String type,
			String title,
			String description,
			String start,
			String end,
			String location,
			String note,
			String calendarName)	{
			
			String Id = String.valueOf(ID);
			System.out.println(" AddEventModel note: "+note);
			
			try {
				resultSet = qb.selectFrom("Calendar").where("Name", "=", calendarName).ExecuteQuery();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			int calendarID = 0;
			try {
				while(resultSet.next())
				{
					 calendarID = resultSet.getInt("CalendarID");
					
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			String[] fields = {"ID", "activityID","eventID", "type", "title", "description", "start", "end", "location", "note"};
			String[] values = {Integer.toString(calendarID),  activityID,EventID, type, title, description, start, end, location, note};			try {
				qb.insertInto("events", fields).values(values).Execute();
				A.setAnswer("The event has been succesfully created!!");
//				stringToBeReturned = "The event has been succesfully created!!";
				
			} catch (SQLException e) {
				A.setAnswer("The event has NOT been created!!");
//				stringToBeReturned = "The event has NOT been created!!";

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String gsonString = gson.toJson(A);
			return gsonString;
			
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
