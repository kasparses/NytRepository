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

	/**
	 * Allows the client to log in
	 * @param email
	 * @param password
	 * @param isAdmin
	 * @return
	 * @throws Exception
	 */
private LoginAnswer LA = new LoginAnswer();
private ForgotLogin FL = new ForgotLogin();


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

				if(pass.equals(password)){
					String answer = "correct";
					LA.setAnswer(answer);
					
				}
				else if (!pass.equals(password)){
					String answer = "notCorrect";
					LA.setAnswer(answer);
				}
				if (ty.equals("user")){
					String userAdmin = "user";
					LA.setUserAdmin(userAdmin);
				}
				else if (ty.equals("admin")){
					String userAdmin = "admin";
					LA.setAnswer(userAdmin);
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
	
	public String getLogin(String CPR)
	{
		ResultSet rs;
		User u4 = null;
		
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