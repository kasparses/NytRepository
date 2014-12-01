package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class OpenAdmin implements Runnable{

	private JFrame frmOpenAdminConsole;
	private final JButton btnOpenAdminConsole = new JButton("Open Admin Console");
	private final JLabel label = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenAdmin window = new OpenAdmin();
					window.frmOpenAdminConsole.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OpenAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOpenAdminConsole = new JFrame();
		frmOpenAdminConsole.setTitle("Open Admin Console");
		frmOpenAdminConsole.setBounds(100, 100, 450, 300);
		frmOpenAdminConsole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOpenAdminConsole.getContentPane().setLayout(null);
		btnOpenAdminConsole.setForeground(Color.BLACK);
		btnOpenAdminConsole.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOpenAdminConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUILogic admin = new GUILogic();
				admin.run();
			}
		});
		btnOpenAdminConsole.setBounds(136, 148, 177, 33);
		
		frmOpenAdminConsole.getContentPane().add(btnOpenAdminConsole);
		label.setIcon(new ImageIcon(OpenAdmin.class.getResource("/Images/MetalBackground.jpg")));
		label.setBounds(0, 0, 434, 261);
		
		frmOpenAdminConsole.getContentPane().add(label);
	}
	
	@Override
	public void run() {
		frmOpenAdminConsole.setVisible(true);
	}

		
}
