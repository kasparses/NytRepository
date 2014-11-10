package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class OpenAdmin extends JFrame {

	
	private JPanel contentPane;
	private final JButton btnCloseAdmin = new JButton("Close Admin");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenAdmin frame = new OpenAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OpenAdmin() {
		setTitle("Open Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnCloseAdmin.setBounds(215, 179, 132, 33);
		
		contentPane.add(btnCloseAdmin);
	}
	
	public void addActionListener(ActionListener l) {
		btnCloseAdmin.addActionListener(l);
		
}

	public JButton getBtnCloseAdmin() {
		return btnCloseAdmin;
	}

	public static void run() {
		
	}
	
}
