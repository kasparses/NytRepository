package JsonClasses;

public class DeleteEvent implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "deleteEvent";
	private String title = "";
	private String userName = "";
	private int Active = 1;
	private String answer = "";
	private String superID = "";

	//Getters and setters for everything
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getActive() {
		return Active;
	}
	public void setActive(int active) {
		Active = active;
	}
	public String getsuperID() {
		return superID;
	}
	public void setsuperID(String superID) {
		this.superID = superID;
	}


}
