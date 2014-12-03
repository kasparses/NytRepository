	package GUI;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import model.QueryBuild.QueryBuilder;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;



	public class EventList extends JPanel {

		/**
		 * Create the panel.
		 */
		
		private JButton btnAdd;
		private JButton btnDelete;
		private ResultSet rs;
		private QueryBuilder qb;
		private JButton btnMainMenu;
		private JButton btnLogout;
		private JLabel label_1;
		private JButton btnAddNote;
		private JButton btnDeleteNote;
		private JButton btnUpdateNote;
		private JLabel lblNotetext;
		private JTextField textField;
		private JComboBox comboBox;
		private JLabel lblPleaseSelectThe;
		
			
		
		public EventList() {
			setSize(new Dimension(1366, 768));
			setLayout(null);

			JLabel lblEvents = new JLabel("Eventlist");
			lblEvents.setForeground(Color.WHITE);
			lblEvents.setFont(new Font("Arial", Font.BOLD, 78));
			lblEvents.setBounds(521, 11, 333, 90);
			add(lblEvents);

			
			//Laver tabellen inde i Eventlisten.
			String[] columnNames = { "ID","ActivityID", "EventID", "Type", "Title", "Description", "Start", "End", "Location", "Note", "superID" };
        	String[][] data = {
        			
        			{
        			
        			}
        			};
       
        	int rowSize = 0;
        try {
			QueryBuilder qb = new QueryBuilder();
			rs = qb.selectFrom("events").all().ExecuteQuery();
			 rowSize = rs.getRow();

			try {
	            rs.last();
	            rowSize = rs.getRow();
	            rs.beforeFirst();
	        }
	        catch(Exception ex) {

	        }

	        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	        int columnSize = rsmd.getColumnCount();
	       

	        data = new String[rowSize][columnSize];

	        int i =0;
	        while(rs.next() && i < rowSize)
	        {
	            for(int j=0;j<columnSize;j++){
	                data[i][j] = rs.getString(j+1);
	            }
	            i++;                    
	        }
	       
	        
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

			final JTable table = new JTable(data, columnNames);
			table.setSurrendersFocusOnKeystroke(true);
			table.setPreferredScrollableViewportSize(new Dimension(500, 100));
			table.setFillsViewportHeight(true);
			table.setRowSelectionAllowed(true);

			// Create the scroll pane and add the table to it.
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
							255), new Color(0, 0, 205), new Color(255, 255, 255)),
					new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
			scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
							255), new Color(0, 0, 205), new Color(255, 255, 255)),
					null));
			scrollPane.setBounds(149, 171, 1062, 376);

			// Add the scroll pane to this panel.
			add(scrollPane);
						
						btnDelete = new JButton("Delete event");
						btnDelete.setOpaque(true);
						btnDelete.setForeground(new Color(0, 0, 205));
						btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
						btnDelete.setBounds(1221, 209, 118, 29);
						add(btnDelete);
						
						btnAdd = new JButton("Add event");
						btnAdd.setOpaque(true);
						btnAdd.setForeground(new Color(0, 0, 205));
						btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
						btnAdd.setBounds(1221, 169, 118, 29);
						add(btnAdd);
						
						btnMainMenu = new JButton("Main Menu");
						btnMainMenu.setForeground(Color.WHITE);
						btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
						btnMainMenu.setContentAreaFilled(false);
						btnMainMenu.setBounds(581, 558, 203, 59);
						add(btnMainMenu);
						
						btnLogout = new JButton("Log Out");
						btnLogout.setForeground(Color.WHITE);
						btnLogout.setFont(new Font("Tahoma", Font.BOLD, 30));
						btnLogout.setContentAreaFilled(false);
						btnLogout.setBounds(581, 629, 203, 59);
						add(btnLogout);
									
									btnAddNote = new JButton("Add note");
									btnAddNote.setOpaque(true);
									btnAddNote.setForeground(new Color(0, 0, 205));
									btnAddNote.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
									btnAddNote.setBounds(1221, 249, 118, 29);
									add(btnAddNote);
									
									btnDeleteNote = new JButton("Delete note");
									btnDeleteNote.setOpaque(true);
									btnDeleteNote.setForeground(new Color(0, 0, 205));
									btnDeleteNote.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
									btnDeleteNote.setBounds(1221, 289, 118, 29);
									add(btnDeleteNote);
									
									btnUpdateNote = new JButton("Update note");
									btnUpdateNote.setOpaque(true);
									btnUpdateNote.setForeground(new Color(0, 0, 205));
									btnUpdateNote.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
									btnUpdateNote.setBounds(1221, 329, 118, 29);
									add(btnUpdateNote);
									
									textField = new JTextField();
									textField.setBounds(1061, 131, 295, 20);
									add(textField);
									textField.setColumns(10);
									
									lblNotetext = new JLabel("Enter the note text here:");
									lblNotetext.setFont(new Font("Tahoma", Font.BOLD, 13));
									lblNotetext.setForeground(Color.WHITE);
									lblNotetext.setBounds(886, 132, 165, 16);
									add(lblNotetext);
									
									comboBox = new JComboBox();
									comboBox.setBounds(1288, 95, 51, 20);
									add(comboBox);
									 for (int i=0; i<=rowSize; i++){
										 comboBox.addItem(i);
//										 comboBox_EndMinutes.addItem(c4);
								        }
									
									lblPleaseSelectThe = new JLabel("Please select the superID of the note you want to affect:");
									lblPleaseSelectThe.setBounds(1003, 98, 276, 14);
									add(lblPleaseSelectThe);
									
									label_1 = new JLabel("");
									label_1.setIcon(new ImageIcon(EventList.class.getResource("/Images/CBSLogo3.png")));
									label_1.setBounds(0, 709, 250, 59);
									add(label_1);
									
												JLabel label = new JLabel("");
												label.setIcon(new ImageIcon(EventList.class.getResource("/Images/MetalBackground.jpg")));
												label.setBounds(0, 0, 1366, 768);
												add(label);
												table.setCellSelectionEnabled(true);
										        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		}
		 
		public void addActionListener(ActionListener l) {
			btnAdd.addActionListener(l);
			btnDelete.addActionListener(l);
			btnLogout.addActionListener(l);
			btnMainMenu.addActionListener(l);
			btnAddNote.addActionListener(l);
			btnDeleteNote.addActionListener(l);
			btnUpdateNote.addActionListener(l);
			comboBox.addActionListener(l);
		}

		
		public JComboBox getComboBox() {
			return comboBox;
		}

		public JButton getBtnAdd() {
			return btnAdd;
		}

		public JButton getBtnDelete() {
			return btnDelete;
		}

		public JButton getBtnLogout() {
			return btnLogout;
		}

		public JButton getBtnMainMenu() {
			return btnMainMenu;
		}

		public JButton getBtnAddNote() {
			return btnAddNote;
		}

		public JButton getBtnDeleteNote() {
			return btnDeleteNote;
		}

		public JButton getBtnUpdateNote() {
			return btnUpdateNote;
		}

		public JTextField getTextField() {
			return textField;
		}
		
		
		
	}

