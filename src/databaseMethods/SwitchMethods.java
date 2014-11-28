package databaseMethods;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;
import JsonClasses.AuthUserJson;
import JsonClasses.BlockUser;
import JsonClasses.CreateCalendar;
import JsonClasses.DeleteCalendar;
import JsonClasses.SaveNote;

public class SwitchMethods extends Model
{
	QueryBuilder qb = new QueryBuilder();
	QOTDModel qm = new QOTDModel();
	DeleteCalendar DC = new DeleteCalendar();
	CreateCalendar CC = new CreateCalendar();
	Gson gson = new GsonBuilder().create();
	DeleteCalendar DE = new DeleteCalendar();
	AuthUserJson AU = new AuthUserJson();
	BlockUser BU = new BlockUser();
	SaveNote SN = new SaveNote();
	

	
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
			CC.setAnswer("The new calender has been created!");
		}
		else
		{
			CC.setAnswer("The new calender has not been created!");
		}
		
		
		String gsonString = gson.toJson(CC);
		return gsonString;	}
	
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
	public String deleteCalendar (String userName, String calendarName, boolean active) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeCalendar(userName, calendarName, active);

		return stringToBeReturned;
	}
	
	public String removeCalendar (String userName, String calendarName, boolean active) throws SQLException
	{
//		String stringToBeReturend = "";
		String usernameOfCreator ="";
		String calendarExists = "";
		String[] values = {""};
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
				DC.setAnswer("Only the creator of the calendar is able to delete it.");

				
			}
			else if(usernameOfCreator.equals(userName))
			{
				
				String [] keys = {"Active"};
				if(active == true ){
					values [0] = "1";
				}
				else if(active == false){
					 values [0] = "2";
				}
				qb.update("Calendar", keys, values).where("Name", "=", calendarName).Execute();

				if(active == true ){
					DC.setAnswer("The calendar has been set active"); 

				}
				else if(active == false){
					DC.setAnswer("The calendar has been set inactive"); 
				}
			}

		}
		else
		{
			DC.setAnswer("The calendar you are trying to delete, does not exists.");
			
		}
		
		String gsonString = gson.toJson(DC);
		return gsonString;
		
	}
	public Object blockUser (String userName, boolean blocked) throws SQLException
	{
//		String stringToBeReturend = "";
		String userExists = "";
		String[] values = {""};
		resultSet = qb.selectFrom("users").where("email", "=", userName).ExecuteQuery();
		while(resultSet.next())
		{
			userExists = resultSet.toString();
		}
		if(!userExists.equals(""))
		{
			
				String [] keys = {"Active"};
				if(blocked == true ){
					values [0] = "2";
				}
				else if(blocked == false){
					 values [0] = "1";
				}
				
				qb.update("users", keys, values).where("email", "=", userName).Execute();
				
				if(blocked == true ){
					BU.setAnswer("The user has been set inactive"); 

				}
				else if(blocked == false){
					BU.setAnswer("The user has been set active"); 
				}
			

		}
		else
		{
			BU.setAnswer("The user you are trying to block, does not exists.");
		}
		
		String gsonString = gson.toJson(BU);
		return gsonString;
		
	}
	
	public String removeEvent (String eventID, String title) throws SQLException
	{
//		String stringToBeReturend = "";
		String eventIDOfCreator ="";
		String eventExists = "";
		resultSet = qb.selectFrom("events").where("title", "=", title).ExecuteQuery();
				
		while(resultSet.next())
		{
			eventExists = resultSet.toString();
			eventIDOfCreator = resultSet.getString("title");
		}
		if(!eventExists.equals(""))
		{

			if(!eventIDOfCreator.equals(title))
			{
				DE.setAnswer("Only the creator of the event is able to delete it.");
			}
			else
			{

//				String [] keys = {"superID"};
//				String [] values = {"2"};
				qb.deleteFrom("events").where("title", "=", title).Execute();
				DE.setAnswer("Event has been set inactive"); 
			}

		}
		else
		{
			DE.setAnswer("The event you are trying to delete, does not exists.");
		}
		
		String gsonString = gson.toJson(DE);
		return gsonString;
		
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
	
	public String AddNote (String superID, String note) throws SQLException
	{
			
			System.out.println("hejhejhejhej");
				try {
					String [] keys = {"note"};
					String [] values = {note};
					qb.update("events", keys, values).where("superID", "=", superID).Execute();
					SN.setAnswer("The Note has been added");
					
				} catch (Exception e) {
					SN.setAnswer("The Note has Not been added");
					
					e.printStackTrace();
				}
				
		System.out.println(SN.getAnswer());
		String gsonString = gson.toJson(SN);
		return gsonString;
		
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
