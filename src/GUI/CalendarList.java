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
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;

public class CalendarList extends JPanel {
	private final JLabel lblCalendarList = new JLabel("Calendar List");
	private final JLabel label = new JLabel("");
	private ResultSet rs;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnDelete = new JButton("Delete");
	private final JButton btnAdd = new JButton("Add");
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JButton btnLogOut = new JButton("Log Out");
	private final JLabel label_1 = new JLabel("");


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
		lblCalendarList.setBounds(486, 11, 400, 73);
		lblCalendarList.setForeground(Color.WHITE);
		lblCalendarList.setFont(new Font("Tahoma", Font.BOLD, 60));
		
		add(lblCalendarList);
		
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
		scrollPane.setBounds(149, 171, 1062, 376);

		// Add the scroll pane to this panel.
		add(scrollPane);
		btnDelete.setOpaque(true);
		btnDelete.setForeground(new Color(0, 0, 205));
		btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnDelete.setBounds(1221, 211, 118, 29);
		
		add(btnDelete);
		btnAdd.setOpaque(true);
		btnAdd.setForeground(new Color(0, 0, 205));
		btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnAdd.setBounds(1221, 171, 118, 29);
		
		add(btnAdd);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBounds(581, 574, 203, 59);
		
		add(btnMainMenu);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBounds(581, 645, 203, 59);
		
		add(btnLogOut);
		label_1.setIcon(new ImageIcon(CalendarList.class.getResource("/Images/CBSLogo3.png")));
		label_1.setBounds(0, 694, 250, 59);
		
		add(label_1);
		
		
		label.setBounds(0, 0, 1366, 753);
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
