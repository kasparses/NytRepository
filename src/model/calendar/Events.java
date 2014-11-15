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
				int activityID = rs.getInt("activityID");
				int eventID = rs.getInt("eventID");
				int type = rs.getInt("type");
				int title = rs.getInt("title");
				int describtion = rs.getInt("description");
				
				Date startDate = rs.getDate("start");
				Time startTime = rs.getTime("start");
				
				Date endDate = rs.getDate("end");
				Time endTime = rs.getTime("end");
				
				int location = rs.getInt("location");
				
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
				
				
				System.out.println(String.valueOf(startDate.getTime()));
				
				events.add(new Event(stringActivityID, stringEventID, stringType, stringTitle, stringDescribtion, alStart, alEnd, stringLocation));				
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