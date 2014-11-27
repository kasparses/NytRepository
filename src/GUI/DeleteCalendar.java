package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class DeleteCalendar extends JPanel {
	private final JLabel lblDeleteCalendar = new JLabel("Delete Calendar");
	private final JLabel lblEnterYourUsername = new JLabel("Enter your username:");
	private final JTextField textField_Username = new JTextField();
	private final JLabel lblEnterThe = new JLabel("Enter the calendar name:");
	private final JTextField textField_CalendarName = new JTextField();
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
	public DeleteCalendar() {
		textField_CalendarName.setBounds(609, 280, 271, 25);
		textField_CalendarName.setColumns(10);
		textField_Username.setBounds(609, 218, 271, 25);
		textField_Username.setColumns(10);
		setLayout(null);
		lblDeleteCalendar.setForeground(Color.WHITE);
		lblDeleteCalendar.setFont(new Font("Tahoma", Font.BOLD, 78));
		lblDeleteCalendar.setBounds(370, 11, 641, 95);
		
		add(lblDeleteCalendar);
		lblEnterYourUsername.setForeground(Color.WHITE);
		lblEnterYourUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterYourUsername.setBounds(338, 218, 243, 25);
		
		add(lblEnterYourUsername);
		
		add(textField_Username);
		lblEnterThe.setForeground(Color.WHITE);
		lblEnterThe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterThe.setBounds(338, 280, 263, 25);
		
		add(lblEnterThe);
		
		add(textField_CalendarName);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnDelete.setBounds(566, 435, 233, 50);
		
		add(btnDelete);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBounds(46, 506, 225, 45);
		
		add(btnMainMenu);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(46, 581, 225, 45);
		
		add(btnLogOut);
		btnNoteList.setForeground(Color.WHITE);
		btnNoteList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNoteList.setContentAreaFilled(false);
		btnNoteList.setBounds(46, 131, 225, 45);
		
		add(btnNoteList);
		btnUserList.setForeground(Color.WHITE);
		btnUserList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserList.setContentAreaFilled(false);
		btnUserList.setBounds(46, 206, 225, 45);
		
		add(btnUserList);
		btnEventList.setForeground(Color.WHITE);
		btnEventList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEventList.setContentAreaFilled(false);
		btnEventList.setBounds(46, 281, 225, 45);
		
		add(btnEventList);
		btnCalendarList.setForeground(Color.WHITE);
		btnCalendarList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCalendarList.setContentAreaFilled(false);
		btnCalendarList.setBounds(46, 356, 234, 45);
		
		add(btnCalendarList);
		label_1.setIcon(new ImageIcon(DeleteCalendar.class.getResource("/Images/CBSLogo3.png")));
		label_1.setBounds(0, 709, 250, 59);
		
		add(label_1);
		btnUserInfo.setForeground(Color.WHITE);
		btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserInfo.setContentAreaFilled(false);
		btnUserInfo.setBounds(46, 435, 225, 45);
		
		add(btnUserInfo);
		label.setIcon(new ImageIcon(DeleteCalendar.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);

	}
	
	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnCalendarList.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnDelete.addActionListener(l);
		btnEventList.addActionListener(l);
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

	public JButton getBtnEventList() {
		return btnEventList;
	}

	public JTextField getTextField_Username() {
		return textField_Username;
	}

	public JTextField getTextField_CalendarName() {
		return textField_CalendarName;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnCalendarList() {
		return btnCalendarList;
	}

	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	
}