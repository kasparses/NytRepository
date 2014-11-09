package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class AddNote extends JPanel {
	private final JButton btnLogout = new JButton("Log out");
	private final JButton btnMainMenu = new JButton("Main menu");
	private final JLabel lblAddNote = new JLabel("Add Note");
	private final JLabel label = new JLabel("");
	private final JLabel lblCreatedBy = new JLabel("Created by:");
	private final JTextField textField_Createdby = new JTextField();
	private final JTextField textField_text = new JTextField();
	private final JButton btnAddNote = new JButton("Add note");
	private final JLabel label_1 = new JLabel("");
	private final JLabel lblText = new JLabel("Text:");
	private final JLabel lblNoteId = new JLabel("Note ID:");
	private final JLabel lblEventId = new JLabel("Event ID:");
	private final JLabel lblDateTime = new JLabel("Date Time:");
	private final JTextField textField_NoteID = new JTextField();
	private final JTextField textField_EventID = new JTextField();
	private final JTextField textField_Date = new JTextField();

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
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnLogout.setBounds(607, 673, 152, 44);
		
		add(btnLogout);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnMainMenu.setBounds(598, 619, 169, 43);
		
		add(btnMainMenu);
		lblAddNote.setForeground(Color.WHITE);
		lblAddNote.setFont(new Font("Tahoma", Font.BOLD, 68));
		lblAddNote.setBounds(521, 66, 324, 82);
		
		add(lblAddNote);
		lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCreatedBy.setForeground(Color.WHITE);
		lblCreatedBy.setBounds(488, 184, 104, 22);
		
		add(lblCreatedBy);
		
		add(textField_Createdby);
		
		add(textField_text);
		btnAddNote.setForeground(Color.WHITE);
		btnAddNote.setFont(new Font("Arial", Font.BOLD, 30));
		btnAddNote.setContentAreaFilled(false);
		btnAddNote.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnAddNote.setBounds(598, 486, 169, 43);
		
		add(btnAddNote);
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
		label.setIcon(new ImageIcon(AddNote.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 1366, 768);
		
		add(label);

	}
	
	public void addActionListener(ActionListener l) {
		btnAddNote.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
		
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
	
}
