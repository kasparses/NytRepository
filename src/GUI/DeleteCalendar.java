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
	private final JButton btnCalendarList = new JButton("Calendar List");
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JLabel label = new JLabel("");
	private final JButton btnLogOut = new JButton("Log Out");

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
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(566, 435, 233, 50);
		
		add(btnDelete);
		btnCalendarList.setForeground(Color.WHITE);
		btnCalendarList.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCalendarList.setContentAreaFilled(false);
		btnCalendarList.setBounds(566, 520, 233, 50);
		
		add(btnCalendarList);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBounds(566, 604, 233, 50);
		
		add(btnMainMenu);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(566, 682, 233, 50);
		
		add(btnLogOut);
		label.setIcon(new ImageIcon(DeleteCalendar.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);

	}
	
	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnCalendarList.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnDelete.addActionListener(l);
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