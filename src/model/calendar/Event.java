package model.calendar;

import java.util.ArrayList;

/**
 * Created by jesperbruun on 10/10/14.
 * Til hver specifik event bliver de defineret saaledes.
 */
public class Event {
    private String activityid;
    private String eventid;
    private String location;
    private String createdby;
    private String title;
    private String text;
    private ArrayList<String> start;
    private ArrayList<String> end;
    
    // Settere og gettere for Event objektet 
    public void setActivityid(String activityid){
        this.activityid = activityid;
    }
    public String getActivityid(){
        return activityid;
    }

    public void setEventid(String eventid){
        this.eventid = eventid;
    }
    public String getEventid(){
        return eventid;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setDescription(String description){
        this.text = description;
    }
    public String getDescription(){
        return text;
    }

    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }

    public void setCreatedby(String createdby){
        this.createdby = createdby;
    }
    public String getCreatedby(){
        return createdby;
    }
    
    public void setStart(ArrayList<String> start){
        this.start = start;
    }
    public ArrayList<String> getStart(){
        return start;
    }

    public void setEnd(ArrayList<String> end){
        this.end = end;
    }
    public ArrayList<String> getEnd(){
        return end;
    }
	public Event(String activityid, String eventid, String title,
			String text, String location, String createdby, ArrayList<String> start,
			ArrayList<String> end) {
		super();
		this.activityid = activityid;
		this.eventid = eventid;
		this.title = title;
		this.text = text;
		this.location = location;
		this.createdby = createdby;
		this.start = start;
		this.end = end;
	}
    
    

}