package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;

import java.awt.Cursor;

import javax.swing.SwingConstants;

import java.awt.Dimension;

import javax.swing.JPasswordField;

public class Login extends JPanel {
	private final JLabel lblWelcome = new JLabel("Welcome Admin");
	private final JLabel lblUsername = new JLabel("Username");
	private final JLabel lblPassword = new JLabel("Password");
	private final JTextField textFieldUsername = new JTextField();
	private final JLabel lblCBSlogo = new JLabel("");
	private final JLabel lblBackground = new JLabel("Forgot Login?");
	private final JPasswordField textFieldPassword = new JPasswordField();
	private final JButton btnLogIn = new JButton("Log In");
	private final JButton btnForgotLogin = new JButton("Forgot Login?");
	


	/**
	 * Create the panel.
	 */
	public Login() {
		setSize(new Dimension(1366, 768));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(105, 105, 105));
		setLayout(null);
		lblWelcome.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 78));
		lblWelcome.setBounds(381, 90, 603, 90);
		
		add(lblWelcome);
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Arial", Font.BOLD, 26));
		lblUsername.setBounds(499, 335, 125, 30);
		
		add(lblUsername);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 26));
		lblPassword.setBounds(499, 378, 123, 30);
		
		add(lblPassword);
		textFieldUsername.setOpaque(false);
		textFieldUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsername.setForeground(Color.BLACK);
		textFieldUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldUsername.setColumns(10);
		textFieldUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255)));
		textFieldUsername.setBounds(705, 334, 164, 37);
		
		add(textFieldUsername);
		lblCBSlogo.setIcon(new ImageIcon(Login.class.getResource("/Images/CBSLogo3.png")));
		lblCBSlogo.setBounds(0, 709, 250, 59);
		
		add(lblCBSlogo);
		setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldPassword.setOpaque(false);
		textFieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255)));
		textFieldPassword.setBounds(705, 372, 164, 37);
		
		add(textFieldPassword);
		btnLogIn.setContentAreaFilled(false);
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogIn.setBounds(552, 492, 262, 59);
		
		add(btnLogIn);
		btnForgotLogin.setForeground(Color.WHITE);
		btnForgotLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnForgotLogin.setContentAreaFilled(false);
		btnForgotLogin.setBounds(552, 595, 262, 59);
		
		add(btnForgotLogin);
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/Images/MetalBackground.jpg")));
		lblBackground.setSize(new Dimension(1366, 768));
		lblBackground.setBounds(0, 0, 1366, 768);
		
		add(lblBackground);

	}

	public JButton getBtnLogIn() {
		return btnLogIn;
	}

	public JButton getBtnForgotLogIn() {
		return btnForgotLogin;
	}
	public void addActionListener(ActionListener l) {
		btnLogIn.addActionListener(l);
		btnForgotLogin.addActionListener(l);
}

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public JPasswordField getTextFieldPassword() {
		return textFieldPassword;
	}
	
	}