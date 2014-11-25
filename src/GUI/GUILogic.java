package GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import ClientWorker.GiantSwitch;
import model.QueryBuild.QueryBuilder;
import model.user.AuthenticateUser;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import GUI.Screen;
import JsonClasses.AuthUserJson;
import JsonClasses.CreateCalendar;
import JsonClasses.CreateEvent;
import JsonClasses.DeleteCalendar;
import JsonClasses.EstablishUser;
import JsonClasses.ForgotLogin;
import JsonClasses.Login;
import JsonClasses.LoginAnswer;


public class GUILogic {
	private Screen screen;
	private String u3;
	private AuthenticateUser u4;
	AuthUserJson AU = new AuthUserJson();
	ForgotLogin FL = new ForgotLogin();
	DeleteCalendar DC = new DeleteCalendar();
	Gson gson = new GsonBuilder().create();
	LoginAnswer LA = new LoginAnswer();
	AuthenticateUser ForgotU = new AuthenticateUser();
	CreateCalendar CC = new CreateCalendar();
	JsonClasses.Login L = new Login();



	
	GiantSwitch GS = new GiantSwitch();
	
	model.user.AuthenticateUser a = new model.user.AuthenticateUser();
	model.note.Note n = new model.note.Note();

	public GUILogic(){
		screen = new Screen();


		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener());
		screen.getUserInfo().addActionListener(new UserInfoActionListener());
		screen.getNoteList().addActionListener(new NoteListActionListener());
		screen.getUserList().addActionListener(new UserListActionListener());
		screen.getEventlist().addActionListener(new EventListActionListener());
		screen.getAddEventGUI().addActionListener(new AddEventGUIActionListener());
//		screen.getAddUser().addActionListener(new AddUserActionListener());
		screen.getAddNote().addActionListener(new AddNoteActionListener());
		screen.getForgotLogin().addActionListener(new ForgotActionListener());
		screen.getCalendarList().addActionListener(new CalendarListActionListener());

//		screen.getAddEventGUI().addActionListener(new CalendarListActionListener());

		screen.getDeleteCalendar().addActionListener(new DeleteCalendarActionListener());
		screen.getCreateCalendar().addActionListener(new CreateCalendarActionListener());


		
	}
	public void run() {

		screen.show(Screen.LOGIN);
		screen.setVisible(true);
	}
	
	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try{
				
//			String email = screen.getLogin().getTextFieldUsername().getText();
//			String password = screen.getLogin().getTextFieldPassword().getText();
//			u3 = "correct";
//					
//					//a.authenticate(email, password);
//			
//			if (e.getSource() == screen.getLogin().getBtnLogIn()){
//				System.out.println(u3);
//				if(u3.equals("notCorrect")){
//					JOptionPane.showMessageDialog(null, "\nPlease enter a valid username & password."
//							, "Error message",JOptionPane.PLAIN_MESSAGE);
//			}
//
//			if	(u3.equals("correct"))
//					{
//						screen.show(Screen.MAINMENU);
//					}
//				
//			}
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
//				String CPR = screen.getForgotLogin().getTextField_CPR().getText();
//				String answer = "";
//
////				CPR = AU.getCPR();
//
//				if (answer.equals("correct")){
////					String cpr = null;
//					JOptionPane.showMessageDialog(null, "\nYour username is: "+AU.getEmail()
//							, "Message",JOptionPane.PLAIN_MESSAGE);
//				}
				String cPR = screen.getForgotLogin().getTextField_CPR().getText();
				
				FL.setCPR(cPR);
				
				
				Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(FL);
				String hejhej35 = (String)GS.GiantSwitchMethod(gsonString);
				ForgotLogin FL = gson.fromJson(hejhej35, ForgotLogin.class);


				if (FL.getAnswer().equals("correct")){
					JOptionPane.showMessageDialog(null, "\nYour username is: "+FL.getEmail()+"\nYour password is: "+FL.getPassword()
							, "Message",JOptionPane.PLAIN_MESSAGE);
				}
				else if(FL.getAnswer().equals("notCorrect")){
					JOptionPane.showMessageDialog(null, "\nIt did not work!...."
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
			if (e.getSource() == screen.getMainMenu().getBtnNotelist()){
				screen.show(Screen.NOTELIST);
			}
			if (e.getSource() == screen.getMainMenu().getBtnEventlist()){
				screen.show(Screen.EVENTLIST);
			}
			if (e.getSource() == screen.getMainMenu().getBtnCalendarList()){
				screen.show(Screen.CALENDARLIST);
			}
			if (e.getSource() == screen.getMainMenu().getBtn_CreateEvent()){
				screen.show(Screen.ADDEVENT);
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
			if (e.getSource() == screen.getAddEventGUI().getBtnSubmit()){
				 
			
		
				String description = screen.getAddEventGUI().getTextField_Description().getText();
				String start = screen.getAddEventGUI().getTextField_Start().getText();
				String location = screen.getAddEventGUI().getTextField_Location().getText();
				String end = screen.getAddEventGUI().getTextField_End().getText();
				String title = screen.getAddEventGUI().getTextField_Title().getText();
				String type = screen.getAddEventGUI().getTextField_Type().getText();
				String eventID = screen.getAddEventGUI().getTextField_EventID().getText();
				String activityID = screen.getAddEventGUI().getTextField_ActivityID().getText();
				String calendarName =  screen.getAddEventGUI().getTextField_CalendarName().getText();
				
				Object startHour = screen.getAddEventGUI().getComboBox_StartHour().getSelectedItem();
				Object startMinutes = screen.getAddEventGUI().getComboBox_StartMinutes().getSelectedItem();
				
				String startTime = startHour.toString()+ ":"+ startMinutes.toString();
				System.out.println("startTime: "+startTime);
				
				Object endHour = screen.getAddEventGUI().getComboBox_StartHour().getSelectedItem();
				Object endMinutes = screen.getAddEventGUI().getComboBox_StartMinutes().getSelectedItem();
				
				String endTime = endHour.toString()+ ":"+ endMinutes.toString();
				System.out.println("endTime");
				
				System.out.println("fafaf "+startHour);
				
//				  (cmbYear.getSelectedItem() != null){
//		                String b = cmbYear.getSelectedItem().toString();
//		                d.setCurrentYear(Integer.parseInt(b));
//		                refreshCalendar(d.getWeekofYear(), d.getCurrentYear(), d.getJsonString());
//		                
		                
				
				
				CreateEvent CE = new CreateEvent("createEvent", 0,activityID , eventID, type, title, description, start, end, location, calendarName );
							
				Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(CE);
				
				try {
					Object hejhej = GS.GiantSwitchMethod(gsonString);
					
					JOptionPane.showMessageDialog(null, hejhej
							, "Return message",JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
							
				
//
////				if (Location.equals("")|| Createdby.equals("")|| start.equals("")|| end.equals("")|| name.equals("")|| text.equals(""))
////				{
////					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
////							, "Error message",JOptionPane.PLAIN_MESSAGE);
////				}
////				else
////				{
			
	
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
			if (e.getSource() == screen.getAddUser().getBtnSubmit()){
				
				
				String Email = screen.getAddUser().getTextField_Email().getText();
				String Password = screen.getAddUser().getTextField_Password().getText();
				String CPR = screen.getAddUser().getTextField_CPR().getText();
				int Active = 1;
				String created = "2014-11-11 11:00:00";
				
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
					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields."
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					EstablishUser EU = new EstablishUser("establishUser", Email , Active, created, adMinOrUserValue, Password, CPR );
					
					Gson gson = new GsonBuilder().create();
					String gsonString = gson.toJson(EU);
					
					try {
						Object hejhej22 = GS.GiantSwitchMethod(gsonString);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}

			}
		}
	}
	private class UserInfoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getUserInfo().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getUserInfo().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getUserInfo().getBtnSubmit()){
				
			}
		}
	}
	
	private class NoteListActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getNoteList().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getNoteList().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getNoteList().getBtnAdd()){
				screen.show(Screen.ADDNOTE);
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
			if (e.getSource() == screen.getUserList().getBtnDelete()){
				
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
		}
	}
	
	private class AddNoteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getAddNote().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getAddNote().getBtnLogout()){
				screen.show(Screen.LOGIN);
			}
			if (e.getSource() == screen.getAddNote().getBtnAddNote()){
				
				String text = screen.getAddNote().getTextField_text().getText();
				String createdBy = screen.getAddNote().getTextField_Createdby().getText();
				int noteID = screen.getAddNote().getTextField_NoteID().getX();
				int eventID = screen.getAddNote().getTextField_EventID().getX();
				String dateTime = screen.getAddNote().getTextField_Date().getText();
//				int isActive = screen.getAddNote().getTextField_Active().getX();
				n.CreateNote(noteID, text, dateTime, createdBy, eventID);
				
				if (text.equals("")|| createdBy.equals(""))
				{
					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
//				else
//				{
//				QueryBuilder qb = new QueryBuilder();
//				
//				String[] kolonner = { "text", "createdby"};
//				String[] Values = { text, createdby};
//				
//				try {
//					qb.insertInto("notes", kolonner ).values(Values).ExecuteQuery();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
					
//				}
				
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
			if (e.getSource() == screen.getDeleteCalendar().getBtnDelete()){
				try {
				String userName = screen.getDeleteCalendar().getTextField_Username().getText();
				String calendarName = screen.getDeleteCalendar().getTextField_CalendarName().getText();

				DC.setUserName(userName);
				DC.setCalendarName(calendarName);
				
				Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(DC);
				String DeleteCalendar = (String)GS.GiantSwitchMethod(gsonString);
				DC = gson.fromJson(DeleteCalendar, DeleteCalendar.class);

				System.out.println(DC.getAnswer());
				
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
						DC = gson.fromJson(CreateCalendar, DeleteCalendar.class);
						
						JOptionPane.showMessageDialog(null, "It worked!"
								, "Return message",JOptionPane.PLAIN_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
										
				}
				
			}
		}

	}
	
}
