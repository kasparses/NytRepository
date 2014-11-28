package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

public class BlockUser extends JPanel {
	private final JLabel lblBlockUser = new JLabel("Block User");
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JButton btnLogOut = new JButton("Log Out");
	private final JButton btnNoteList = new JButton("Note List");
	private final JButton btnUserList = new JButton("User List");
	private final JButton btnEventList = new JButton("Event List");
	private final JButton btnCalendarList = new JButton("Calendar List");
	private final JButton btnUserInfo = new JButton("User Info");
	private final JTextField textField_Username = new JTextField();
	private final JLabel lblEnterTheUsers = new JLabel("Enter the users username:");
	private final JButton btnBlockUser = new JButton("Block User");
	private final JLabel label = new JLabel("");
	private final JLabel label_1 = new JLabel("");

	/**
	 * Create the panel.
	 */
	public BlockUser() {
		textField_Username.setBounds(718, 221, 305, 30);
		textField_Username.setColumns(10);
		setLayout(null);
		lblBlockUser.setBounds(480, 11, 428, 90);
		lblBlockUser.setForeground(Color.WHITE);
		lblBlockUser.setFont(new Font("Arial", Font.BOLD, 78));
		
		add(lblBlockUser);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBounds(49, 508, 225, 45);
		
		add(btnMainMenu);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(49, 583, 225, 45);
		
		add(btnLogOut);
		btnNoteList.setForeground(Color.WHITE);
		btnNoteList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNoteList.setContentAreaFilled(false);
		btnNoteList.setBounds(49, 131, 225, 45);
		
		add(btnNoteList);
		btnUserList.setForeground(Color.WHITE);
		btnUserList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserList.setContentAreaFilled(false);
		btnUserList.setBounds(49, 206, 225, 45);
		
		add(btnUserList);
		btnEventList.setForeground(Color.WHITE);
		btnEventList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEventList.setContentAreaFilled(false);
		btnEventList.setBounds(49, 281, 225, 45);
		
		add(btnEventList);
		btnCalendarList.setForeground(Color.WHITE);
		btnCalendarList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCalendarList.setContentAreaFilled(false);
		btnCalendarList.setBounds(49, 356, 234, 45);
		
		add(btnCalendarList);
		btnUserInfo.setForeground(Color.WHITE);
		btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserInfo.setContentAreaFilled(false);
		btnUserInfo.setBounds(51, 431, 225, 45);
		
		add(btnUserInfo);
		
		add(textField_Username);
		lblEnterTheUsers.setForeground(Color.WHITE);
		lblEnterTheUsers.setFont(new Font("Arial", Font.BOLD, 26));
		lblEnterTheUsers.setBounds(373, 221, 326, 30);
		
		add(lblEnterTheUsers);
		btnBlockUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBlockUser.setForeground(Color.WHITE);
		btnBlockUser.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBlockUser.setContentAreaFilled(false);
		btnBlockUser.setBounds(558, 357, 250, 59);
		
		add(btnBlockUser);
		label.setIcon(new ImageIcon(BlockUser.class.getResource("/Images/CBSLogo3.png")));
		label.setBounds(0, 709, 250, 59);
		
		add(label);
		label_1.setIcon(new ImageIcon(BlockUser.class.getResource("/Images/MetalBackground.jpg")));
		label_1.setBounds(0, 0, 1366, 768);
		
		add(label_1);

	}
	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnCalendarList.addActionListener(l);
		btnEventList.addActionListener(l);
		btnNoteList.addActionListener(l);
		btnUserList.addActionListener(l);
		btnUserInfo.addActionListener(l);
		btnBlockUser.addActionListener(l);
}
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}
	public JButton getBtnLogOut() {
		return btnLogOut;
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
	public JButton getBtnUserInfo() {
		return btnUserInfo;
	}
	public JTextField getTextField_Username() {
		return textField_Username;
	}
	public JButton getBtnBlockUser() {
		return btnBlockUser;
	}
	
}