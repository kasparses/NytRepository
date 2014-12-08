package databaseMethods;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Model;
import model.QueryBuild.QueryBuilder;
import JsonClasses.AuthUserJson;
import JsonClasses.BlockUser;
import JsonClasses.CreateCalendar;
import JsonClasses.DeleteCalendar;
import JsonClasses.SaveNote;
import databaseMethods.CalendarData;

/**
 * The methods in this class are all called from the GiantSwitch class and they are primarily used in connection with the database.
 * The methods are for example used to update, insert or extract information from the database. 
 * The methods all return a JsonObject containing the information that are to be sent back to the user or superAdmin. 
 * 
 *
 */
public class SwitchMethods extends Model
{
	QueryBuilder qb = new QueryBuilder();
	DeleteCalendar DC = new DeleteCalendar();
	CreateCalendar CC = new CreateCalendar();
	Gson gson = new GsonBuilder().create();
	DeleteCalendar DE = new DeleteCalendar();
	AuthUserJson AU = new AuthUserJson();
	BlockUser BU = new BlockUser();
	SaveNote SN = new SaveNote();

	/**
	 * ArrayList of the class CalendarData
	 */
	ArrayList<CalendarData> calendarData = new ArrayList<CalendarData>();

	/**
	 * Allows the user or superAdmin to create a new calendar.
	 * @param type, decides whether the calendar is a user created calendar or a standard CBS calendar that cannot be deleted.
	 * @param newcalendarName, the name of the calendar to be created.
	 * @param Active, whether the calendar is to be active or to be inactive.
	 * @param userName, the user name of the user who is currently logged in. This is used to set who created the calendar. 
	 * @param privatePublic, decides whether the calendar is a private calendar or a public calendar. 
	 * @return gsonString, A JsonString created from an object of the class CreateCalendar.
	 * @throws SQLException
	 */
	public String createNewCalendar (int type, String newcalendarName, int Active, String userName, int privatePublic) throws SQLException
	{

		testConnection();
		if(authenticateNewCalendar(newcalendarName) == false)
		{
			addNewCalendar(type, newcalendarName, Active, userName, privatePublic); // Runs the method addNewCalendar.
			CC.setAnswer("The new calendar has been created!");
		}
		
		else
		{
			CC.setAnswer("The name of the calendar has already been used. Please try again.");
		}


		String gsonString = gson.toJson(CC); // Creates a JSON string of the CreateCalendar Class. 
		return gsonString;	// Returns the JSON string to the client. 
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
	/**
	 * This method is called from the method createNewCalendar in this class and inserts the variables in the specified columns in the database. 
	 * The parameters are the same as described in the documentation for the method createNewCalendar.
	 * @param type
	 * @param newCalendarName
	 * @param Active
	 * @param userName
	 * @param publicOrPrivate
	 * @throws SQLException
	 */
	public void addNewCalendar (int type, String newCalendarName, int Active, String userName, int publicOrPrivate) throws SQLException
	{
		String [] keys = {"type","Name","Active","CreatedBy","PrivatePublic"};
		String [] values = {Integer.toString(type),newCalendarName,Integer.toString(Active),userName, Integer.toString(publicOrPrivate)};
		qb.insertInto("Calendar", keys).values(values).Execute();


	}
	/**
	 * Allows the user or superAdmin to delete a calendar
	 * @param userName, the username of the user who is currently logged in. This is used to check whether the username of the person logged
	 * in matches the username of the person who created the calendar as a user can only delete calendars that he created himself. 
	 * @param calenderName, the name of the calendar to be deleted.
	 * @return gsonString, A JsonString created from an object of the class DeleteCalendar.
	 */
	public String deleteCalendar (String userName, String calendarName, boolean active) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeCalendar(userName, calendarName, active); //Runs the method removeCalendar.

		return stringToBeReturned;
	}
	/**
	 * This method is called from the method deleteCalendar and is used to set the selected calendar to inactive. 
	 * The parameters are the same as described in the documentation for the method deleteCalendar. 
	 * @param userName
	 * @param calendarName
	 * @param active
	 * @return gsonString, A JsonString created from an object of the class DeleteCalendar.
	 * @throws SQLException
	 */
	public String removeCalendar (String userName, String calendarName, boolean active) throws SQLException
	{

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

		String gsonString = gson.toJson(DC); // Creates a JSON string of the DeleteCalendar Class. 
		return gsonString; // Returns the JSON string to the client. 
			

	}
	/**
	 * Allows the superAdmin to block or unblock a user.
	 * @param userName, the name of the user who is to be blocked or unblocked. 
	 * @param blocked, a boolean variable to decide whether the user is to be blocked or unblocked. 
	 * @return gsonString, A JsonString created from an object of the class BlockUser.
	 * @throws SQLException
	 */
	public Object blockUser (String userName, boolean blocked) throws SQLException
	{

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

		String gsonString = gson.toJson(BU); // Creates a JSON string of the BlockUser Class.
		return gsonString; // Returns the JSON string to the client. 

	}
	/**
	 * This method allows the user to remove an event 
	 * @param eventID
	 * @param title
	 * @return
	 * @throws SQLException
	 */
	public String removeEvent (String superID) throws SQLException
	{

		String eventIDOfCreator ="";
		String eventExists = "";
		resultSet = qb.selectFrom("events").where("superID", "=", superID).ExecuteQuery();

		while(resultSet.next())
		{
			eventExists = resultSet.toString();
			eventIDOfCreator = resultSet.getString("superID");
		}
		if(!eventExists.equals(""))
		{

			if(!eventIDOfCreator.equals(superID))
			{
				DE.setAnswer("Only the creator of the event is able to delete it.");
			}
			else
			{

				qb.deleteFrom("events").where("superID", "=", superID).Execute();
				DE.setAnswer("Event has been removed"); 
			}

		}
		else
		{
			DE.setAnswer("The event you are trying to delete, does not exists.");
		}

		String gsonString = gson.toJson(DE);
		return gsonString;

	}
	/**
	 * This method extracts all information about the different calendars from the database and inserts the information into an
	 * ArrayList of the class CalendarData. 
	 * @return gsonString, A JsonString created from an object of the array calendarData.
	 * @throws SQLException
	 */
	public String getCalendar () throws SQLException
	{


		resultSet = qb.selectFrom("calendar").all().ExecuteQuery();

		while(resultSet.next()){

			int CalendarID = resultSet.getInt("CalendarID");
			int type = resultSet.getInt("type");		
			String Name = resultSet.getString("Name");		
			int Active = resultSet.getInt("Active");	
			String CreatedBy = resultSet.getString("CreatedBy");		
			int PrivateOrPublic = resultSet.getInt("PrivatePublic");


			calendarData.add(new CalendarData(CalendarID,type, Name, Active, CreatedBy, PrivateOrPublic));


		}

		String gsonString5 = gson.toJson(calendarData);
		return gsonString5;


	}
	public String getEvents (String userName, String calendarName) throws SQLException
	{
		String stringToBeReturend = "";
		qb.selectFrom("events").all().Execute();

		return stringToBeReturend;


	}

	/**
	 * This method allows the user to add or update a note for a selected event. 
	 * @param superID, an ID that specifies which row in the events table is to be updated. 
	 * @param note, a String containing the note that is to be the new note. 
	 * @return gsonString, A JsonString created from an object of the class SaveNote.
	 * @throws SQLException
	 */
	public String AddNote (String superID, String note) throws SQLException
	{


		try {
			String [] keys = {"note"};
			String [] values = {note};
			qb.update("events", keys, values).where("superID", "=", superID).Execute();
			SN.setAnswer("The note has been updated!");

		} catch (Exception e) {

			e.printStackTrace();
		}


		String gsonString = gson.toJson(SN);
		return gsonString;

	}


}
