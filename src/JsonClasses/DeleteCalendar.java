package JsonClasses;

public class DeleteCalendar implements java.io.Serializable 
{
	private  final long serialVersionUID = 1L;
	private String overallID = "deleteCalendar";
	private String calenderName;
	private String userName;
	private int publicOrPrivate;
	private int type;
	private int Active;
	
	public DeleteCalendar(String ny) {
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	public int getPublicOrPrivate() {
		return publicOrPrivate;
	}

	public void setPublicOrPrivate(int publicOrPrivate) {
		this.publicOrPrivate = publicOrPrivate;
	}
	
}
