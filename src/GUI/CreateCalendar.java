package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CreateCalendar extends JPanel {
	private final JLabel lblCreateCalendar = new JLabel("Create Calendar");
	private final JLabel lblName = new JLabel("Name:");
	private final JTextField textField_Name = new JTextField();
	private final JRadioButton rdbtnPrivateCalendar = new JRadioButton("Private Calendar");
	private final JRadioButton rdbtnPublicCalendar = new JRadioButton("Public Calendar");
	private final JButton btnCreateCalendar = new JButton("Create Calendar");
	private final JLabel label = new JLabel("");
	private final JButton btnNoteList = new JButton("Note List");
	private final JButton btnUserList = new JButton("User List");
	private final JButton btnEventList = new JButton("Event List");
	private final JButton btnCalendarList = new JButton("Calendar List");
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JButton btnLogOut = new JButton("Log Out");
	private final JLabel label_1 = new JLabel("");
	private final JButton btnUserInfo = new JButton("User Info");

	/**
	 * Create the panel.
	 */
	public CreateCalendar() {
		textField_Name.setBounds(597, 215, 291, 30);
		textField_Name.setColumns(10);
		setLayout(null);
		lblCreateCalendar.setForeground(Color.WHITE);
		lblCreateCalendar.setFont(new Font("Tahoma", Font.BOLD, 78));
		lblCreateCalendar.setBounds(368, 11, 629, 95);
		
		add(lblCreateCalendar);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(493, 215, 94, 30);
		
		add(lblName);
		
		add(textField_Name);
		rdbtnPrivateCalendar.setContentAreaFilled(false);
		rdbtnPrivateCalendar.setForeground(Color.WHITE);
		rdbtnPrivateCalendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnPrivateCalendar.setBounds(597, 283, 193, 33);
		
		add(rdbtnPrivateCalendar);
		rdbtnPublicCalendar.setContentAreaFilled(false);
		rdbtnPublicCalendar.setForeground(Color.WHITE);
		rdbtnPublicCalendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnPublicCalendar.setBounds(597, 319, 193, 33);
		
		add(rdbtnPublicCalendar);
		btnCreateCalendar.setContentAreaFilled(false);
		btnCreateCalendar.setForeground(Color.WHITE);
		btnCreateCalendar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCreateCalendar.setBounds(533, 444, 299, 60);
		
		add(btnCreateCalendar);
		
		ButtonGroup group = new ButtonGroup();
		group.add(getRdbtnPrivateCalendar());
		group.add(getRdbtnPublicCalendar());
		btnNoteList.setForeground(Color.WHITE);
		btnNoteList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNoteList.setContentAreaFilled(false);
		btnNoteList.setBounds(45, 139, 225, 45);
		
		add(btnNoteList);
		btnUserList.setForeground(Color.WHITE);
		btnUserList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserList.setContentAreaFilled(false);
		btnUserList.setBounds(45, 214, 225, 45);
		
		add(btnUserList);
		btnEventList.setForeground(Color.WHITE);
		btnEventList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEventList.setContentAreaFilled(false);
		btnEventList.setBounds(45, 289, 225, 45);
		
		add(btnEventList);
		btnCalendarList.setForeground(Color.WHITE);
		btnCalendarList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCalendarList.setContentAreaFilled(false);
		btnCalendarList.setBounds(45, 364, 234, 45);
		
		add(btnCalendarList);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBounds(45, 515, 225, 45);
		
		add(btnMainMenu);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(45, 590, 225, 45);
		
		add(btnLogOut);
		label_1.setIcon(new ImageIcon(CreateCalendar.class.getResource("/Images/CBSLogo3.png")));
		label_1.setBounds(0, 709, 250, 59);
		
		add(label_1);
		btnUserInfo.setForeground(Color.WHITE);
		btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserInfo.setContentAreaFilled(false);
		btnUserInfo.setBounds(45, 444, 225, 45);
		
		add(btnUserInfo);
		label.setIcon(new ImageIcon(CreateCalendar.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);
		

	}
	
	public void addActionListener(ActionListener l) {
		btnCreateCalendar.addActionListener(l);
		btnCalendarList.addActionListener(l);
		btnLogOut.addActionListener(l);
		btnMainMenu.addActionListener(l);
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

	public JTextField getTextField_Name() {
		return textField_Name;
	}

	public JRadioButton getRdbtnPrivateCalendar() {
		return rdbtnPrivateCalendar;
	}

	public JRadioButton getRdbtnPublicCalendar() {
		return rdbtnPublicCalendar;
	}

	public JButton getBtnCreateCalendar() {
		return btnCreateCalendar;
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
