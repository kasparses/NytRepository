package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

public class Screen extends JFrame {

	public static final String LOGIN = "name_362236793182581";
	public static final String MAINMENU = "name_362262329408944";
	public static final String ADDCOURSE = "name_362036683693928";
	public static final String ADDEVENT = "name_362181513611519";
	public static final String EVENTLIST = "name_362220577395912";
	public static final String NOTELIST = "name_362271144977704";
	public static final String USERINFO = "name_362280744832869";
	public static final String ADDUSER = "name_362200721529567";

	private JPanel contentPane;
	private final AddCourse addCourse = new AddCourse();
	private final AddEventGUI addEventGUI = new AddEventGUI();
	private final AddUser addUser = new AddUser();
	private final EventList eventList = new EventList();
	private final Login login = new Login();
	private final MainMenu mainMenu = new MainMenu();
	private final NoteList noteList = new NoteList();
	private final UserInfo userInfo = new UserInfo();
	CardLayout c;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
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
	public Screen() {
		setTitle("Doek4life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1390, 818);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(userInfo, "name_362280744832869");
		
		contentPane.add(noteList, "name_362271144977704");
		
		contentPane.add(mainMenu, "name_362262329408944");
		
		contentPane.add(login, "name_362236793182581");
		
		contentPane.add(eventList, "name_362220577395912");
		
		contentPane.add(addUser, "name_362200721529567");
		
		contentPane.add(addEventGUI, "name_362181513611519");
		
		contentPane.add(addCourse, "name_362036683693928");

		c = (CardLayout) getContentPane().getLayout();

	}
	
	public Login getLogin() {
		return login;
	}
	
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	public NoteList getNoteList() {
		return noteList;
	}
	
	public EventList getEventlist() {
		return eventList;
	}
	public AddEventGUI getAddEventGUI() {
		return addEventGUI;
	}
	public AddUser getAddUser() {
		return addUser;
	}
	public void show(String card) {
		c.show(getContentPane(),  card);
	}
}
