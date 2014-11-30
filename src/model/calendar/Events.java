package model.calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;




import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.QueryBuild.QueryBuilder;

/**
 * Created by jesperbruun on 10/10/14.
 * Den laver selve arrayet af alle generede Event
 */
public class Events {
	Gson gson = new GsonBuilder().create();
    ArrayList<Event> events = new ArrayList<Event>();

    public ArrayList<Event> getEvents() {
    	
    	
    	return events;
    }
    
    public String EventOutput(){
    	QueryBuilder qb = new QueryBuilder();
    	try {
			ResultSet rs = qb.selectFrom("events").all().ExecuteQuery();
			while (rs.next())
			{
				
				int ID = rs.getInt("ID");
				System.out.println("ID: "+ID);
				String activityID = rs.getString("activityID");
				String eventID = rs.getString("eventID");
				String type = rs.getString("type");
				String title = rs.getString("title");
				String describtion = rs.getString("description");
				Date startDate = rs.getDate("start");
				Time startTime = rs.getTime("start");
				Date endDate = rs.getDate("end");
				Time endTime = rs.getTime("end");
				String location = rs.getString("location");
				String note = rs.getString ("note");
				
				String stringActivityID = String.valueOf(activityID);
				String stringEventID = String.valueOf(eventID);
				String stringType = String.valueOf(type);
				String stringTitle = String.valueOf(title);
				String stringDescribtion = String.valueOf(describtion);
				String stringStartDate = String.valueOf(startDate);
				String stringStartTime = String.valueOf(startTime);				
				String stringEndDate = String.valueOf(endDate);
				String stringEndTime = String.valueOf(endTime);
				String stringLocation = String.valueOf(location);
				
				ArrayList<String> alStart = new ArrayList<String>();
				alStart.add(stringStartDate + "" + stringStartTime);
				
				ArrayList<String> alEnd = new ArrayList<String>();
				alEnd.add(stringEndDate + "" + stringEndTime);
				
				
				events.add(new Event(ID,stringActivityID, stringEventID, stringType, stringTitle, stringDescribtion, alStart, alEnd, stringLocation,note));
				
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    	String gsonString = gson.toJson(events);
    	
		return gsonString;
		
    }
    
    public void setEvents(ArrayList<Event> event) {
        this.events = event;
    }
    
    
    // Konverterer array events til en tekst streng
    @Override
    public String toString() {
        return Arrays.toString(events.toArray());
    }
}