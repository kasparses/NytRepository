package model.calendar;

import java.util.ArrayList;

/**
 * Created by jesperbruun on 10/10/14.
 * Til hver specifik event bliver de defineret saaledes.
 */
public class Event {
//    private String activityid;
    private String eventid;
    private String name;
    private String type;
    private String title;
//    private String description;
    private String location;
    private String createdby;
    private ArrayList<String> start;
    private ArrayList<String> end;

    // Settere og gettere for Event objektet 
//    public void setActivityid(String activityid){
//        this.activityid = activityid;
//    }
//    public String getActivityid(){
//        return activityid;
//    }
    
    private int noteID;
	private String text;
	private String dateTime;
	private String createdBy;
//	private int isActive;
	private int eventID;
	
	public Event(int noteID, String text, String dateTime, String createdBy, int eventID) {
		super();
		this.noteID = noteID;
		this.text = text;
		this.dateTime = dateTime;
		this.createdBy = createdBy;
//		this.isActive = isActive;
		this.eventID = eventID;
		
		
	}

    public void setEventid(String eventid){
        this.eventid = eventid;
    }
    public String getEventid(){
        return eventid;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

//    public void setDescription(String description){
//        this.description = description;
//    }
//    public String getDescription(){
//        return description;
//    }

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
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
	public Event(String eventid, String name, String type, String title,
			String location, String createdby, ArrayList<String> start,
			ArrayList<String> end) {
		super();
//		this.activityid = activityid;
		this.eventid = eventid;
		this.type = type;
		this.title = title;
//		this.description = description;
		this.location = location;
		this.createdby = createdby;
		this.start = start;
		this.end = end;
		this.name = name;
	}
    
    

}
