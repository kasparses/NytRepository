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
	private final JTextField textField_CPR = new JTextField();
	private final JButton btnGetLogin = new JButton("Get Login");
	private final JLabel label = new JLabel("");
	private final JButton btnLogin = new JButton("Login");

	/**
	 * Create the panel.
	 */
	public ForgotLogin() {
		textField_CPR.setBounds(700, 370, 289, 25);
		textField_CPR.setColumns(10);
		setLayout(null);
		lblForgotLogin.setForeground(Color.WHITE);
		lblForgotLogin.setFont(new Font("Tahoma", Font.BOLD, 68));
		lblForgotLogin.setBounds(466, 62, 433, 82);
		
		add(lblForgotLogin);
		lblEnterYourSocial.setForeground(Color.WHITE);
		lblEnterYourSocial.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterYourSocial.setBounds(319, 370, 348, 25);
		
		add(lblEnterYourSocial);
		
		add(textField_CPR);
		btnGetLogin.setContentAreaFilled(false);
		btnGetLogin.setForeground(Color.WHITE);
		btnGetLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGetLogin.setBounds(642, 475, 186, 57);
		
		add(btnGetLogin);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(642, 570, 186, 57);
		
		add(btnLogin);
		label.setIcon(new ImageIcon(ForgotLogin.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);

	}
	public void addActionListener(ActionListener l) {
		btnGetLogin.addActionListener(l);
		btnLogin.addActionListener(l);
		
	}
	public JTextField getTextField_CPR() {
		return textField_CPR;
	}
	public JButton getBtnGetLogin() {
		return btnGetLogin;
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
	
}
