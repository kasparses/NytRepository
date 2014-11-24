package JsonClasses;

public class AuthUserJson implements java.io.Serializable
{
	private  final long serialVersionUID = 2L;
	private String overallID = "logIn";
	private String email;
	private String password;
	private String CPR;
	
	
	//Getters and setters for everything, bitch
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
	
	

}