package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.mysql.jdbc.ResultSetMetaData;
import model.QueryBuild.*;
 
public class UserList extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ActionListener ActionListener = null;
	private boolean DEBUG = false;
	private JButton btnAdd;
	private JButton btnDelete;
	private ResultSet rs;
	private QueryBuilder qb;
	private final JLabel lblUserlist = new JLabel("Userlist");
	private final JButton btnMainMenu = new JButton("Main Menu");
	private final JButton btnLogout = new JButton("Log Out");
	private final JLabel label = new JLabel("");
	
    public UserList() {
    	setSize(new Dimension(1366, 768));
 
    	
		String[] columnNames = { "UserID", "Email", "Active", "Created", "Type", "Password","CPR" };
        	String[][] data = {
        			
        			{
        			
        			}
        			};
       
        try {
			QueryBuilder qb = new QueryBuilder();
			rs = qb.selectFrom("users").all().ExecuteQuery();
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
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setRowSelectionAllowed(true);
        
 
//        if (DEBUG) {
//            table.addMouseListener(new MouseAdapter() {
//                public void mouseClicked(MouseEvent e) {
//                    printDebugData(table);
//                }
//            });
//        }
        setLayout(null);
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255, 255), new Color(0, 0, 205), new Color(255, 255, 255)), new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
        scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255, 255), new Color(0, 0, 205), new Color(255, 255, 255)), null));

//        scrollPane.setBounds(387, 225, 606, 385);

        scrollPane.setBounds(152, 171, 1062, 376);

 
        //Add the scroll pane to this panel.
        add(scrollPane);
        
        btnAdd = new JButton("Add");
        btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
        btnAdd.setForeground(new Color(0, 0, 205));
        btnAdd.setOpaque(true);
        
        btnAdd.setBounds(1224, 171, 118, 29);
        add(btnAdd);
        
        btnDelete = new JButton("Delete");
        btnDelete.setOpaque(true);
        btnDelete.setForeground(new Color(0, 0, 205));
        btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
        btnDelete.setBounds(1224, 211, 118, 29);
        add(btnDelete);
        lblUserlist.setForeground(Color.WHITE);
        lblUserlist.setFont(new Font("Arial", Font.BOLD, 78));
        lblUserlist.setBounds(534, 11, 298, 90);
        
        add(lblUserlist);
            btnMainMenu.setContentAreaFilled(false);
            btnMainMenu.setForeground(Color.WHITE);
            btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
            btnMainMenu.setBounds(575, 569, 216, 56);
            
            add(btnMainMenu);
                btnLogout.setForeground(Color.WHITE);
                btnLogout.setFont(new Font("Tahoma", Font.BOLD, 20));
                btnLogout.setContentAreaFilled(false);
                btnLogout.setBounds(575, 652, 216, 56);
                
                add(btnLogout);
                        label.setIcon(new ImageIcon(UserList.class.getResource("/Images/CBSLogo3.png")));
                        label.setBounds(0, 709, 250, 59);
                        
                        add(label);
                        
                            JLabel lblBackground = new JLabel("Background");
                            lblBackground.setIcon(new ImageIcon(UserList.class.getResource("/Images/MetalBackground.jpg")));
                            lblBackground.setBackground(new Color(245, 245, 245));
                            lblBackground.setForeground(new Color(245, 255, 250));
                            lblBackground.setOpaque(true);
                            lblBackground.setBounds(0, 0, 1366, 768);
                            add(lblBackground);
    }
 
//    private void printDebugData(JTable table) {
//        int numRows = table.getRowCount();
//        int numCols = table.getColumnCount();
//        javax.swing.table.TableModel model = table.getModel();
// 
//        System.out.println("Value of data: ");
//        for (int i=0; i < numRows; i++) {
//            System.out.print("    row " + i + ":");
//            for (int j=0; j < numCols; j++) {
//                System.out.print("  " + model.getValueAt(i, j));
//            }
//            System.out.println();
//        }
//        System.out.println("--------------------------");
//    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("SimpleTableDemo");
//        frame.setSize(1366, 768);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        //Create and set up the content pane.
//        UserList newContentPane = new UserList();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
// 
//
//        
//        frame.setVisible(true);
//    }
 
//    public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//     
//
//        }
//        });
//    }
    
    public void addActionListener(ActionListener l) {
		btnDelete.addActionListener(l);
		btnAdd.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
		
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

	public JButton getBtnLogout() {
		return btnLogout;
	}
}