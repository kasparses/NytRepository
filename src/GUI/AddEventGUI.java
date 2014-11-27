package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AddEventGUI extends JPanel {
	private JTextField textField_Location;
	private JLabel lblCBSlogo;
	private JLabel lblUserInfo;
	private JLabel lblEnd;
	private JLabel lblName;
	private JLabel lblText;
	private JTextField textField_Title;
	private JTextField textField_Text;
	private final JLabel lblType = new JLabel("Type");
	private final JTextField textField_Type = new JTextField();
	private final JLabel lblDescription = new JLabel("Description");
	private final JTextField textField_Description = new JTextField();
	private JButton btnSubmit;
	private JButton btnLogout;
	private JButton btnMainMenu;
	private JLabel lblNewLabel;
	private JTextField textField_CalendarName;
	private JComboBox comboBox_StartMinutes;
	private JComboBox comboBox_StartHour;
	private JComboBox comboBox_EndHour;
	private JComboBox comboBox_EndMinutes;
	private JComboBox<Integer> comboBox;
	private JComboBox comboBox_1;
	private JLabel lblYear;
	private JLabel lblYear_1;
	private final JComboBox comboBox_StartYear = new JComboBox();
	private final JComboBox comboBox_EndYear = new JComboBox();
	private final JLabel lblMonth = new JLabel("Month:");
	private final JLabel lblMonth_1 = new JLabel("Month:");
	private final JLabel lblDay = new JLabel("Day:");
	private final JLabel lblDay_1 = new JLabel("Day:");
	private final JComboBox comboBox_StartMonth = new JComboBox();
	private final JComboBox comboBox_EndMonth = new JComboBox();
	private final JComboBox comboBox_StartDay = new JComboBox();
	private final JComboBox comboBox_EndDay = new JComboBox();
	private final JLabel lblTime = new JLabel("Time:");
	private final JLabel lblTime_1 = new JLabel("Time:");
	private final JLabel label_1 = new JLabel(":");
	private final JLabel label_2 = new JLabel(":");

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
		textField_Location.setBounds(755, 126, 120, 34);
		add(textField_Location);

		JLabel lblEmail = new JLabel("Location");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 26));
		lblEmail.setBounds(483, 126, 160, 30);
		add(lblEmail);

		JLabel lblCreateddate = new JLabel("Start");
		lblCreateddate.setForeground(Color.WHITE);
		lblCreateddate.setFont(new Font("Arial", Font.BOLD, 26));
		lblCreateddate.setBounds(483, 171, 160, 30);
		add(lblCreateddate);

		lblUserInfo = new JLabel("Create event");
		lblUserInfo.setForeground(Color.WHITE);
		lblUserInfo.setFont(new Font("Arial", Font.BOLD, 78));
		lblUserInfo.setBounds(451, 11, 494, 90);
		add(lblUserInfo);

		lblEnd = new JLabel("End");
		lblEnd.setForeground(Color.WHITE);
		lblEnd.setFont(new Font("Arial", Font.BOLD, 26));
		lblEnd.setBounds(483, 216, 160, 30);
		add(lblEnd);

		lblText = new JLabel("Text");
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font("Arial", Font.BOLD, 26));
		lblText.setBounds(483, 306, 160, 30);
		add(lblText);
		
				lblName = new JLabel("Title");
				lblName.setForeground(Color.WHITE);
				lblName.setFont(new Font("Arial", Font.BOLD, 26));
				lblName.setBounds(483, 261, 160, 30);
				add(lblName);

		textField_Title = new JTextField();
		textField_Title.setForeground(SystemColor.controlDkShadow);
		textField_Title.setColumns(10);
		textField_Title.setBounds(755, 261, 120, 34);
		add(textField_Title);

		textField_Text = new JTextField();
		textField_Text.setForeground(SystemColor.controlDkShadow);
		textField_Text.setColumns(10);
		textField_Text.setBounds(755, 306, 392, 95);
		add(textField_Text);
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Arial", Font.BOLD, 26));
		lblType.setBounds(483, 412, 160, 30);

		add(lblType);
		textField_Type.setForeground(SystemColor.controlDkShadow);
		textField_Type.setColumns(10);
		textField_Type.setBounds(755, 412, 120, 34);

		add(textField_Type);
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Arial", Font.BOLD, 26));
		lblDescription.setBounds(483, 457, 160, 30);
		
		add(lblDescription);
		textField_Description.setForeground(SystemColor.controlDkShadow);
		textField_Description.setColumns(10);
		textField_Description.setBounds(755, 457, 120, 34);
		
		add(textField_Description);
		
		btnSubmit = new JButton("Create Event");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBounds(570, 574, 225, 45);
		add(btnSubmit);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBounds(570, 630, 225, 45);
		add(btnMainMenu);
		
		btnLogout = new JButton("Log Out");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(570, 686, 225, 45);
		add(btnLogout);
		
		lblNewLabel = new JLabel("Calendar Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel.setBounds(483, 502, 201, 30);
		add(lblNewLabel);
		
		textField_CalendarName = new JTextField();
		textField_CalendarName.setBounds(755, 502, 120, 34);
		add(textField_CalendarName);
		textField_CalendarName.setColumns(10);
		
		
		
//	     
//	    
//	      String[] str = {"top","left","bottom","right"};
//	      int n = str.length;
//	      setLayout(new GridLayout(n,2));
//	      setBorder(new TitledBorder("Thickness"));
//	      combos = new JComboBox[n];
//	      for (int i=0;i<n;i++) {
//	        combos[i] = new JComboBox(new Object[]{"0","1","2","3"});
//	        add(new JLabel(str[i]));
//	        add(combos[i]);
//	      }
//	    
		
		
		
		comboBox_StartMinutes = new JComboBox();
		comboBox_StartMinutes.setBounds(1190, 179, 48, 20);
		add(comboBox_StartMinutes);
		
		comboBox_StartHour = new JComboBox();
		comboBox_StartHour.setBounds(1132, 179, 48, 20);
		add(comboBox_StartHour);
		
		comboBox_EndHour = new JComboBox();
		comboBox_EndHour.setBounds(1132, 224, 48, 20);
		add(comboBox_EndHour);
		
		comboBox_EndMinutes = new JComboBox();
		comboBox_EndMinutes.setBounds(1190, 224, 48, 20);
		add(comboBox_EndMinutes);
		
		lblYear = new JLabel("Year:");
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Arial", Font.BOLD, 20));
		lblYear.setBounds(623, 177, 50, 24);
		add(lblYear);
		
		lblYear_1 = new JLabel("Year:");
		lblYear_1.setForeground(Color.WHITE);
		lblYear_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblYear_1.setBounds(623, 222, 50, 24);
		add(lblYear_1);
		comboBox_StartYear.setBounds(696, 179, 64, 20);
		
		add(comboBox_StartYear);
		comboBox_EndYear.setBounds(696, 224, 64, 20);
		
		add(comboBox_EndYear);
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setFont(new Font("Arial", Font.BOLD, 20));
		lblMonth.setBounds(783, 177, 67, 24);
		
		add(lblMonth);
		lblMonth_1.setForeground(Color.WHITE);
		lblMonth_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblMonth_1.setBounds(783, 222, 67, 24);
		
		add(lblMonth_1);
		lblDay.setForeground(Color.WHITE);
		lblDay.setFont(new Font("Arial", Font.BOLD, 20));
		lblDay.setBounds(940, 177, 43, 24);
		
		add(lblDay);
		lblDay_1.setForeground(Color.WHITE);
		lblDay_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblDay_1.setBounds(940, 222, 43, 24);
		
		add(lblDay_1);
		comboBox_StartMonth.setBounds(869, 179, 48, 20);
		
		add(comboBox_StartMonth);
		comboBox_EndMonth.setBounds(869, 224, 48, 20);
		
		add(comboBox_EndMonth);
		comboBox_StartDay.setBounds(993, 179, 50, 20);
		
		add(comboBox_StartDay);
		comboBox_EndDay.setBounds(993, 224, 50, 20);
		
		add(comboBox_EndDay);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Arial", Font.BOLD, 20));
		lblTime.setBounds(1059, 177, 53, 24);
		
		add(lblTime);
		lblTime_1.setForeground(Color.WHITE);
		lblTime_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblTime_1.setBounds(1059, 222, 53, 24);
		
		add(lblTime_1);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 20));
		label_1.setBounds(1181, 222, 7, 24);
		
		add(label_1);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial", Font.BOLD, 20));
		label_2.setBounds(1181, 177, 7, 24);
		
		add(label_2);
		
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddEventGUI.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1360, 762);
		add(label);
		
		;

		 for (int c=0; c<=24; c++){
			 comboBox_StartHour.addItem(c);
	        }
		 for (int c2=0; c2<=60; c2+=5){
			 comboBox_StartMinutes.addItem(c2);
	        }
		 for (int c3=0; c3<=24; c3++){
			 comboBox_EndHour.addItem(c3);
	        }
		 for (int c4=0; c4<=60; c4+=5){
			 comboBox_EndMinutes.addItem(c4);
	        }

		 
		 for (int c5 = 2014; c5<2017; c5++){
			 comboBox_StartYear.addItem(c5);
		 }
		 for (int c6 = 0; c6<=12; c6++){
			 comboBox_StartMonth.addItem(c6);
		 }
		 for (int c5 = 2014; c5<2017; c5++){
			 comboBox_EndYear.addItem(c5);
		 }
		 for (int c6 = 0; c6<=12; c6++){
			 comboBox_EndMonth.addItem(c6);
		 }
		 for (int c7 = 0; c7<=31; c7++){
			 comboBox_EndDay.addItem(c7);
		 }
		 for (int c8 = 0; c8<=31; c8++){
			 comboBox_StartDay.addItem(c8);
		 }


	}
	
	public void addActionListener(ActionListener l) {
		btnSubmit.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
		comboBox_StartHour.addActionListener(l);
		comboBox_StartMinutes.addActionListener(l);
		comboBox_EndHour.addActionListener(l);
		comboBox_EndMinutes.addActionListener(l);
		comboBox_StartYear.addActionListener(l);
		comboBox_StartMonth.addActionListener(l);
		comboBox_StartDay.addActionListener(l);
		comboBox_EndYear.addActionListener(l);
		comboBox_EndMonth.addActionListener(l);
		comboBox_EndDay.addActionListener(l);
	}
	

	public JComboBox getComboBox_StartMinutes() {
		return comboBox_StartMinutes;
	}

	public JComboBox getComboBox_StartHour() {
		return comboBox_StartHour;
	}

	public JComboBox getComboBox_EndHour() {
		return comboBox_EndHour;
	}

	public JComboBox getComboBox_EndMinutes() {
		return comboBox_EndMinutes;
	}

	public JComboBox getComboBox_StartYear() {
		return comboBox_StartYear;
	}

	public JComboBox getComboBox_EndYear() {
		return comboBox_EndYear;
	}

	public JComboBox getComboBox_StartMonth() {
		return comboBox_StartMonth;
	}

	public JComboBox getComboBox_EndMonth() {
		return comboBox_EndMonth;
	}

	public JComboBox getComboBox_StartDay() {
		return comboBox_StartDay;
	}

	public JComboBox getComboBox_EndDay() {
		return comboBox_EndDay;
	}

	public JTextField getTextField_CalendarName() {
		return textField_CalendarName;
	}

	public JTextField getTextField_Location() {
		return textField_Location;
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

	public JTextField getTextField_Title() {
		return textField_Title;
	}

	public JTextField getTextField_Text() {
		return textField_Text;
	}

	public JTextField getTextField_Type() {
		return textField_Type;
	}

	public JTextField getTextField_Description() {
		return textField_Description;
	}
}