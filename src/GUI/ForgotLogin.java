package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ForgotLogin extends JPanel {
	private final JLabel lblForgotLogin = new JLabel("Forgot Login");
	private final JLabel lblEnterYourSocial = new JLabel("Enter your social secruity number:");
	private final JTextField textField = new JTextField();
	private final JButton btnGetLogin = new JButton("Get Login");
	private final JLabel label = new JLabel("");
	private final JButton btnMainMenu = new JButton("Main Menu");

	/**
	 * Create the panel.
	 */
	public ForgotLogin() {
		textField.setBounds(700, 370, 289, 25);
		textField.setColumns(10);
		setLayout(null);
		lblForgotLogin.setForeground(Color.WHITE);
		lblForgotLogin.setFont(new Font("Tahoma", Font.BOLD, 68));
		lblForgotLogin.setBounds(466, 62, 433, 82);
		
		add(lblForgotLogin);
		lblEnterYourSocial.setForeground(Color.WHITE);
		lblEnterYourSocial.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterYourSocial.setBounds(319, 370, 348, 25);
		
		add(lblEnterYourSocial);
		
		add(textField);
		btnGetLogin.setContentAreaFilled(false);
		btnGetLogin.setForeground(Color.WHITE);
		btnGetLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGetLogin.setBounds(642, 475, 186, 57);
		
		add(btnGetLogin);
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMainMenu.setBounds(642, 570, 186, 57);
		
		add(btnMainMenu);
		label.setIcon(new ImageIcon(ForgotLogin.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);

	}
	public void addActionListener(ActionListener l) {
		btnGetLogin.addActionListener(l);
		btnMainMenu.addActionListener(l);
		
	}
	public JTextField getTextField() {
		return textField;
	}
	public JButton getBtnGetLogin() {
		return btnGetLogin;
	}
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}
	
}