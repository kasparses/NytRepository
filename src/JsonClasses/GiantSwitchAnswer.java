package JsonClasses;

public class GiantSwitchAnswer implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "";
	private String answer = "";
	
	//Getters and setters for everything, bitch
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

}
