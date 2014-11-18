package databaseMethods;
import java.sql.SQLException;

import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;

public class SwitchMethods extends Model
{
	QueryBuilder qb = new QueryBuilder();
	QOTDModel qm = new QOTDModel();
	

	
	/**
	 * Allows the client to create a new calendar
	 * @param userName
	 * @param calenderName
	 * @param privatePublic
	 * @return
	 * @throws SQLException
	 */

	public String UpdateLoginTime (long LoginTime, String userName){
		System.out.println("LoginTime: "+LoginTime+ " UserName: "+userName);
		String noReturn = "";
		String[] keys = {"LastUpdateTime" };
		String[] keys2 = {Long.toString(LoginTime) };
		
		try {
			qb.update("users", keys, keys2).where("email", "=", userName).Execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noReturn;
		
	}
	
	
	public String createNewCalendar (int type, String newcalendarName, int Active, String userName, int privatePublic) throws SQLException
	{
		String stringToBeReturned = "";
		testConnection();
		if(authenticateNewCalendar(newcalendarName) == false)
		{
			addNewCalendar(type, newcalendarName, Active, userName, privatePublic);
			stringToBeReturned = "The new calender has been created!";
		}
		else
		{
			stringToBeReturned = "The new calender has not been created!";
		}
		
		
		return stringToBeReturned;
	}
	
	public boolean authenticateNewCalendar(String newCalendarName) throws SQLException
	{
		getConn();
		boolean authenticate = false;
		
		resultSet= qb.selectFrom("Calendar").where("name", "=", newCalendarName).ExecuteQuery();
				
		while(resultSet.next())
		{
			authenticate = true;
		}
		return authenticate;
	}
	
	public void addNewCalendar (int type, String newCalendarName, int Active, String userName, int publicOrPrivate) throws SQLException
	{
		String [] keys = {"type","Name","Active","CreatedBy","PrivatePublic"};
		String [] values = {Integer.toString(type),newCalendarName,Integer.toString(Active),userName, Integer.toString(publicOrPrivate)};
		qb.insertInto("Calendar", keys).values(values).Execute();
		

	}
	/**
	 * Allows the client to delete a calendar
	 * @param userName
	 * @param calenderName
	 * @return
	 */
	public String deleteCalendar (String userName, String calendarName) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeCalendar(userName, calendarName);

		return stringToBeReturned;
	}
	
	public String removeCalendar (String userName, String calendarName) throws SQLException
	{
		String stringToBeReturend = "";
		String usernameOfCreator ="";
		String calendarExists = "";
		resultSet = qb.selectFrom("Calendar").where("Name", "=", calendarName).ExecuteQuery();
				
		while(resultSet.next())
		{
			calendarExists = resultSet.toString();
			usernameOfCreator = resultSet.getString("CreatedBy");
		}
		if(!calendarExists.equals(""))
		{

			if(!usernameOfCreator.equals(userName))
			{
				stringToBeReturend = "Only the creator of the calendar is able to delete it.";
			}
			else
			{
				String [] keys = {"Active"};
				String [] values = {"2"};
				qb.update("Calendar", keys, values).where("Name", "=", calendarName).Execute();
				stringToBeReturend = "Calendar has been set inactive";
			}

		}
		else
		{
			stringToBeReturend = "The calendar you are trying to delete, does not exists.";
		}
		
		
		
		return stringToBeReturend;
	}
	
	public String getCalendar (int type, String newCalendarName, int Active, String userName, int publicOrPrivate) throws SQLException
	{
		String stringToBeReturend = "";
		qb.selectFrom("Calendar").all().Execute();
		
		return stringToBeReturend;

	
	}
	public String getEvents (String userName, String calendarName) throws SQLException
	{
		String stringToBeReturend = "";
		qb.selectFrom("events").all().Execute();
		
		return stringToBeReturend;

	
	}
	
		/**
	 * Allows the client to log in
	 * @param email
	 * @param password
	 * @param isAdmin
	 * @return
	 * @throws Exception
	 */

}
