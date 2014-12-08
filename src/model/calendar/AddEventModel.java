package model.calendar;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import JsonClasses.CreateEvent;
import model.QueryBuild.QueryBuilder;
import model.Model;
import JsonClasses.Answer;
import JsonClasses.DeleteCalendar;

public class AddEventModel extends Model  {
	
	QueryBuilder qb = new QueryBuilder(); 
	String stringToBeReturned = "";
	private DeleteCalendar DC = new DeleteCalendar();
	Gson gson = new GsonBuilder().create();
	ResultSet rs;
	Answer A = new Answer();
	CreateEvent CE = new JsonClasses.CreateEvent(stringToBeReturned, 0, stringToBeReturned, stringToBeReturned, stringToBeReturned, stringToBeReturned, stringToBeReturned, stringToBeReturned, stringToBeReturned, stringToBeReturned, stringToBeReturned, stringToBeReturned);
	
	

	public String CreateEvent (
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
			
			
			try {

				resultSet = qb.selectFrom("Calendar").where("Name", "=", calendarName).ExecuteQuery();
			String calendarExists = "";
			int calendarID = 0;
				while(resultSet.next())
				{
					calendarExists = resultSet.toString();
					calendarID = resultSet.getInt("CalendarID");
					 
				}
			if (!calendarExists.equals("")){
			
			
				
			String[] fields = {"ID", "activityID","eventID", "type", "title", "description", "start", "end", "location", "note"};
			String[] values = {Integer.toString(calendarID),  activityID,EventID, type, title, description, start, end, location, note};			
				qb.insertInto("events", fields).values(values).Execute();
				CE.setAnswer("The event has been succesfully created.");
		
				
			
			}else{
				CE.setAnswer("The name of the Calendar does not exist.");
			
			}
			} catch (SQLException e) {
				CE.setAnswer("The event has NOT been created.");
				e.printStackTrace();
			}
			String gsonString = gson.toJson(CE);
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
