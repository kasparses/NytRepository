package model.user;

import java.sql.ResultSet;


import model.QueryBuild.QueryBuilder;

public class AuthenticateUser {

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

	public String authenticate(String email, String password)
	{
		ResultSet rs;
		User u3 = null;
		String answer = "notCorrect";
		
		try
		{

			String[] keys = {"userid", "email","type", "password", "CPR"};
			qb = new QueryBuilder();
			rs = qb.selectFrom(keys, "user").where("email", "=", email).ExecuteQuery();
			while(rs.next())
			{
				int userid = rs.getInt("userid");
				System.out.println(userid);
				String emailAddress = rs.getString("email");
				String ty = rs.getString("type");
				String pass = rs.getString("password");
				
				
				if(pass.equals(password)){
//					u3 = new User(userid, emailAddress, ty, password);
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
	
	public String getLogin(String CPR)
	{
		ResultSet rs;
		User u4 = null;
		String answer = "notCorrect";
		
		try
		{

			String[] keys = {"userid", "email","type", "password", "CPR"};
			qb = new QueryBuilder();
			rs = qb.selectFrom(keys, "user").where("CPR", "=", CPR).ExecuteQuery();
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