package model.calendar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.QueryBuild.QueryBuilder;

/**
 * Created by jesperbruun on 10/10/14.
 * Den laver selve arrayet af alle generede Event
 */
public class Events {
    ArrayList<Event> events = new ArrayList<Event>();

    public ArrayList<Event> getEvents() {
    	QueryBuilder qb = new QueryBuilder();
    	try {
			ResultSet rs = qb.selectFrom("events").all().ExecuteQuery();
			while (rs.next())
			{
				//String values from SQL database (must be created)
				int activityid = rs.getInt("activityid");
				int eventid = rs.getInt("eventid");
				int location = rs.getInt("location");
				int createdby = rs.getInt("createdby");
				
				
				Date startDate = rs.getDate("start");
				Time startTime = rs.getTime("start");
				
				Date endDate = rs.getDate("end");
				Time endTime = rs.getTime("end");
				
				String titel = rs.getString("titel");
				String text = rs.getString("text");
				
				String stringActivityID = String.valueOf(activityid);
				String stringEventID = String.valueOf(eventid);
				String stringLocation = String.valueOf(location);
				String stringCreatedby = String.valueOf(createdby);
				String stringStartDate = String.valueOf(startDate);
				String stringStartTime = String.valueOf(startTime);				
				String stringEndDate = String.valueOf(endDate);
				String stringEndTime = String.valueOf(endTime);
				String stringTitel = String.valueOf(titel);
				String stringText = String.valueOf(text);
				
				ArrayList<String> alStart = new ArrayList<String>();
				alStart.add(stringStartDate + "" + stringStartTime);
				
				ArrayList<String> alEnd = new ArrayList<String>();
				alEnd.add(stringEndDate + "" + stringEndTime);
				
				
				System.out.println(String.valueOf(startDate.getTime()));
				
				events.add(new Event(stringActivityID, stringEventID, stringTitel, stringLocation, stringText,stringCreatedby, alStart, alEnd));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return events;
    }

    public void setEvents(ArrayList<Event> event) {
        this.events = event;
    }
    
    // Konverterer array events til en tekst streng
    @Override
    public String toString() {
        return Arrays.toString(events.toArray());
    }
    
    public static void main(String []args){
    	Events Hej = new Events();
    	
    	Hej.getEvents();
    	System.out.println(Hej.toString());
    }
}