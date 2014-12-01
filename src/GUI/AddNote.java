package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class AddNote extends JPanel {
	private final JLabel lblAddNote = new JLabel("Add Note");
	private final JLabel label = new JLabel("");
	private final JLabel lblCreatedBy = new JLabel("Created by:");
	private final JTextField textField_Createdby = new JTextField();
	private final JTextField textField_text = new JTextField();
	private final JLabel label_1 = new JLabel("");
	private final JLabel lblText = new JLabel("Text:");
	private final JLabel lblNoteId = new JLabel("Note ID:");
	private final JLabel lblEventId = new JLabel("Event ID:");
	private final JLabel lblDateTime = new JLabel("Date Time:");
	private final JTextField textField_NoteID = new JTextField();
	private final JTextField textField_EventID = new JTextField();
	private final JTextField textField_Date = new JTextField();
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JButton btnLogout = new JButton("Log Out");
	private final JButton btnNoteList = new JButton("Note List");
	private final JButton btnUserList = new JButton("User List");
	private final JButton btnEventList = new JButton("Event List");
	private final JButton btnCalendarList = new JButton("Calendar List");
	private final JButton btnAddNote = new JButton("Add Note");
	private final JButton btnUserInfo = new JButton("User Info");

	/**
	 * Create the panel.
	 */
	public AddNote() {
		textField_Date.setBounds(607, 366, 264, 20);
		textField_Date.setColumns(10);
		textField_EventID.setBounds(607, 331, 264, 20);
		textField_EventID.setColumns(10);
		textField_NoteID.setBounds(607, 298, 264, 20);
		textField_NoteID.setColumns(10);
		textField_text.setBounds(607, 217, 264, 68);
		textField_text.setColumns(10);
		textField_Createdby.setBounds(606, 184, 265, 22);
		textField_Createdby.setColumns(10);
		setLayout(null);
		lblAddNote.setForeground(Color.WHITE);
		lblAddNote.setFont(new Font("Tahoma", Font.BOLD, 68));
		lblAddNote.setBounds(521, 11, 324, 82);
		
		add(lblAddNote);
		lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCreatedBy.setForeground(Color.WHITE);
		lblCreatedBy.setBounds(488, 184, 104, 22);
		
		add(lblCreatedBy);
		
		add(textField_Createdby);
		
		add(textField_text);
		label_1.setIcon(new ImageIcon(AddNote.class.getResource("/Images/CBSLogo3.png")));
		label_1.setBounds(0, 709, 250, 59);
		
		add(label_1);
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblText.setBounds(488, 217, 47, 22);
		
		add(lblText);
		lblNoteId.setForeground(Color.WHITE);
		lblNoteId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNoteId.setBounds(488, 294, 78, 22);
		
		add(lblNoteId);
		lblEventId.setForeground(Color.WHITE);
		lblEventId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEventId.setBounds(488, 327, 86, 22);
		
		add(lblEventId);
		lblDateTime.setForeground(Color.WHITE);
		lblDateTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDateTime.setBounds(488, 362, 99, 22);
		
		add(lblDateTime);
		
		add(textField_NoteID);
		
		add(textField_EventID);
		
		add(textField_Date);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBounds(48, 511, 225, 45);
		
		add(btnMainMenu);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(48, 586, 225, 45);
		
		add(btnLogout);
		btnNoteList.setForeground(Color.WHITE);
		btnNoteList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNoteList.setContentAreaFilled(false);
		btnNoteList.setBounds(48, 137, 225, 45);
		
		add(btnNoteList);
		btnUserList.setForeground(Color.WHITE);
		btnUserList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserList.setContentAreaFilled(false);
		btnUserList.setBounds(48, 212, 225, 45);
		
		add(btnUserList);
		btnEventList.setForeground(Color.WHITE);
		btnEventList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEventList.setContentAreaFilled(false);
		btnEventList.setBounds(48, 287, 225, 45);
		
		add(btnEventList);
		btnCalendarList.setForeground(Color.WHITE);
		btnCalendarList.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCalendarList.setContentAreaFilled(false);
		btnCalendarList.setBounds(48, 362, 234, 45);
		
		add(btnCalendarList);
		btnAddNote.setForeground(Color.WHITE);
		btnAddNote.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAddNote.setContentAreaFilled(false);
		btnAddNote.setBounds(570, 456, 225, 45);
		
		add(btnAddNote);
		btnUserInfo.setForeground(Color.WHITE);
		btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUserInfo.setContentAreaFilled(false);
		btnUserInfo.setBounds(48, 434, 225, 45);
		
		add(btnUserInfo);
		label.setIcon(new ImageIcon(AddNote.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);

	}
	
	public void addActionListener(ActionListener l) {
		btnAddNote.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnCalendarList.addActionListener(l);
		btnEventList.addActionListener(l);
		btnNoteList.addActionListener(l);
		btnUserList.addActionListener(l);
		btnUserInfo.addActionListener(l);

	}
	

	public JButton getBtnUserInfo() {
		return btnUserInfo;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JTextField getTextField_Createdby() {
		return textField_Createdby;
	}

	public JTextField getTextField_text() {
		return textField_text;
	}

	public JButton getBtnAddNote() {
		return btnAddNote;
	}

	public JTextField getTextField_NoteID() {
		return textField_NoteID;
	}

	public JTextField getTextField_EventID() {
		return textField_EventID;
	}

	public JTextField getTextField_Date() {
		return textField_Date;
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
	
	
}
