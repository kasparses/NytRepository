package GUI;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

import model.QueryBuild.QueryBuilder;

import com.mysql.jdbc.ResultSetMetaData;

public class NoteList extends JPanel {
	private JTable table;
	private final JLabel lblBackground = new JLabel("");
	private JLabel lblHeader;
	private JButton btnDelete;
	private JButton btnAdd;
	private JLabel label;
	private ResultSet rs;
	private QueryBuilder qb;
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JButton btnLogout = new JButton("Log Out");
	

	/**
	 * Create the panel.
	 */
	public NoteList() {
		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		//Laver tabellen inde i Eventlisten.
		String[] columnNames = { "NoteID", "EventID", "Created by", "Text", "Datetime" };
    	String[][] data = {
    			
    			{
    			
    			}
    			};
   
    try {
		QueryBuilder qb = new QueryBuilder();
		rs = qb.selectFrom("notes").all().ExecuteQuery();
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
		
		lblHeader = new JLabel("NoteList");
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Arial", Font.BOLD, 78));
		lblHeader.setBounds(527, 11, 312, 90);
		add(lblHeader);
		
		btnDelete = new JButton("Delete");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setOpaque(true);
		btnDelete.setForeground(new Color(0, 0, 205));
		btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnDelete.setBounds(1224, 211, 118, 29);
		add(btnDelete);
		
		btnAdd = new JButton("Add");
		btnAdd.setContentAreaFilled(false);
		btnAdd.setOpaque(true);
		btnAdd.setForeground(new Color(0, 0, 205));
		btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnAdd.setBounds(1225, 171, 118, 29);
		add(btnAdd);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(NoteList.class.getResource("/Images/CBSLogo3.png")));
		label.setBounds(0, 709, 250, 59);
		add(label);
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
		lblBackground.setIcon(new ImageIcon(NoteList.class.getResource("/Images/MetalBackground.jpg")));
		lblBackground.setBounds(0, 0, 1366, 768);
		
		add(lblBackground);
	}
	
	public void addActionListener(ActionListener l) {
		btnAdd.addActionListener(l);
		btnDelete.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}
}
