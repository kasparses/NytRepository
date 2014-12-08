package GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import ClientWorker.GiantSwitch;
import model.user.AuthenticateUser;
import model.user.EstablishUserModel;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import GUI.Screen;
import JsonClasses.AuthUserJson;
import JsonClasses.BlockUser;
import JsonClasses.CreateCalendar;
import JsonClasses.CreateEvent;
import JsonClasses.DeleteCalendar;
import JsonClasses.DeleteEvent;
import JsonClasses.EstablishUser;
import JsonClasses.ForgotLogin;
import JsonClasses.Login;
import JsonClasses.LoginAnswer;
import JsonClasses.SaveNote;

	//Creating an object for the classes
public class GUILogic {
	private Screen screen;
	AuthUserJson AU = new AuthUserJson();
	ForgotLogin FL = new ForgotLogin();
	DeleteCalendar DC = new DeleteCalendar();
	Gson gson = new GsonBuilder().create();
	LoginAnswer LA = new LoginAnswer();
	AuthenticateUser ForgotU = new AuthenticateUser();
	CreateCalendar CC = new CreateCalendar();
	JsonClasses.Login L = new Login();
	DeleteEvent DE = new DeleteEvent();
	BlockUser BU = new BlockUser();
	SaveNote SN = new SaveNote();
	GiantSwitch GS = new GiantSwitch();
	model.user.AuthenticateUser a = new model.user.AuthenticateUser();

	//Adding the screen and the ActionListeners
	public GUILogic(){
		screen = new Screen();


		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener());
		screen.getUserList().addActionListener(new UserListActionListener());
		screen.getEventlist().addActionListener(new EventListActionListener());
		screen.getAddEventGUI().addActionListener(new AddEventGUIActionListener());
		screen.getAddUser().addActionListener(new AddUserActionListener());
		screen.getForgotLogin().addActionListener(new ForgotActionListener());
		screen.getCalendarList().addActionListener(new CalendarListActionListener());
		screen.getDeleteEvent().addActionListener(new DeleteEventActionListener());
		screen.getDeleteCalendar().addActionListener(new DeleteCalendarActionListener());
		screen.getCreateCalendar().addActionListener(new CreateCalendarActionListener());
		screen.getBlockUser().addActionListener(new BlockUserActionListener());



	}
	//Creating the run method so the logic class can be run
	public void run() {

		screen.show(Screen.LOGIN);
		screen.setVisible(true);
	}

	/**
	 * The purpose of this ActionListener is so the admin can login if they are active
	 * @author Mathias
	 *
	 */
	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try{

				//Initializes the inserted text from the admin to variables
				String email = screen.getLogin().getTextFieldUsername().getText();
				String password = screen.getLogin().getTextFieldPassword().getText();

				//Setting the variables to the Json objects
				AU.setEmail(email);
				AU.setPassword(password);

				//Converting the objects to Json and back again to Java after use of GiantSwitch
				Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(AU);
				String hejhej33 = (String)GS.GiantSwitchMethod(gsonString);
				LoginAnswer LA = gson.fromJson(hejhej33, LoginAnswer.class);  

				//If statements
				if (LA.getAnswer().equals("correct")){
					screen.show(Screen.MAINMENU);
				}
				if(!LA.getAnswer().equals("correct")){
					JOptionPane.showMessageDialog(null, "\nPlease enter a valid username & password."
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
				if(LA.getActive().equals("active")){
					screen.show(Screen.MAINMENU);

				}
				if(!LA.getActive().equals("active")){
					JOptionPane.showMessageDialog(null, "Your account has been set inactive.\nPlease contact us via this email:\n"
							+ "help@cbs.dk"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
					
				}
				if (e.getSource() == screen.getLogin().getBtnForgotLogIn()){

					screen.show(Screen.FORGOT);

				}
			}	
			catch(Exception e3){
			}
		}	
	}

	/**
	 * The purpose of this ActionListener is to give the admin the forgotten login via a correct inserted security number
	 * @author Mathias
	 *
	 */
	private class ForgotActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getForgotLogin().getBtnLogin()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getForgotLogin().getBtnGetLogin()){
				try {
					
					//Initializes the inserted text from the admin to variables
					String cPR = screen.getForgotLogin().getTextField_CPR().getText();
					
					//Setting the variables to the Json objects
					FL.setCPR(cPR);
					
					//Converting the objects to Json and back again to Java after use of GiantSwitch
					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(FL);
					String hejhej35 = (String)GS.GiantSwitchMethod(gsonString);
					ForgotLogin FL = gson.fromJson(hejhej35, ForgotLogin.class);

					//Else if statements
					if (FL.getAnswer().equals("correct")){
						JOptionPane.showMessageDialog(null, "Your username is: "+FL.getEmail()+"\nYour password is: "+FL.getPassword()
								, "Message",JOptionPane.PLAIN_MESSAGE);
					}
					else if(!FL.getAnswer().equals("correct")){
						JOptionPane.showMessageDialog(null, "Please enter a valid security number."
								, "Error",JOptionPane.PLAIN_MESSAGE);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}

	}

	/**
	 * The purpose of this ActionListener is to show the admin the Main Menu
	 * @author Mathias
	 *
	 */
	 
	private class MainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getMainMenu().getBtnLogOut()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getMainMenu().getBtnUserlist()){
				screen.show(Screen.USERLIST);
			}
			
			if (e.getSource() == screen.getMainMenu().getBtnEventlist()){
				screen.show(Screen.EVENTLIST);
			}
			if (e.getSource() == screen.getMainMenu().getBtnCalendarList()){
				screen.show(Screen.CALENDARLIST);
			}
			
		}
	}
	
	/**
	 * The purpose of this ActionListener is to add a new event to a calendar
	 * @author Mathias
	 *
	 */
	private class AddEventGUIActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getAddEventGUI().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getAddEventGUI().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getAddEventGUI().getBtnCalendarList()){
				screen.show(Screen.CALENDARLIST);
			}
			if (e.getSource() == screen.getAddEventGUI().getBtnEventList()){
				
				screen.show(Screen.EVENTLIST);
			}
			
			if (e.getSource() == screen.getAddEventGUI().getBtnUserList()){
				screen.show(Screen.USERLIST);
			}
		
			if (e.getSource() == screen.getAddEventGUI().getBtnSubmit()){
				
				//Initializes variables, booleans and objects
				boolean empty = false;
				boolean timeError = false;
				String description = screen.getAddEventGUI().getTextField_Description().getText();
				String location = screen.getAddEventGUI().getTextField_Location().getText();
				String title = screen.getAddEventGUI().getTextField_Title().getText();
				String type = "1";
				String EventID = "1";
				String activityID = "1";
				String calendarName =  screen.getAddEventGUI().getTextField_CalendarName().getText();
				String note = screen.getAddEventGUI().getTextField_Text().getText();

				Object startYear = screen.getAddEventGUI().getComboBox_StartYear().getSelectedItem();
				Object startMonth = screen.getAddEventGUI().getComboBox_StartMonth().getSelectedItem();
				Object startDay = screen.getAddEventGUI().getComboBox_StartDay().getSelectedItem();
				Object startHour = screen.getAddEventGUI().getComboBox_StartHour().getSelectedItem();
				Object startMinutes = screen.getAddEventGUI().getComboBox_StartMinutes().getSelectedItem();

				Object endYear = screen.getAddEventGUI().getComboBox_EndYear().getSelectedItem();
				Object endMonth = screen.getAddEventGUI().getComboBox_EndMonth().getSelectedItem();
				Object endDay = screen.getAddEventGUI().getComboBox_EndDay().getSelectedItem();
				Object endHour = screen.getAddEventGUI().getComboBox_EndHour().getSelectedItem();
				Object endMinutes = screen.getAddEventGUI().getComboBox_EndMinutes().getSelectedItem();

				String endHourString = endHour.toString();
				String endMinutesString = endMinutes.toString();
				String endDayString = endDay.toString();
				String endMonthString = endMonth.toString();
				String endYearString = endYear.toString();
				
				String startHourString = startHour.toString();
				String startMinutesString = startMinutes.toString();
				String startDayString = startDay.toString();
				String startMonthString = startMonth.toString();
				String startYearString = startYear.toString();
				
				int endHourInt = Integer.parseInt(endHourString);
				int endMinutesInt = Integer.parseInt(endMinutesString);
				int endDayInt = Integer.parseInt(endDayString);
				int endMonthInt = Integer.parseInt(endMonthString);
				int endYearInt = Integer.parseInt(endYearString);
				
				int startHourInt = Integer.parseInt(startHourString);
				int startMinutesInt = Integer.parseInt(startMinutesString);
				int startDayInt = Integer.parseInt(startDayString);
				int startMonthInt = Integer.parseInt(startMonthString);
				int startYearInt = Integer.parseInt(startYearString);
				
				//If statements
				if(startHourInt> endHourInt){
					timeError = true;
				}
				if (startHourInt == endHourInt && startMinutesInt> endMinutesInt){
					timeError = true;
				}
				if (startDayInt > endDayInt){
					timeError = true;
				}
				if (startMonthInt > endMonthInt){
					timeError = true;
				}
				if(startYearInt> endYearInt){
					timeError = true;
				}
				
				

				if (timeError == true){
					JOptionPane.showMessageDialog(null, "\nYou cannot create an event that ends before it starts. "
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
				
				if(startMinutes.equals("0")){
					startMinutes = "00";
				}

				if(endMinutes.equals("0")){
					endMinutes = "00";
				}

				//Creating the start and end time
				String start = startYear.toString()+ "-"+ startMonth.toString()+ "-"+ startDay.toString()+ " "+startHour.toString()+":"+startMinutes+":00";
				String end = endYear.toString()+ "-"+ endMonth.toString()+ "-"+ endDay.toString()+ " "+endHour.toString()+":"+endMinutes+":00";

				//If statements
				if (title.equals("")||location.equals("")|| calendarName.equals("")|| description.equals(""))
				{
					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
					empty = true;
				}
				
				if (empty == false && timeError == false ){
				CreateEvent CE = new CreateEvent("createEvent", 0,activityID,EventID , type, title, description, start, end, location,  calendarName ,note);

	            //Converting the objects to Json via gson
				Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(CE);

				try {
					//Calls the GiantSwitchMethod with the gsonString
					String CreateEvent = (String)GS.GiantSwitchMethod(gsonString);
					
					//Converting Json to Java via gson
					CreateEvent CEanswer = (CreateEvent)gson.fromJson(CreateEvent, CreateEvent.class);
					
					JOptionPane.showMessageDialog(null, CEanswer.getAnswer()
							, "Return message",JOptionPane.PLAIN_MESSAGE);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
			}
		}
	}
	
	/**
	 * The purpose of this ActionListener is to add a new user
	 * @author Mathias
	 *
	 */
	private class AddUserActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getAddUser().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getAddUser().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getAddUser().getBtnCalendarList()){
				screen.show(Screen.CALENDARLIST);
			}
			if (e.getSource() == screen.getAddUser().getBtnEventList()){

				screen.show(Screen.EVENTLIST);
			}
			
			if (e.getSource() == screen.getAddUser().getBtnUserList()){
				screen.show(Screen.USERLIST);
			}
		
			if (e.getSource() == screen.getAddUser().getBtnCreateUser()){

				//Initializes the inserted text to variables
				String Email = screen.getAddUser().getTextField_Email().getText();
				String Password = screen.getAddUser().getTextField_Password().getText();
				String CPR = screen.getAddUser().getTextField_CPR().getText();
				int Active = 1;
				String UpdatedCbsEvents = "notUpdated";

				//If else statement
				if (Email.equals("")|| Password.equals("") || CPR.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please fill out all the fields."
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					//Setting the variables to objects in the Json class EstablishUser
					EstablishUser EU = new EstablishUser("establishUser", Email , Active, Password, CPR, UpdatedCbsEvents );

		            //Converting the objects to Json via gson
					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(EU);

					try {
						//Calling the method from GiantSwitch class
						String establishUser = (String) GS.GiantSwitchMethod(gsonString);
						
						//Converting the answer from Json to Java via gson
						EstablishUser EUanswer = (EstablishUser)gson.fromJson(establishUser, EstablishUser.class);
						
						JOptionPane.showMessageDialog(null, EUanswer.getAnswer()
								, "Message",JOptionPane.PLAIN_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			}
		}
	}
	
	
	/**
	 * The purpose of this ActionListerner is to show admin the User list 
	 * @author Mathias
	 *
	 */
	private class UserListActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getUserList().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getUserList().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getUserList().getBtnAdd()){
				screen.show(Screen.ADDUSER);

			}
			if (e.getSource() == screen.getUserList().getBtnBlock()){
				screen.show(Screen.BLOCKUSER);

			}

		}
	}

	/**
	 * The purpose of this ActionListener is to show admin the Event list and to add, delete 
	 * and update a note to a specific event
	 * @author Mathias
	 *
	 */
	private class EventListActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getEventlist().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getEventlist().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getEventlist().getBtnAdd()){
				screen.show(Screen.ADDEVENT);
			}
			if (e.getSource() == screen.getEventlist().getBtnDelete()){
				screen.show(Screen.DELETEEVENT);
			}
			
			
			if (e.getSource() == screen.getEventlist().getBtnAddNote()){
				
				//Initializes the choice from the ComboBox and the inserted text to variables
				Object superID = screen.getEventList().getComboBox().getSelectedItem();
				String superIDString = superID.toString();	
				int superIDint = Integer.parseInt(superIDString);
	            String note = screen.getEventList().getTextField().getText();

	            //Setting the variables to objects in the Json class SaveNote
	            SN.setSuperID(superIDint);
	            SN.setNote(note);
	            
	            //Converting the objects to Json via gson
	            Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(SN);

				
					try {
						//Converting the object back to Java via gson
						String addNote = (String) GS.GiantSwitchMethod(gsonString);
						SN = gson.fromJson(addNote, SaveNote.class);

						JOptionPane.showMessageDialog(null, SN.getAnswer()
								, "Return message",JOptionPane.PLAIN_MESSAGE);
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				
			}
			if (e.getSource() == screen.getEventlist().getBtnDeleteNote()){
				
				Object superID = screen.getEventList().getComboBox().getSelectedItem();
				String superIDString = superID.toString();	
				int superIDint = Integer.parseInt(superIDString);
				
	            String note = "";

	            SN.setSuperID(superIDint);
	            SN.setNote(note);
	            
	            Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(SN);

				
					try {
						String deleteNote = (String) GS.GiantSwitchMethod(gsonString);
						SN = gson.fromJson(deleteNote, SaveNote.class);

						JOptionPane.showMessageDialog(null, SN.getAnswer()
								, "Return message",JOptionPane.PLAIN_MESSAGE);
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				
				
			}
			if (e.getSource() == screen.getEventlist().getBtnUpdateNote()){
				
				Object superID = screen.getEventList().getComboBox().getSelectedItem();
				String superIDString = superID.toString();	
				int superIDint = Integer.parseInt(superIDString);
				
	            String note = screen.getEventList().getTextField().getText();

	            SN.setSuperID(superIDint);
	            SN.setNote(note);
	            
	            Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(SN);

				
					try {
						String addNote = (String) GS.GiantSwitchMethod(gsonString);
						SN = gson.fromJson(addNote, SaveNote.class);

						JOptionPane.showMessageDialog(null, SN.getAnswer()
								, "Return message",JOptionPane.PLAIN_MESSAGE);
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		}
	}

	/**
	 * The purpose of this ActionListener is to show the admin the calendar list
	 * @author Mathias
	 *
	 */
	private class CalendarListActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getCalendarList().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getCalendarList().getBtnLogOut()){

				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getCalendarList().getBtnAdd()){

				screen.show(Screen.CREATECALENDAR);

			}
			if (e.getSource() == screen.getCalendarList().getBtnDelete()){

				screen.show(Screen.DELETECALENDAR);
			}
		}
	}
	/**
	 * The purpose of this ActionListener is so the admin can set a calendar active or inactive in the database
	 * @author Mathias
	 *
	 */
	private class DeleteCalendarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getDeleteCalendar().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getDeleteCalendar().getBtnLogOut()){

				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getDeleteCalendar().getBtnCalendarList()){

				screen.show(Screen.CALENDARLIST);
			}
			if (e.getSource() == screen.getDeleteCalendar().getBtnEventList()){

				screen.show(Screen.EVENTLIST);
			}
			
			if (e.getSource() == screen.getDeleteCalendar().getBtnUserList()){

				screen.show(Screen.USERLIST);
			}
			
			if (e.getSource() == screen.getDeleteCalendar().getBtnSetInactive()){
				try {
					
					//Initializes the boolean to be false because the button SetInactive was chosen
					DC.setActive(false);
					
					//Initializes variables
					String userName = AU.getEmail();
					String calendarName = screen.getDeleteCalendar().getTextField_CalendarName().getText();

					//Setting the variables to objects in the Json class DeleteCalendar
					DC.setUserName(userName);
					DC.setCalendarName(calendarName);

		            //Converting the objects to Json via gson
					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(DC);
					
					//Calls the method from GiantSwitch
					String DeleteCalendar = (String)GS.GiantSwitchMethod(gsonString);
					
					//Converting the object back to Java from Json via gson
					DC = gson.fromJson(DeleteCalendar, DeleteCalendar.class);

					JOptionPane.showMessageDialog(null, DC.getAnswer()
							, "Message",JOptionPane.PLAIN_MESSAGE);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (e.getSource() == screen.getDeleteCalendar().getBtnSetActive()){
				try {
					DC.setActive(true);
					
					String userName = AU.getEmail();
					System.out.println(userName);
					String calendarName = screen.getDeleteCalendar().getTextField_CalendarName().getText();

					DC.setUserName(userName);
					DC.setCalendarName(calendarName);

					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(DC);
					
					String DeleteCalendar = (String)GS.GiantSwitchMethod(gsonString);
					
					DC = gson.fromJson(DeleteCalendar, DeleteCalendar.class);

					JOptionPane.showMessageDialog(null, DC.getAnswer()
							, "Error message",JOptionPane.PLAIN_MESSAGE);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	/**
	 * The purpose of this ActionListener is so the admin can create a new calendar
	 * @author Mathias
	 *
	 */
	private class CreateCalendarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getCreateCalendar().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getCreateCalendar().getBtnLogOut()){

				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getCreateCalendar().getBtnCalendarList()){

				screen.show(Screen.CALENDARLIST);

			}
			if (e.getSource() == screen.getCreateCalendar().getBtnEventList()){

				screen.show(Screen.EVENTLIST);

			}
			
			if (e.getSource() == screen.getCreateCalendar().getBtnUserList()){

				screen.show(Screen.USERLIST);

			}
			
			if (e.getSource() == screen.getCreateCalendar().getBtnCreateCalendar()){
				boolean empty = false;
				String name = screen.getCreateCalendar().getTextField_Name().getText();
				String CreatedBy = AU.getEmail();
				int type = 2; //2 means that the calendar is created by an user/admin and not uploaded from CBS
				int active = 1; // 1 means that the calendar is active. 2 means that the calendar is inactive.

				if( name.equals("")) {

					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
					empty = true;
				}

				boolean PrivateOrPublic = false;
				int PrivateOrPublicValue = 0;


				if (screen.getCreateCalendar().getRdbtnPrivateCalendar().isSelected())
				{
					PrivateOrPublicValue = 2; //2 is equal a private calendar.
					PrivateOrPublic = true;
				}
				if (screen.getCreateCalendar().getRdbtnPublicCalendar().isSelected())
				{
					PrivateOrPublicValue = 1; //1 is equal a public calendar.
					PrivateOrPublic = true;
				}


				if( PrivateOrPublic == false){
					JOptionPane.showMessageDialog(null, "Please select whether your calendar is a public or a private calendar"
							, "Error message",JOptionPane.PLAIN_MESSAGE);

				}

				if (empty == false && PrivateOrPublic == true){
					CC.setCalendarName(name);
					CC.setPublicOrPrivate(PrivateOrPublicValue);
					CC.setType(type);
					CC.setActive(active);
					CC.setUserName(CreatedBy);

					try {
						Gson gson = new GsonBuilder().create();
						String gsonString = gson.toJson(CC);
						String CreateCalendar = (String)GS.GiantSwitchMethod(gsonString);
						CC = gson.fromJson(CreateCalendar, CreateCalendar.class);

						JOptionPane.showMessageDialog(null, CC.getAnswer()
								, "Return message",JOptionPane.PLAIN_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			}
		}

	}
	/**
	 * The purpose of this ActionListener is to delete events from calendars. Only the creator can delete the specific event.
	 * @author Mathias
	 *
	 */
	private class DeleteEventActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getDeleteEvent().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getDeleteEvent().getBtnLogOut()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getDeleteEvent().getBtnEventList()){
				screen.show(Screen.EVENTLIST);

			}
			if (e.getSource() == screen.getDeleteEvent().getBtnCalendarList()){
				screen.show(Screen.CALENDARLIST);

			}
			
			if (e.getSource() == screen.getDeleteEvent().getBtnUserList()){
				screen.show(Screen.USERLIST);

			}
			
			if (e.getSource() == screen.getDeleteEvent().getBtnDelete()){

				try {
					String eventID = screen.getDeleteEvent().getTextField_EventID().getText();
					String title = screen.getDeleteEvent().getTextField_Title().getText();

					DE.setEventID(eventID);
					DE.setTitle(title);

					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(DE);
					String DeleteEvent = (String)GS.GiantSwitchMethod(gsonString);
					DC = gson.fromJson(DeleteEvent, DeleteCalendar.class);

					JOptionPane.showMessageDialog(null, DC.getAnswer()
							, "Return message",JOptionPane.PLAIN_MESSAGE);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}



			}

		}
	}
	/**
	 * The purpose of this ActionListener is to block and unblock users by setting them active and inactive.
	 * @author Mathias
	 *
	 */
	private class BlockUserActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getBlockUser().getBtnLogOut()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getBlockUser().getBtnUserList()){
				screen.show(Screen.USERLIST);
			}
			
			if (e.getSource() == screen.getBlockUser().getBtnEventList()){
				screen.show(Screen.EVENTLIST);
			}
			if (e.getSource() == screen.getBlockUser().getBtnCalendarList()){
				screen.show(Screen.CALENDARLIST);
			}
			if (e.getSource() == screen.getBlockUser().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
		
			if (e.getSource() == screen.getBlockUser().getBtnBlockUser()){

				try {
					BU.setBlocked(true);
					
					String userName = screen.getBlockUser().getTextField_Username().getText();
					
					BU.setEmail(userName);
					
					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(BU);
					
					String BlockUser = (String)GS.GiantSwitchMethod(gsonString);
					
					BU = gson.fromJson(BlockUser, BlockUser.class);


					JOptionPane.showMessageDialog(null, BU.getAnswer()
							, "Return message",JOptionPane.PLAIN_MESSAGE);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}


			}
			if (e.getSource() == screen.getBlockUser().getBtnUnblockUser()){

				try {
					BU.setBlocked(false);
					String userName = screen.getBlockUser().getTextField_Username().getText();
					BU.setEmail(userName);
					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(BU);
					String BlockUser = (String)GS.GiantSwitchMethod(gsonString);
					BU = gson.fromJson(BlockUser, BlockUser.class);


					JOptionPane.showMessageDialog(null, BU.getAnswer()
							, "Return message",JOptionPane.PLAIN_MESSAGE);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
