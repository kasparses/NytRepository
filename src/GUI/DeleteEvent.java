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
	private final JButton btnEventList = new JButton("Event List");
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JButton btnLogOut = new JButton("Log Out");
	private final JLabel label = new JLabel("");

	/**
	 * Create the panel.
	 */
	public DeleteEvent() {
		setLayout(null);
		lblDeleteEvent.setForeground(Color.WHITE);
		lblDeleteEvent.setFont(new Font("Tahoma", Font.BOLD, 78));
		lblDeleteEvent.setBounds(362, 11, 641, 95);
		
		add(lblDeleteEvent);
		lbl_Username.setForeground(Color.WHITE);
		lbl_Username.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_Username.setBounds(250, 149, 243, 25);
		
		add(lbl_Username);
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_title.setBounds(250, 211, 263, 25);
		
		add(lbl_title);
		textField_Username.setColumns(10);
		textField_Username.setBounds(521, 149, 271, 25);
		
		add(textField_Username);
		textField_Title.setColumns(10);
		textField_Title.setBounds(521, 211, 271, 25);
		
		add(textField_Title);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBounds(478, 366, 233, 50);
		
		add(btnDelete);
		btnEventList.setForeground(Color.WHITE);
		btnEventList.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEventList.setContentAreaFilled(false);
		btnEventList.setBounds(478, 451, 233, 50);
		
		add(btnEventList);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBounds(478, 535, 233, 50);
		
		add(btnMainMenu);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(478, 613, 233, 50);
		
		add(btnLogOut);
		label.setIcon(new ImageIcon(DeleteEvent.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);

	}
	
	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnEventList.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnDelete.addActionListener(l);
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
