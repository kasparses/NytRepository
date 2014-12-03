package model.user;

import java.sql.ResultSet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.QueryBuild.QueryBuilder;
import JsonClasses.LoginAnswer;
import JsonClasses.ForgotLogin;
public class AuthenticateUser {
	Gson gson = new GsonBuilder().create();
	private QueryBuilder qb;


	private LoginAnswer LA = new LoginAnswer();
	private ForgotLogin FL = new ForgotLogin();

	/**
	 * This method authenticates the login information sent from the user or the superAdmin. 
	 * @param email, a String with the email/username that the user has typed in the user interface. 
	 * @param password, a String with the password that the user has typed in the user interface. 
	 * @return gsonString, a JsonString of an object from the class LoginAnswer.
	 */
	public String authenticate(String email, String password)
	{
		ResultSet rs;
		try
		{

			String[] keys = {"userID", "email", "Active", "created", "type", "password", "CPR"};
			qb = new QueryBuilder();
			rs = qb.selectFrom(keys, "users").where("email", "=", email).ExecuteQuery();
			while(rs.next())
			{
				String ty = rs.getString("type");
				String pass = rs.getString("password");
				String acti = rs.getString("Active");

				if(pass.equals(password)){
					String answer = "correct";
					LA.setAnswer(answer);	
				}
				else if (!pass.equals(password)){
					String answer = "notCorrect";
					LA.setAnswer(answer);
				}
				if(acti.equals("1")){
					String active = "active";
					LA.setActive(active);
				}
				else if (acti.equals("2")){
					String active = "inactive";
					LA.setActive(active);
				}
			}

		}

		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		String gsonString = gson.toJson(LA);
		return gsonString;
	}
	
	/**
	 * This method lets the user type in his CPR number and receive his login information in case that he has forgotten them. 
	 * @param CPR, a String containing the CPR that the user has typed in the user interface. 
	 * @return gsonString, a JsonString of an object from the class ForgotLogin.
	 */
	public String getLogin(String CPR)
	{
		ResultSet rs;

		try
		{

			String[] keys = {"userid", "email", "Active", "created", "type", "password", "CPR"};
			qb = new QueryBuilder();
			rs = qb.selectFrom(keys, "users").where("CPR", "=", CPR).ExecuteQuery();
			while(rs.next())
			{

				String cpr = rs.getString("CPR");
				String email = rs.getString("email");
				String password = rs.getString("password");

				if(cpr.equals(CPR)){
					String answer = "correct";
					FL.setAnswer(answer);
					FL.setEmail(email);
					FL.setPassword(password);
				}				

			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		String gsonString = gson.toJson(FL);
		return gsonString;

	}

}