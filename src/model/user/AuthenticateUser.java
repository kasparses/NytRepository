package model.user;

import java.sql.ResultSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.QueryBuild.QueryBuilder;
import JsonClasses.LoginAnswer;
public class AuthenticateUser {
	Gson gson = new GsonBuilder().create();

	

	private ResultSet rs;

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
				int userid = rs.getInt("userID");
				String emailAddress = rs.getString("email");
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
		String answer = "notCorrect";
		
		try
		{

			String[] keys = {"userid", "email","type", "password", "CPR"};
			qb = new QueryBuilder();
			rs = qb.selectFrom(keys, "users").where("CPR", "=", CPR).ExecuteQuery();
			while(rs.next())
			{
				
				String cpr = rs.getString("CPR");
				
				
				if(cpr.equals(CPR)){
					answer = "correct";
				}				

				
					

			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return answer;
	}
}