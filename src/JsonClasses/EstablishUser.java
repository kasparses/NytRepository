package JsonClasses;

public class EstablishUser implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "establishUser";
	private int userID;
	private String email;
	private int Active;
	private String created;
	private String type;
	private String password;
	private String CPR;
//	private String LastUpdateTime;
	
	public EstablishUser(String overallID, int userID, String email, int Active, String created,
			String type, String password, String CPR){
		setOverallID(overallID);
		setUserID(userID);
		setActive(Active);
		setType(created);
		setType(type);
		setPassword(password);
		setCPR(CPR);
//		setLastUpdateTime(LastUpdateTime);
		
	}

	//Getters and setters for everything, bitch

	public String getOverallID() {
		return overallID;
	}

	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

//	public String getLastUpdateTime() {
//		return LastUpdateTime;
//	}
//
//	public void setLastUpdateTime(String lastUpdateTime) {
//		LastUpdateTime = lastUpdateTime;
//	}

	public long getSerialVersionUID() {
		return serialVersionUID;
	}		

}
