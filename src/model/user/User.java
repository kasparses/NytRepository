package model.user;

public class User
{
	private String email;
	private String password;
	private int userid;
	private String type;
	private String CPR;


	public User()
	{
	} 
	public User( int userid, String emailAddress, String pass, String ty, String cpr )
	{

		setUserid (userid);
		setEmail( emailAddress );
		setPassword ( pass );
		setType( ty);
		setCPR ( cpr );
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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getType() {
		return type;
	}

	public void setType(String ty) {
		this.type = ty;
	}

	public String getCPR() {
		return CPR;
	}

	public void setCPR(String cpr) {
		this.CPR = cpr;
	}


} 
