package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

import model.QueryBuild.QueryBuilder;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.border.MatteBorder;

public class CalendarList extends JPanel {
	private final JLabel lblCalendarList = new JLabel("Calendar List");
	private final JButton btnAdd = new JButton("Add");
	private final JButton btnDelete = new JButton("Delete");
	private final JLabel label = new JLabel("");
	private ResultSet rs;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JButton btnLogOut = new JButton("Log Out");


	/**
	 * Create the panel.
	 */
	public CalendarList() {
		
		//Laver tabellen inde i CalendarListen.
		String[] columnNames = { "CalendarID","Type", "Name", "Active", "Created By", "Private/Public" };
    	String[][] data = {
    			
    			{
    			
    			}
    			};
   
    try {
		QueryBuilder qb = new QueryBuilder();
		rs = qb.selectFrom("Calendar").all().ExecuteQuery();
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
		setLayout(null);
		lblCalendarList.setBounds(486, 31, 413, 73);
		lblCalendarList.setForeground(Color.WHITE);
		lblCalendarList.setFont(new Font("Tahoma", Font.BOLD, 60));
		
		add(lblCalendarList);
		btnAdd.setBounds(1075, 238, 176, 43);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Arial", Font.BOLD, 30));
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnAdd.setBackground(Color.WHITE);
		
		add(btnAdd);
		btnDelete.setBounds(1075, 306, 176, 43);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 30));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnDelete.setBackground(Color.WHITE);
		
		add(btnDelete);
		
		final JTable table = new JTable(data, columnNames);
		table.setSurrendersFocusOnKeystroke(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		scrollPane.setBounds(1045, 138, -599, 294);
		
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
		scrollPane.setBounds(387, 194, 591, 361);

		// Add the scroll pane to this panel.
		add(scrollPane);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnMainMenu.setBackground(Color.WHITE);
		btnMainMenu.setBounds(645, 609, 176, 43);
		
		add(btnMainMenu);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(645, 661, 176, 43);
		
		add(btnLogOut);
		
		
		label.setBounds(6, 6, 1371, 753);
		label.setIcon(new ImageIcon(CalendarList.class.getResource("/Images/MetalBackground.jpg")));
		
		add(label);
		
		
	}
	public void addActionListener(ActionListener l) {
		btnAdd.addActionListener(l);
		btnDelete.addActionListener(l);
		btnMainMenu.addActionListener(l);
		btnLogOut.addActionListener(l);
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	
}
