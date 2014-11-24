package GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import ClientWorker.GiantSwitch;
import model.QueryBuild.QueryBuilder;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import GUI.Screen;
import JsonClasses.CreateEvent;
import JsonClasses.EstablishUser;
import JsonClasses.Login;
import JsonClasses.LoginAnswer;


public class GUILogic {
	private Screen screen;
	private String u3;
	Login L = new Login();
	Gson gson = new GsonBuilder().create();


	
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
		screen.getAddUser().addActionListener(new AddUserActionListener());
		screen.getAddNote().addActionListener(new AddNoteActionListener());
		screen.getForgotLogin().addActionListener(new ForgotActionListener());
		screen.getCalendarList().addActionListener(new CalendarListActionListener());

		
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
				
				L.setEmail(email);
				L.setPassword(password);

				String JsonString=tcp.bla(L);

				LoginAnswer LA = gson.fromJson(JsonString, LoginAnswer.class);  

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
			if (e.getSource() == screen.getForgotLogin().getBtnMainMenu()){
				screen.show(Screen.MAINMENU);
			}
			if (e.getSource() == screen.getForgotLogin().getBtnGetLogin()){
				
				String u4;
				
				String CPR = screen.getForgotLogin().getTextField().getText();
				
				u4 = a.getLogin(CPR);
				
				if (u4.equals("correct")){
					String cpr = null;
					JOptionPane.showMessageDialog(null, "\nYour username is: "+a.getLogin(cpr)
							, "Message",JOptionPane.PLAIN_MESSAGE);
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
				
				CreateEvent CE = new CreateEvent("createEvent", 0,activityID , eventID, type, title, description, start, end, location );
							
				Gson gson = new GsonBuilder().create();
				String gsonString = gson.toJson(CE);
				
				try {
					Object hejhej = GS.GiantSwitchMethod(gsonString);
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
				
//				GS.Determine("")
			}
			if (e.getSource() == screen.getCalendarList().getBtnDelete()){
				
				GS.Determine("deleteCalendar");
			}
		}
	}
	
}
