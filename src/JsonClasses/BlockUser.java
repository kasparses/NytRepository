package JsonClasses;

public class BlockUser implements java.io.Serializable
{
	private  final long serialVersionUID = 2L;
	private String overallID = "blockUser";
	private String email;
	private String password;
	private String CPR;
	private String answer = "";
	private boolean blocked;


	//Getters and setters for everything
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCPR() {
		return CPR;
	}
	public void setCPR(String cPR) {
		CPR = cPR;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}



}