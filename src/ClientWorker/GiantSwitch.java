package ClientWorker;
import java.sql.SQLException;
import model.QOTD.QOTDModel;
import model.note.Note;
import JsonClasses.AuthUser;
import JsonClasses.CalendarInfo;
import JsonClasses.CreateCalendar;
import JsonClasses.DeleteCalendar;
import JsonClasses.UpdateLoginTime;
import JsonClasses.Update;
import com.google.gson.*;
import model.QOTD.QOTDModel;
import model.DailyUpdate.*;
import databaseMethods.SwitchMethods;

public class GiantSwitch {
	private model.user.User u3;
	model.user.AuthenticateUser a = new model.user.AuthenticateUser();
	
	
	
	public Object GiantSwitchMethod(String jsonString) throws SQLException {

		QOTDModel QOTDKlasse = new QOTDModel();
		SwitchMethods SW = new SwitchMethods();	
		Gson gson = new GsonBuilder().create();
		QOTDModel qotdmodel = new QOTDModel();
		DailyUpdateController DUC = new DailyUpdateController();
		
		Object answer = "";	

		//Creates a switch which determines which method should be used. Methods will be applied later on
		switch (Determine(jsonString)) {
		//If the Json String contains one of the keywords below, run the relevant method.

		/************
		 ** COURSES **
		 ************/

		case "importCalendar":
			
			
			System.out.println("Recieved importCourse");
			break;

		/**********
		 ** LOGIN **
		 **********/
		case "logIn":
			AuthUser AU = (AuthUser)gson.fromJson(jsonString, AuthUser.class);
			System.out.println("Recieved logIn");
			try {
				answer =a.authenticate(AU.getAuthUserEmail(), AU.getAuthUserPassword());
	
			} catch (Exception e) {

				e.printStackTrace();
			}
			break;
			

		case "logOut":
			System.out.println("Recieved logOut");
			break;

		/*************
		 ** CALENDAR **
		 *************/
		case "createCalendar":
			CreateCalendar CC = (CreateCalendar)gson.fromJson(jsonString, CreateCalendar.class);
			answer = SW.createNewCalendar(CC.getType(),CC.getCalenderName(),CC.getActive(),CC.getUserName(), CC.getPublicOrPrivate());
			break;
		
		case "deleteCalendar":
			DeleteCalendar DC = (DeleteCalendar)gson.fromJson(jsonString, DeleteCalendar.class);
			answer = SW.deleteCalendar(DC.getUserName(), DC.getCalendarName());
			break;
		
		case "saveImportedCalendar":
			
			
			break;
			
		case "getCalendar":
			CalendarInfo CI = (CalendarInfo)gson.fromJson(jsonString, CalendarInfo.class);
			answer = SW.getCalendar(CI.getType(), CI.getCalenderName(), CI.getActive(), CI.getUserName(), CI.getPublicOrPrivate());
			System.out.println("Recieved getCalendar");
			break;

		case "getEvents":
			System.out.println("Recieved getEvents");
			break;

		case "createEvent":
			System.out.println("Recieved saveEvent");
			break;

		case "getEventInfo":
			System.out.println("Recieved getEventInfo");
			break;
			
		case "deleteEvent":
			System.out.println("Recieved deleteEvent");
		
		case "saveNote":
			System.out.println("Recieved saveNote");
			break;

		case "getNote":
			System.out.println("Recieved getNote");
			break;
			
		case "deleteNote":
			System.out.println("Recieved deleteNote");
			break;

		/**********
		 ** QUOTE **
		 **********/
		case "getQuote":
			

			answer = QOTDKlasse.getQuote();
			
			break;
		                                                                                                                                              
		case "LoginTime":
			UpdateLoginTime ULT = (UpdateLoginTime)gson.fromJson(jsonString, UpdateLoginTime.class);
			answer = SW.UpdateLoginTime(ULT.getLoginTime(),ULT.getUserName());
			System.out.println("blalb");
			break;
			
		case "DailyUpdate":
			answer = DUC.dailyUpdate();

			
			break;
		/************
		 ** WEATHER **
		 ************/

		case "getClientForecast":
			System.out.println("Recieved getClientForecast");
			break;
		
		default:
			System.out.println("Error");
			break;
		}
		return answer;
		
		
	}

	//Creates a loooong else if statement, which checks the JSon string which keyword it contains, and returns the following 
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
		}

		else
			return "error";
	}
	

}
