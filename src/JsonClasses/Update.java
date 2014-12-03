package JsonClasses;

import GUI.EventList;

public class Update implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "UpdateTables";
	EventList EL = new EventList();
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Getters and setters for everything
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	

}
