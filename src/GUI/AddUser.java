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
import java.awt.event.ActionEvent;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class AddUser extends JPanel {
	private JTextField textField_Email;
	private JTextField textField_Password;
	private JButton btnLogout;
	private JLabel lblCBSlogo;
	private JButton btnMainMenu;
	private JLabel lblUserInfo;
	private JLabel lblCpr;
	private JTextField textField_CPR;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnUser;
	private JButton btnCreateUser;

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
		

		btnLogout = new JButton("Log out");
		btnLogout.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(630, 506, 117, 43);
		add(btnLogout);

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

		
				
				btnMainMenu = new JButton("Main menu");
				btnMainMenu.setForeground(Color.WHITE);
				btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
				btnMainMenu.setContentAreaFilled(false);
				btnMainMenu.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
				btnMainMenu.setBounds(609, 467, 164, 44);
				add(btnMainMenu);
				
				lblUserInfo = new JLabel("Create user");
				lblUserInfo.setForeground(Color.WHITE);
				lblUserInfo.setFont(new Font("Arial", Font.BOLD, 78));
				lblUserInfo.setBounds(451, 90, 464, 90);
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
				rdbtnUser.setBounds(783, 261, 109, 23);
				add(rdbtnUser);
				
				rdbtnAdmin = new JRadioButton("Admin");
				rdbtnAdmin.setBounds(622, 261, 109, 23);
				add(rdbtnAdmin);
				
				ButtonGroup group = new ButtonGroup();
				group.add(getRdbtnAdmin());
				group.add(getRdbtnUser());
				
				btnCreateUser = new JButton("Create User");
				btnCreateUser.setForeground(Color.WHITE);
				btnCreateUser.setFont(new Font("Tahoma", Font.BOLD, 30));
				btnCreateUser.setContentAreaFilled(false);
				btnCreateUser.setBounds(557, 415, 250, 50);
				add(btnCreateUser);
		
		

	}
	
	public void addActionListener(ActionListener l) {
		btnSubmit.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
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

	public JButton getBtnSubmit() {
		return btnSubmit;
	}
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}
	
	public JButton getBtnLogout() {
		return btnLogout;
	}
}
