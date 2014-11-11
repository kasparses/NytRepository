package GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import model.QueryBuild.QueryBuilder;
import GUI.UserInformation;
import GUI.AuthUser;

import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.RunElement;

import model.QueryBuild.*;
import model.user.AuthenticateUser;
import model.user.User;
import GUI.Screen;
import model.note.*;

public class GUILogic {
	private Screen screen;
	private User u2;
	private String u3;
	private model.note.NoteModel nm;
	private boolean u;
	private boolean full = false;
	
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
			u3=a.authenticate(email, password);
			
			if (e.getSource() == screen.getLogin().getBtnLogIn()){
				System.out.println(u3);
				if(u3.equals("notCorrect")){
					JOptionPane.showMessageDialog(null, "\nPlease enter a valid username & password."
							, "Error message",JOptionPane.PLAIN_MESSAGE);
			}

			if	(u3.equals("correct"))
					{
						screen.show(Screen.MAINMENU);
					}
				
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
					String email = null;
					String password = null;
					JOptionPane.showMessageDialog(null, "\nYour username is: "+a.authenticate(email, password)
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
				int Location = screen.getAddEventGUI().getTextField_Location().getX();
				int Createdby = screen.getAddEventGUI().getTextField_Createdby().getX();
				String start = screen.getAddEventGUI().getTextField_Start().getText();
				String end = screen.getAddEventGUI().getTextField_End().getText();
				String name = screen.getAddEventGUI().getTextField_Name().getText();
				String text = screen.getAddEventGUI().getTextField_Text().getText();
				int type = screen.getAddEventGUI().getTextField_Type().getX();
				int eventID = screen.getAddEventGUI().getTextField_EventID().getX();


//				if (Location.equals("")|| Createdby.equals("")|| start.equals("")|| end.equals("")|| name.equals("")|| text.equals(""))
//				{
//					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
//							, "Error message",JOptionPane.PLAIN_MESSAGE);
//				}
//				else
//				{
				QueryBuilder qb = new QueryBuilder();
				
				String loc = String.valueOf(Location);
				String cre = String.valueOf(Createdby);
				String typ = String.valueOf(type);
				String eve = String.valueOf(eventID);

				
				String[] kolonner = { "eventID", "type", "location", "createdby", "start", "end", "name", "text"};
				String[] Values = { eve, loc, cre, typ, start, end, name, text};
				try {
					qb.insertInto("events", kolonner ).values(Values).ExecuteQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}	
			}
		}
//	}
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
				String Type = screen.getAddUser().getTextField_Type().getText();
				String Password = screen.getAddUser().getTextField_Password().getText();
				
				if (Email.equals("")|| Type.equals("")|| Password.equals(""))
				{
					JOptionPane.showMessageDialog(null, "\nPlease fill out all the fields"
							, "Error message",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
				QueryBuilder qb = new QueryBuilder();
				
				String[] kolonner = { "email", "password"};
				String[] Values = { Email, Password};
//				String[] kolonner2 = { "types"};
//				String[] Values2 = { Type};
				try {
					qb.insertInto("user", kolonner ).values(Values).ExecuteQuery();
//					qb.insertInto("roles", kolonner ).values(Values).ExecuteQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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
	
}
