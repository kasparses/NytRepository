package ClientWorker;

import java.sql.SQLException;
import model.user.*;
import JsonClasses.BlockUser;
import JsonClasses.CreateEvent;
import JsonClasses.ForgotLogin;
import JsonClasses.AuthUserJson;
import JsonClasses.CalendarInfo;
import JsonClasses.CreateCalendar;
import JsonClasses.DeleteCalendar;
import JsonClasses.EstablishUser;
import JsonClasses.SaveNote;
import JsonClasses.UpdateLoginTime;
import model.QueryBuild.*;
import JsonClasses.DeleteEvent;
import com.google.gson.*;
import JsonClasses.GetCbsCalendar;
import model.calendar.*;
import model.DailyUpdate.*;
import databaseMethods.SwitchMethods;
import model.Forecast.ForecastTest;
public class GiantSwitch {
	
	model.user.AuthenticateUser a = new model.user.AuthenticateUser();
	
	public Object GiantSwitchMethod(String jsonString) throws SQLException {

		QOTDModel QOTDKlasse = new QOTDModel();
		SwitchMethods SW = new SwitchMethods();	
		
		AddEventModel AE = new AddEventModel();
		EstablishUserModel EUM = new EstablishUserModel();
		Gson gson = new GsonBuilder().create();
		QOTDModel qotdmodel = new QOTDModel();
		DailyUpdateController DUC = new DailyUpdateController();
		QueryBuilder qb = new QueryBuilder();
		model.calendar.GetCalendarData GCD = new model.calendar.GetCalendarData();
		DeleteEvent DE = new DeleteEvent();
		ForecastTest FT = new ForecastTest();
		AuthUserJson AU = new AuthUserJson();
		
		Object answer = "";	

		//Creates a switch which determines which method should be used. Methods will be applied later on
		switch (Determine(jsonString)) {
		//If the Json String contains one of the keywords below, run the relevant method.


		/**********
		 ** LOGIN **
		 **********/
		
		
		case "logIn":
			
			AU = (AuthUserJson)gson.fromJson(jsonString, AuthUserJson.class);
			
			try {
				answer =a.authenticate(AU.getEmail(), AU.getPassword());
	
			} catch (Exception e) {

				e.printStackTrace();
			}
			break;
			
		case "forgotLogin":
		
			ForgotLogin FL = (ForgotLogin)gson.fromJson(jsonString, ForgotLogin.class);
			
			try {
				answer =a.getLogin(FL.getCPR());
	
			} catch (Exception e) {

				e.printStackTrace();
			}
			break;
			
			
		/**********
		 ** USERS **
		 **********/
			
		case "establishUser":
			EstablishUser EU = (EstablishUser)gson.fromJson(jsonString, EstablishUser.class);
			answer = EUM.EstablishUser(EU.getEmail(),EU.getActive(),
					EU.getPassword(),EU.getCPR(),EU.getUpdatedCbsEvents());
		
			break;
			
		case "blockUser":
			
			BlockUser BU = (BlockUser)gson.fromJson(jsonString, BlockUser.class);
			BU = (BlockUser)gson.fromJson(jsonString, BlockUser.class);
			answer = SW.blockUser(BU.getEmail(), BU.isBlocked());
		
			break;

		/*************
		 ** CALENDAR **
		 *************/
		case "createCalendar":
			CreateCalendar CC = (CreateCalendar)gson.fromJson(jsonString, CreateCalendar.class);
			answer = SW.createNewCalendar(CC.getType(),CC.getCalendarName(),CC.getActive(),CC.getUserName(), CC.getPublicOrPrivate());
			break;
		
		case "deleteCalendar":
			DeleteCalendar DC = (DeleteCalendar)gson.fromJson(jsonString, DeleteCalendar.class);
			answer = SW.removeCalendar(DC.getUserName(), DC.getCalendarName(), DC.isActive());

			break;
		
		
			
		case "getCalendar":
			answer = SW.getCalendar();
			
			break;

		case "getEvents":
			CalendarInfo CI2 = (CalendarInfo)gson.fromJson(jsonString, CalendarInfo.class);
			answer = SW.getEvents(CI2.getCalenderName(), CI2.getUserName());
			break;

		case "createEvent":
			CreateEvent CE = (CreateEvent)gson.fromJson(jsonString, CreateEvent.class);
			answer = AE.CreateEvent(CE.getID(), CE.getActivityID(),CE.getEventID(), CE.getType(), CE.getTitle(),
					CE.getDescription(), CE.getStart(), CE.getEnd(), CE.getLocation(),CE.getNote(), CE.getCalendarName());
			break;

			
		case "deleteEvent":
			DE = (DeleteEvent)gson.fromJson(jsonString, DeleteEvent.class);
			answer = SW.removeEvent(DE.getEventID(), DE.getTitle());
			break;
			
		case "GetCbsCalendar":
			GetCbsCalendar GCBS = (GetCbsCalendar)gson.fromJson(jsonString, GetCbsCalendar.class);
			try {
				answer = GCD.getDataFromCalendar(GCBS.getUserName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		case "createNote":
			break;
			
		case "saveNote":						
			SaveNote SN = (SaveNote)gson.fromJson(jsonString, SaveNote.class);
			try {
				answer = SW.AddNote(Integer.toString(SN.getSuperID()),SN.getNote());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;

		case "getNote":
		
			break;
			
		case "deleteNote":
			break;

		/**********
		 ** QUOTE **
		 **********/
	
		                                                                                                                                              
		case "LoginTime":
			UpdateLoginTime ULT = (UpdateLoginTime)gson.fromJson(jsonString, UpdateLoginTime.class);
			answer = SW.UpdateLoginTime(ULT.getLoginTime(),ULT.getUserName());
			break;
			
		case "DailyUpdate":
			answer = DUC.dailyUpdate();
	
			break;
		/************
		 ** WEATHER **
		 ************/

		case "getClientForecast":
			answer = FT.getForeCastFromDatabase();
			break;
		
		default:
			break;
		}
		return answer;
		
		
	}

	//Creates a long else if statement, which checks the JSon string which keyword it contains, and returns the following 
	//keyword if
	public String Determine(String ID) {

		if (ID.contains("getEvents")) {
			return "getEvents";
		} else if (ID.contains("getEventInfo")) {
			return "getEventInfo";
		} else if (ID.contains("saveNote")) {
			return "saveNote";
		} else if (ID.contains("getNote")) {
			return "getNote";
		} else if (ID.contains("deleteNote")){
			return "deleteNote";
		}else if  (ID.contains("deleteCalendar")){
			return "deleteCalendar";
		} else if (ID.contains("getClientForecast")) {
			return "getClientForecast";
		} else if (ID.contains("saveImportedCalendar")) {
			return "saveImportedCalendar";
		}else if (ID.contains("importCourse")) {
			return "importCourse";
		} else if (ID.contains("exportCourse")) {
			return "exportCourse";
		} else if (ID.contains("getQuote")) {
			return "getQuote";
		} else if (ID.contains("logIn")) {
			return "logIn";
		} else if (ID.contains("logOut")) {
			return "logOut";
		} else if (ID.contains("getCalendar")) {
			return "getCalendar";
		} else if (ID.contains("createEvent")) {
			return "createEvent";
		} else if (ID.contains("deleteEvent")) {
			return "deleteEvent"; 
		} else if (ID.contains("createCalendar")) {
			return "createCalendar";
		} else if (ID.contains("LoginTime")) {
			return "LoginTime";
		} else if (ID.contains("DailyUpdate")) {
			return "DailyUpdate";
		} else if (ID.contains("GetCbsCalendar")) {
			return "GetCbsCalendar";
		} else if (ID.contains("establishUser")) {
			return "establishUser";
		} else if (ID.contains("forgotLogin")) {
			return "forgotLogin";
		} else if (ID.contains("blockUser")) {
			return "blockUser";
		}

		else
			return "error";
	}
	

}
