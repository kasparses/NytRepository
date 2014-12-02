package JsonClasses;

public class EstablishUser implements java.io.Serializable
{
	private  final long serialVersionUID = 1L;
	private String overallID = "establishUser";
	private String email;
	private int Active;
	private String type;
	private String password;
	private String CPR;
	private String UpdatedCbsEvents;
	private String answer = "";


	public EstablishUser(String overallID, String email, int Active,
			String type, String password, String CPR, String UpdatedCbsEvents){
		setOverallID(overallID);
		setEmail(email);
		setActive(Active);
		setType(type);
		setPassword(password);
		setCPR(CPR);
		setUpdatedCbsEvents(UpdatedCbsEvents);


	}

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

	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
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

	public long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUpdatedCbsEvents() {
		return UpdatedCbsEvents;
	}

	public void setUpdatedCbsEvents(String updatedCbsEvents) {
		UpdatedCbsEvents = updatedCbsEvents;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}		


}
