	package GUI;

	import javax.swing.JPanel;

	import java.awt.Dimension;

	import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;

	import java.awt.Font;

	import javax.swing.SwingConstants;
import javax.swing.JButton;

	import java.awt.Color;

	import javax.swing.JScrollPane;

	import java.awt.Component;

	import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;

import model.QueryBuild.QueryBuilder;

import com.mysql.jdbc.ResultSetMetaData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


	public class EventList extends JPanel {

		/**
		 * Create the panel.
		 */
		
		private JButton btnAdd;
		private JButton btnDelete;
		private ResultSet rs;
		private QueryBuilder qb;
		private final JButton btnMainMenu = new JButton("Main Menu");
		private final JButton btnLogout = new JButton("Log Out");
		
		
		public EventList() {
			setSize(new Dimension(1366, 768));
			setLayout(null);

			JLabel lblEvents = new JLabel("Eventlist");
			lblEvents.setForeground(Color.WHITE);
			lblEvents.setFont(new Font("Arial", Font.BOLD, 78));
			lblEvents.setBounds(521, 11, 323, 90);
			add(lblEvents);
			


			
			//Laver tabellen inde i Eventlisten.
			String[] columnNames = { "ID","ActivityID", "EventID", "Type", "Title", "Description", "Start", "End", "Location" };
        	String[][] data = {
        			
        			{
        			
        			}
        			};
       
        try {
			QueryBuilder qb = new QueryBuilder();
			rs = qb.selectFrom("events").all().ExecuteQuery();
			int rowSize = rs.getRow();

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
			scrollPane.setBounds(152, 171, 1062, 376);

			// Add the scroll pane to this panel.
			add(scrollPane);
						
						btnDelete = new JButton("Delete");
						btnDelete.setOpaque(true);
						btnDelete.setForeground(new Color(0, 0, 205));
						btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
						btnDelete.setBounds(1224, 211, 118, 29);
						add(btnDelete);
						
						btnAdd = new JButton("Add");
						btnAdd.setOpaque(true);
						btnAdd.setForeground(new Color(0, 0, 205));
						btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
						btnAdd.setBounds(1224, 171, 118, 29);
						add(btnAdd);
						
						btnMainMenu.setForeground(Color.WHITE);
						btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
						btnMainMenu.setContentAreaFilled(false);
						btnMainMenu.setBounds(575, 569, 216, 56);
						add(btnMainMenu);
									
									btnLogout.setForeground(Color.WHITE);
									btnLogout.setFont(new Font("Tahoma", Font.BOLD, 20));
									btnLogout.setContentAreaFilled(false);
									btnLogout.setBounds(575, 652, 216, 56);
									add(btnLogout);
												
												JLabel label_1 = new JLabel("");
												label_1.setIcon(new ImageIcon(EventList.class.getResource("/Images/CBSLogo3.png")));
												label_1.setBounds(0, 709, 250, 59);
												add(label_1);
												
															JLabel label = new JLabel("");
															label.setIcon(new ImageIcon(EventList.class.getResource("/Images/MetalBackground.jpg")));
															label.setBounds(0, 0, 1366, 768);
															add(label);

		}
		
		public void addActionListener(ActionListener l) {
			btnAdd.addActionListener(l);
			btnDelete.addActionListener(l);
			btnLogout.addActionListener(l);
			btnMainMenu.addActionListener(l);
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
		
		
	}

