package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;

public class MainMenu extends JPanel {
	private JLabel label;
	private JLabel lblMainMenu;
	private JButton btnUserlist;
	private JLabel lblCBSlogo;
	private JButton btnEventlist;
	private final JButton btnNotelist = new JButton("Note List");
	private final JButton btnUserlist_1 = new JButton("User List");
	private JButton btnCalendarList;
	private JButton btnLogOut;
	private JButton btnUserInfo;
	

	
	public MainMenu() {
		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setForeground(Color.WHITE);
		lblMainMenu.setFont(new Font("Arial", Font.BOLD, 78));
		lblMainMenu.setBounds(481, 11, 404, 90);
		add(lblMainMenu);
		
		btnUserlist = new JButton("Userlist");
		btnUserlist.setContentAreaFilled(false);
		
		lblCBSlogo = new JLabel("");
		lblCBSlogo.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/CBSLogo3.png")));
		lblCBSlogo.setBounds(0, 709, 250, 59);
		add(lblCBSlogo);
		btnNotelist.setForeground(Color.WHITE);
		btnNotelist.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNotelist.setContentAreaFilled(false);
		btnNotelist.setBounds(558, 212, 250, 50);
		
		add(btnNotelist);
		btnUserlist_1.setForeground(Color.WHITE);
		btnUserlist_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserlist_1.setContentAreaFilled(false);
		btnUserlist_1.setBounds(558, 303, 250, 50);
		
		add(btnUserlist_1);
		
		btnEventlist = new JButton("Event List");
		btnEventlist.setForeground(Color.WHITE);
		btnEventlist.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEventlist.setContentAreaFilled(false);
		btnEventlist.setBounds(558, 393, 250, 50);
		add(btnEventlist);
		
		btnCalendarList = new JButton("Calendar List");
		btnCalendarList.setForeground(Color.WHITE);
		btnCalendarList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCalendarList.setContentAreaFilled(false);
		btnCalendarList.setBounds(558, 480, 250, 50);
		add(btnCalendarList);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(588, 654, 191, 50);
		add(btnLogOut);
		
		btnUserInfo = new JButton("User Info");
		btnUserInfo.setForeground(Color.WHITE);
		btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserInfo.setContentAreaFilled(false);
		btnUserInfo.setBounds(588, 567, 191, 50);
		add(btnUserInfo);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MainMenu.class.getResource("/Images/MetalBackground.jpg")));
		lblBackground.setBounds(0, 0, 1366, 768);
		add(lblBackground);

	}
	public void addActionListener(ActionListener l) {
		btnLogOut.addActionListener(l);
		btnEventlist.addActionListener(l);
		btnNotelist.addActionListener(l);
		btnUserlist_1.addActionListener(l);
		btnCalendarList.addActionListener(l);
		btnUserInfo.addActionListener(l);

	}
	
	
	public JButton getBtnUserInfo() {
		return btnUserInfo;
	}
	public JButton getBtnUserlist() {
		return btnUserlist_1;
	}
	public JButton getBtnEventlist() {
		return btnEventlist;
	}
	public JButton getBtnNotelist() {
		return btnNotelist;
	}
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	public JButton getBtnCalendarList() {
		return btnCalendarList;
	}
}
