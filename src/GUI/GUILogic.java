package GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import ClientWorker.GiantSwitch;
import model.user.AuthenticateUser;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;

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
import JsonClasses.Update;
import GUI.EventList;

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




	GiantSwitch GS = new GiantSwitch();

	model.user.AuthenticateUser a = new model.user.AuthenticateUser();

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
	public void run() {

		screen.show(Screen.LOGIN);
		screen.setVisible(true);
	}

	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try{

				String email = screen.getLogin().getTextFieldUsername().getText();
				String password = screen.getLogin().getTextFieldPassword().getText();

				AU.setEmail(email);
				AU.setPassword(password);


				Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(AU);
				String hejhej33 = (String)GS.GiantSwitchMethod(gsonString);
				LoginAnswer LA = gson.fromJson(hejhej33, LoginAnswer.class);  


				if (LA.getAnswer().equals("correct")){
					screen.show(Screen.MAINMENU);
				}
				if(!LA.getAnswer().equals("correct")){
					JOptionPane.showMessageDialog(null, "\nPlease enter a valid username & password."
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

	private class ForgotActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getForgotLogin().getBtnLogin()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getForgotLogin().getBtnGetLogin()){
				try {

					String cPR = screen.getForgotLogin().getTextField_CPR().getText();

					FL.setCPR(cPR);

					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(FL);
					String hejhej35 = (String)GS.GiantSwitchMethod(gsonString);
					ForgotLogin FL = gson.fromJson(hejhej35, ForgotLogin.class);


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


				boolean empty = false;
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



				if(startMinutes.equals("0")){
					startMinutes = "00";
				}

				Object endYear = screen.getAddEventGUI().getComboBox_EndYear().getSelectedItem();
				Object endMonth = screen.getAddEventGUI().getComboBox_EndMonth().getSelectedItem();
				Object endDay = screen.getAddEventGUI().getComboBox_EndDay().getSelectedItem();
				Object endHour = screen.getAddEventGUI().getComboBox_EndHour().getSelectedItem();
				Object endMinutes = screen.getAddEventGUI().getComboBox_EndMinutes().getSelectedItem();

				if(endMinutes.equals("0")){
					endMinutes = "00";
				}

				String start = startYear.toString()+ "-"+ startMonth.toString()+ "-"+ startDay.toString()+ " "+startHour.toString()+":"+startMinutes+":00";
				String end = endYear.toString()+ "-"+ endMonth.toString()+ "-"+ endDay.toString()+ " "+endHour.toString()+":"+endMinutes+":00";

				
				if (title.equals("")||location.equals("")|| calendarName.equals("")|| description.equals(""))
				{
					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
					empty = true;
				}
				
				if (empty == false){
				CreateEvent CE = new CreateEvent("createEvent", 0,activityID,EventID , type, title, description, start, end, location,  calendarName ,note);

				Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(CE);

				try {
					String CreateEvent = (String)GS.GiantSwitchMethod(gsonString);
					
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


				String Email = screen.getAddUser().getTextField_Email().getText();
				String Password = screen.getAddUser().getTextField_Password().getText();
				String CPR = screen.getAddUser().getTextField_CPR().getText();
				int Active = 1;
				String UpdatedCbsEvents = "notUpdated";
				boolean adminOrUser = false;
				String adMinOrUserValue = "";


				if (screen.getAddUser().getRdbtnAdmin().isSelected())
				{
					adMinOrUserValue = "1"; 
					adminOrUser = true;
				}
				if (screen.getAddUser().getRdbtnUser().isSelected())
				{
					adMinOrUserValue = "2"; 
					adminOrUser = true;
				}


				if( adminOrUser == false){
					JOptionPane.showMessageDialog(null, "Please select whether the account is an admin or a user"
							, "Error message",JOptionPane.PLAIN_MESSAGE);

				}


				if (Email.equals("")|| Password.equals("") || CPR.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please fill out all the fields."
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					EstablishUser EU = new EstablishUser("establishUser", Email , Active, adMinOrUserValue, Password, CPR, UpdatedCbsEvents );

					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(EU);

					try {
						Object establishUser = GS.GiantSwitchMethod(gsonString);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			}
		}
	}
	
	

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
		}
	}

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
					DC.setActive(false);
					String userName = AU.getEmail();
					String calendarName = screen.getDeleteCalendar().getTextField_CalendarName().getText();

					DC.setUserName(userName);
					DC.setCalendarName(calendarName);

					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(DC);
					String DeleteCalendar = (String)GS.GiantSwitchMethod(gsonString);
					DC = gson.fromJson(DeleteCalendar, DeleteCalendar.class);

					JOptionPane.showMessageDialog(null, "\n"+DC.getAnswer()
							, "Error message",JOptionPane.PLAIN_MESSAGE);

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
				int type = 2; //2 betyder er det er en brugerskabt kalender og ikke den som er hentet fra CBS.
				int active = 1; // 1 betyder at den er aktiv. 2 betyder at den ikke er aktiv.

				if( name.equals("")) {

					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
					empty = true;
				}

				boolean PrivateOrPublic = false;
				int PrivateOrPublicValue = 0;


				if (screen.getCreateCalendar().getRdbtnPrivateCalendar().isSelected())
				{
					PrivateOrPublicValue = 2; //2 er lig med private.
					PrivateOrPublic = true;
				}
				if (screen.getCreateCalendar().getRdbtnPublicCalendar().isSelected())
				{
					PrivateOrPublicValue = 1; //1 er lig med public.
					PrivateOrPublic = true;
				}


				if( PrivateOrPublic == false){
					JOptionPane.showMessageDialog(null, "Please select whether your database is a public or a private database"
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
