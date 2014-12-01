package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class DeleteEvent extends JPanel {
	private final JLabel lblDeleteEvent = new JLabel("Delete Event");
	private final JLabel lbl_EventID = new JLabel("Enter the event ID:");
	private final JLabel lbl_title = new JLabel("Enter the events title:");
	private final JTextField textField_EventID = new JTextField();
	private final JTextField textField_Title = new JTextField();
	private final JButton btnDelete = new JButton("Delete");
	private final JLabel label = new JLabel("");
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JButton btnLogOut = new JButton("Log Out");
	private final JButton btnNoteList = new JButton("Note List");
	private final JButton btnUserList = new JButton("User List");
	private final JButton btnEventList = new JButton("Event List");
	private final JButton btnCalendarList = new JButton("Calendar List");
	private final JLabel label_1 = new JLabel("");
	private final JButton btnUserInfo = new JButton("User Info");

	/**
	 * Create the panel.
	 */
	public DeleteEvent() {
		setLayout(null);
		lblDeleteEvent.setForeground(Color.WHITE);
		lblDeleteEvent.setFont(new Font("Tahoma", Font.BOLD, 78));
		lblDeleteEvent.setBounds(434, 11, 497, 95);
		
		add(lblDeleteEvent);
		lbl_EventID.setForeground(Color.WHITE);
		lbl_EventID.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_EventID.setBounds(406, 208, 243, 25);
		
		add(lbl_EventID);
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_title.setBounds(406, 270, 263, 25);
		
		add(lbl_title);
		textField_EventID.setColumns(10);
		textField_EventID.setBounds(677, 208, 271, 25);
		
		add(textField_EventID);
		textField_Title.setColumns(10);
		textField_Title.setBounds(677, 270, 271, 25);
		
		add(textField_Title);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBounds(566, 366, 233, 50);
		
		add(btnDelete);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBounds(49, 522, 225, 45);
		
		add(btnMainMenu);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(49, 603, 225, 45);
		
		add(btnLogOut);
		btnNoteList.setForeground(Color.WHITE);
		btnNoteList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNoteList.setContentAreaFilled(false);
		btnNoteList.setBounds(49, 127, 225, 45);
		
		add(btnNoteList);
		btnUserList.setForeground(Color.WHITE);
		btnUserList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserList.setContentAreaFilled(false);
		btnUserList.setBounds(49, 202, 225, 45);
		
		add(btnUserList);
		btnEventList.setForeground(Color.WHITE);
		btnEventList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEventList.setContentAreaFilled(false);
		btnEventList.setBounds(49, 277, 225, 45);
		
		add(btnEventList);
		btnCalendarList.setForeground(Color.WHITE);
		btnCalendarList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCalendarList.setContentAreaFilled(false);
		btnCalendarList.setBounds(49, 352, 234, 45);
		
		add(btnCalendarList);
		label_1.setIcon(new ImageIcon(DeleteEvent.class.getResource("/Images/CBSLogo3.png")));
		label_1.setBounds(0, 709, 250, 59);
		
		add(label_1);
		btnUserInfo.setForeground(Color.WHITE);
		btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserInfo.setContentAreaFilled(false);
		btnUserInfo.setBounds(49, 438, 225, 45);
		
		add(btnUserInfo);
		label.setIcon(new ImageIcon(DeleteEvent.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);

	}
	
	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnEventList.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnDelete.addActionListener(l);
		btnCalendarList.addActionListener(l);
		btnNoteList.addActionListener(l);
		btnUserList.addActionListener(l);
		btnUserInfo.addActionListener(l);

}
	
	

	public JButton getBtnUserInfo() {
		return btnUserInfo;
	}

	public JButton getBtnNoteList() {
		return btnNoteList;
	}

	public JButton getBtnUserList() {
		return btnUserList;
	}

	public JButton getBtnCalendarList() {
		return btnCalendarList;
	}

	public JTextField getTextField_EventID() {
		return textField_EventID;
	}

	public JTextField getTextField_Title() {
		return textField_Title;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnEventList() {
		return btnEventList;
	}

	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	

}
