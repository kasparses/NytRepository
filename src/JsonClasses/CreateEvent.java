package JsonClasses;

public class CreateEvent implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "createEvent";
	private int ID;
	private String activityID;
	private String eventID;
	private String type;
	private String title;
	private String description;
	private String start;
	private String end;
	private String location;
	private String note;
	private String calendarName;
	private String answer = "";

	public CreateEvent(String _overallID, int _ID, String _activityID, String _eventID, String _type, String _title, String _description, String _start, String _end, String _location, String _calendarName, String _note){
		setOverallID(_overallID);
		setID(_ID);
		setActivityID(_activityID);
		setEventID(_eventID);
		setType(_type);
		setTitle(_title);
		setDescription(_description);
		setStart(_start);
		setEnd(_end);
		setLocation(_location);
		setCalendarName(_calendarName);
		setNote(_note);

	}

	//Getters and setters for everything
	

	public String getOverallID() {
		return overallID;
	}
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCalendarName() {
		return calendarName;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getActivityID() {
		return activityID;
	}
	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}	

}
