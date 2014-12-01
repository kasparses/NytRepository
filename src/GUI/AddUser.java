package GUI;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

public class AddUser extends JPanel {
	private JTextField textField_Email;
	private JTextField textField_Password;
	private JLabel lblCBSlogo;
	private JLabel lblUserInfo;
	private JLabel lblCpr;
	private JTextField textField_CPR;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnUser;
	private JButton btnCreateUser;
	private JButton btnSubmit;
	private JLabel label;
	private JButton btnMainMenu;
	private JButton btnLogout;
	private JButton btnNoteList;
	private JButton btnUserList;
	private JButton btnEventList;
	private JButton btnCalendarList;
	private JButton btnUserInfo;

	/**
	 * Create the panel.
	 */
	public AddUser() {
		setPreferredSize(new Dimension(1366, 768));
		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		lblCBSlogo = new JLabel("");
		lblCBSlogo.setIcon(new ImageIcon(UserInfo.class.getResource("/Images/CBSLogo3.png")));
		lblCBSlogo.setBounds(10, 698, 250, 59);
		add(lblCBSlogo);

		textField_Email = new JTextField();
		textField_Email.setForeground(new Color(105, 105, 105));
		textField_Email.setName("");
		textField_Email.setBounds(755, 213, 174, 34);
		add(textField_Email);
		textField_Email.setColumns(10);

		JLabel lblUserID = new JLabel("Email");
		lblUserID.setForeground(new Color(255, 255, 255));
		lblUserID.setFont(new Font("Arial", Font.BOLD, 20));
		lblUserID.setBounds(483, 211, 104, 30);
		add(lblUserID);

		JLabel lblEmail = new JLabel("Type");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmail.setBounds(483, 257, 47, 24);
		add(lblEmail);

		textField_Password = new JTextField();
		textField_Password.setForeground(new Color(105, 105, 105));
		textField_Password.setColumns(10);
		textField_Password.setBounds(755, 305, 174, 34);
		add(textField_Password);

		JLabel lblTeam = new JLabel("Password");
		lblTeam.setFont(new Font("Arial", Font.BOLD, 20));
		lblTeam.setForeground(new Color(255, 255, 255));
		lblTeam.setBounds(483, 303, 127, 30);
		add(lblTeam);
				
				lblUserInfo = new JLabel("Create User");
				lblUserInfo.setForeground(Color.WHITE);
				lblUserInfo.setFont(new Font("Arial", Font.BOLD, 78));
				lblUserInfo.setBounds(469, 11, 446, 90);
				add(lblUserInfo);
				
				lblCpr = new JLabel("CPR");
				lblCpr.setForeground(Color.WHITE);
				lblCpr.setFont(new Font("Arial", Font.BOLD, 20));
				lblCpr.setBounds(483, 348, 127, 30);
				add(lblCpr);
				
				textField_CPR = new JTextField();
				textField_CPR.setForeground(SystemColor.controlDkShadow);
				textField_CPR.setColumns(10);
				textField_CPR.setBounds(755, 350, 174, 34);
				add(textField_CPR);
				
				rdbtnUser = new JRadioButton("User");
				rdbtnUser.setContentAreaFilled(false);
				rdbtnUser.setBounds(783, 261, 109, 23);
				add(rdbtnUser);
				
				rdbtnAdmin = new JRadioButton("Admin");
				rdbtnAdmin.setContentAreaFilled(false);
				rdbtnAdmin.setBounds(622, 261, 109, 23);
				add(rdbtnAdmin);
				
				ButtonGroup group = new ButtonGroup();
				group.add(getRdbtnAdmin());
				group.add(getRdbtnUser());
				
				btnCreateUser = new JButton("Create User");
				btnCreateUser.setForeground(Color.WHITE);
				btnCreateUser.setFont(new Font("Tahoma", Font.BOLD, 30));
				btnCreateUser.setContentAreaFilled(false);
				btnCreateUser.setBounds(558, 415, 250, 50);
				add(btnCreateUser);
				
				btnMainMenu = new JButton("Main Menu");
				btnMainMenu.setForeground(Color.WHITE);
				btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
				btnMainMenu.setContentAreaFilled(false);
				btnMainMenu.setBounds(47, 513, 225, 45);
				add(btnMainMenu);
				
				btnLogout = new JButton("Log Out");
				btnLogout.setForeground(Color.WHITE);
				btnLogout.setFont(new Font("Tahoma", Font.BOLD, 30));
				btnLogout.setContentAreaFilled(false);
				btnLogout.setBounds(47, 588, 225, 45);
				add(btnLogout);
				
				btnNoteList = new JButton("Note List");
				btnNoteList.setForeground(Color.WHITE);
				btnNoteList.setFont(new Font("Tahoma", Font.BOLD, 30));
				btnNoteList.setContentAreaFilled(false);
				btnNoteList.setBounds(47, 138, 225, 45);
				add(btnNoteList);
				
				btnUserList = new JButton("User List");
				btnUserList.setForeground(Color.WHITE);
				btnUserList.setFont(new Font("Tahoma", Font.BOLD, 30));
				btnUserList.setContentAreaFilled(false);
				btnUserList.setBounds(47, 213, 225, 45);
				add(btnUserList);
				
				btnEventList = new JButton("Event List");
				btnEventList.setForeground(Color.WHITE);
				btnEventList.setFont(new Font("Tahoma", Font.BOLD, 30));
				btnEventList.setContentAreaFilled(false);
				btnEventList.setBounds(47, 288, 225, 45);
				add(btnEventList);
				
				btnCalendarList = new JButton("Calendar List");
				btnCalendarList.setForeground(Color.WHITE);
				btnCalendarList.setFont(new Font("Tahoma", Font.BOLD, 30));
				btnCalendarList.setContentAreaFilled(false);
				btnCalendarList.setBounds(47, 363, 234, 45);
				add(btnCalendarList);
				
				btnUserInfo = new JButton("User Info");
				btnUserInfo.setForeground(Color.WHITE);
				btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
				btnUserInfo.setContentAreaFilled(false);
				btnUserInfo.setBounds(47, 437, 225, 45);
				add(btnUserInfo);
				
				label = new JLabel("");
				label.setIcon(new ImageIcon(AddUser.class.getResource("/Images/MetalBackground.jpg")));
				label.setBounds(0, 0, 1366, 770);
				add(label);
		
		

	}
	
	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnCalendarList.addActionListener(l);
		btnEventList.addActionListener(l);
		btnNoteList.addActionListener(l);
		btnUserList.addActionListener(l);
		btnCreateUser.addActionListener(l);
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


	public JButton getBtnCalendarList() {
		return btnCalendarList;
	}

	public JTextField getTextField_Email() {
		return textField_Email;
	}

	public JRadioButton getRdbtnAdmin() {
		return rdbtnAdmin;
	}

	public JRadioButton getRdbtnUser() {
		return rdbtnUser;
	}

	public JTextField getTextField_Password() {
		return textField_Password;
	}
	
	public JTextField getTextField_CPR() {
		return textField_CPR;
	}

	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}
	
	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnCreateUser() {
		return btnCreateUser;
	}

	

	
}
