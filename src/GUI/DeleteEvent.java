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
	private final JLabel lbl_Username = new JLabel("Enter your username:");
	private final JLabel lbl_title = new JLabel("Enter the events title:");
	private final JTextField textField_Username = new JTextField();
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

	/**
	 * Create the panel.
	 */
	public DeleteEvent() {
		setLayout(null);
		lblDeleteEvent.setForeground(Color.WHITE);
		lblDeleteEvent.setFont(new Font("Tahoma", Font.BOLD, 78));
		lblDeleteEvent.setBounds(434, 11, 497, 95);
		
		add(lblDeleteEvent);
		lbl_Username.setForeground(Color.WHITE);
		lbl_Username.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_Username.setBounds(406, 208, 243, 25);
		
		add(lbl_Username);
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_title.setBounds(406, 270, 263, 25);
		
		add(lbl_title);
		textField_Username.setColumns(10);
		textField_Username.setBounds(677, 208, 271, 25);
		
		add(textField_Username);
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
		btnMainMenu.setBounds(49, 427, 225, 45);
		
		add(btnMainMenu);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(49, 502, 225, 45);
		
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

	public JTextField getTextField_Username() {
		return textField_Username;
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
