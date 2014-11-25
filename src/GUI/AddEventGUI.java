package GUI;

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

public class AddEventGUI extends JPanel {
	private JTextField textField_Location;
	private JTextField textField_ActivityID;
	private JTextField textField_Start;
	private JLabel lblCBSlogo;
	private JLabel lblUserInfo;
	private JLabel lblEnd;
	private JLabel lblName;
	private JLabel lblText;
	private JTextField textField_End;
	private JTextField textField_Title;
	private JTextField textField_Text;
	private final JLabel lblType = new JLabel("Type");
	private final JTextField textField_Type = new JTextField();
	private final JLabel lblEventid = new JLabel("EventID");
	private final JTextField textField_EventID = new JTextField();
	private final JLabel lblDescription = new JLabel("Description");
	private final JTextField textField_Description = new JTextField();
	private JButton btnSubmit;
	private JButton btnLogout;
	private JButton btnMainMenu;

	/**
	 * Create the panel.
	 */
	public AddEventGUI() {
		setPreferredSize(new Dimension(1366, 768));
		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		lblCBSlogo = new JLabel("");
		lblCBSlogo.setIcon(new ImageIcon(UserInfo.class.getResource("/Images/CBSLogo3.png")));
		lblCBSlogo.setBounds(10, 698, 250, 59);
		add(lblCBSlogo);

		textField_Location = new JTextField();
		textField_Location.setForeground(new Color(105, 105, 105));
		textField_Location.setColumns(10);
		textField_Location.setBounds(755, 160, 120, 34);
		add(textField_Location);

		JLabel lblEmail = new JLabel("Location");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 26));
		lblEmail.setBounds(483, 160, 160, 30);
		add(lblEmail);

		textField_ActivityID = new JTextField();
		textField_ActivityID.setForeground(new Color(105, 105, 105));
		textField_ActivityID.setColumns(10);
		textField_ActivityID.setBounds(755, 200, 120, 34);
		add(textField_ActivityID);

		JLabel lblTeam = new JLabel("ActivityID");
		lblTeam.setFont(new Font("Arial", Font.BOLD, 26));
		lblTeam.setForeground(new Color(255, 255, 255));
		lblTeam.setBounds(483, 200, 160, 30);
		add(lblTeam);

		textField_Start = new JTextField();
		textField_Start.setForeground(new Color(105, 105, 105));
		textField_Start.setColumns(10);
		textField_Start.setBounds(755, 240, 120, 34);
		add(textField_Start);

		JLabel lblCreateddate = new JLabel("Start");
		lblCreateddate.setForeground(new Color(255, 255, 255));
		lblCreateddate.setFont(new Font("Arial", Font.BOLD, 26));
		lblCreateddate.setBounds(483, 240, 160, 30);
		add(lblCreateddate);

		lblUserInfo = new JLabel("Create event");
		lblUserInfo.setForeground(Color.WHITE);
		lblUserInfo.setFont(new Font("Arial", Font.BOLD, 78));
		lblUserInfo.setBounds(451, 50, 466, 91);
		add(lblUserInfo);

		lblEnd = new JLabel("End");
		lblEnd.setForeground(Color.WHITE);
		lblEnd.setFont(new Font("Arial", Font.BOLD, 26));
		lblEnd.setBounds(483, 280, 160, 30);
		add(lblEnd);

		lblText = new JLabel("Text");
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font("Arial", Font.BOLD, 26));
		lblText.setBounds(483, 360, 160, 30);
		add(lblText);
		
				lblName = new JLabel("Title");
				lblName.setForeground(Color.WHITE);
				lblName.setFont(new Font("Arial", Font.BOLD, 26));
				lblName.setBounds(483, 320, 160, 30);
				add(lblName);

		textField_End = new JTextField();
		textField_End.setForeground(SystemColor.controlDkShadow);
		textField_End.setColumns(10);
		textField_End.setBounds(755, 280, 120, 34);
		add(textField_End);

		textField_Title = new JTextField();
		textField_Title.setForeground(SystemColor.controlDkShadow);
		textField_Title.setColumns(10);
		textField_Title.setBounds(755, 320, 120, 34);
		add(textField_Title);

		textField_Text = new JTextField();
		textField_Text.setForeground(SystemColor.controlDkShadow);
		textField_Text.setColumns(10);
		textField_Text.setBounds(755, 360, 120, 34);
		add(textField_Text);
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Arial", Font.BOLD, 26));
		lblType.setBounds(483, 400, 160, 30);

		add(lblType);
		textField_Type.setForeground(SystemColor.controlDkShadow);
		textField_Type.setColumns(10);
		textField_Type.setBounds(755, 400, 120, 34);

		add(textField_Type);
		lblEventid.setForeground(Color.WHITE);
		lblEventid.setFont(new Font("Arial", Font.BOLD, 26));
		lblEventid.setBounds(483, 440, 160, 30);
		
		add(lblEventid);
		textField_EventID.setForeground(SystemColor.controlDkShadow);
		textField_EventID.setColumns(10);
		textField_EventID.setBounds(755, 440, 120, 34);
		
		add(textField_EventID);
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Arial", Font.BOLD, 26));
		lblDescription.setBounds(483, 480, 160, 30);
		
		add(lblDescription);
		textField_Description.setForeground(SystemColor.controlDkShadow);
		textField_Description.setColumns(10);
		textField_Description.setBounds(755, 480, 120, 34);
		
		add(textField_Description);
		
		JButton btnSubmit = new JButton("Create Event");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBounds(558, 545, 250, 50);
		add(btnSubmit);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBounds(587, 625, 191, 50);
		add(btnMainMenu);
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(587, 690, 191, 50);
		add(btnLogout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddEventGUI.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1360, 762);
		add(label);



	}
	
	public void addActionListener(ActionListener l) {
		btnSubmit.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
	}

	public JTextField getTextField_Location() {
		return textField_Location;
	}

	public JTextField getTextField_ActivityID() {
		return textField_ActivityID;
	}

	public JTextField getTextField_Start() {
		return textField_Start;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JTextField getTextField_End() {
		return textField_End;
	}

	public JTextField getTextField_Title() {
		return textField_Title;
	}

	public JTextField getTextField_Text() {
		return textField_Text;
	}

	public JTextField getTextField_Type() {
		return textField_Type;
	}

	public JTextField getTextField_EventID() {
		return textField_EventID;
	}

	public JTextField getTextField_Description() {
		return textField_Description;
	}
}