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
	private final JButton btnCalendarList = new JButton("Calendar List");
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JButton btnLogOut = new JButton("Log Out");
	private final JLabel label = new JLabel("");

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
		btnCreateCalendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreateCalendar.setBounds(555, 444, 256, 60);
		
		add(btnCreateCalendar);
		btnCalendarList.setContentAreaFilled(false);
		btnCalendarList.setForeground(Color.WHITE);
		btnCalendarList.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCalendarList.setBounds(555, 527, 256, 60);
		
		add(btnCalendarList);
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMainMenu.setBounds(555, 605, 256, 60);
		
		add(btnMainMenu);
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogOut.setBounds(555, 685, 256, 60);
		
		add(btnLogOut);
		
		ButtonGroup group = new ButtonGroup();
		group.add(getRdbtnPrivateCalendar());
		group.add(getRdbtnPublicCalendar());
		label.setIcon(new ImageIcon(CreateCalendar.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);
		

	}
	
	public void addActionListener(ActionListener l) {
		btnCreateCalendar.addActionListener(l);
		btnCalendarList.addActionListener(l);
		btnLogOut.addActionListener(l);
		btnMainMenu.addActionListener(l);
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
