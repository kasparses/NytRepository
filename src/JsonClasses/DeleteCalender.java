package JsonClasses;

public class DeleteCalender implements java.io.Serializable 
{
	private  final long serialVersionUID = 1L;
	private String overallID = "deleteCalender";
	private String calenderName;
	private String userName;
	
	public DeleteCalender(String ny) {
		// TODO Auto-generated constructor stub
	}
	
	//Getters and setters for everything, bitch
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getCalenderName() {
		return calenderName;
	}
	public void setCalenderName(String calenderName) {
		this.calenderName = calenderName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getString(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
