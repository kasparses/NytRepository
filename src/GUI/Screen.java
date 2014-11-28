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
	public static final String USERLIST = "name_480079376033151";
	public static final String ADDNOTE = "name_738191050387273";
	public static final String FORGOT = "name_921186008853499";
	public static final String CALENDARLIST = "name_493897513062219";
	public static final String DELETECALENDAR = "name_496088936866551";
	public static final String CREATECALENDAR = "name_508229372553648";
	public static final String DELETEEVENT = "name_519922165417969";
	public static final String BLOCKUSER = "name_755445244821977";


	private JPanel contentPane;
	private final AddEventGUI addEventGUI = new AddEventGUI();
	private final AddUser addUser = new AddUser();
	private final EventList eventList = new EventList();
	private final Login login = new Login();
	private final MainMenu mainMenu = new MainMenu();
	private final NoteList noteList = new NoteList();
	private final UserInfo userInfo = new UserInfo();
	private final UserList userList = new UserList();
	CardLayout c;
	private final AddNote addNote = new AddNote();
	private final ForgotLogin forgotLogin = new ForgotLogin();
	private final CalendarList calendarList = new CalendarList();
	private final DeleteCalendar deleteCalendar = new DeleteCalendar();
	private final CreateCalendar createCalendar = new CreateCalendar();
	private final DeleteEvent deleteEvent = new DeleteEvent();
	private final BlockUser blockUser = new BlockUser();



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
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1390, 818);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(blockUser, "name_755445244821977");
		
		contentPane.add(deleteEvent, "name_519922165417969");
		
		contentPane.add(calendarList, "name_493897513062219");
		
		contentPane.add(forgotLogin, "name_921186008853499");
		
		contentPane.add(userList, "name_480079376033151");
		
		contentPane.add(userInfo, "name_362280744832869");
		
		contentPane.add(addNote, "name_738191050387273");
		
		contentPane.add(noteList, "name_362271144977704");
		
		contentPane.add(createCalendar, "name_508229372553648");
		
		contentPane.add(deleteCalendar, "name_496088936866551");
		
		contentPane.add(mainMenu, "name_362262329408944");
		
		contentPane.add(login, "name_362236793182581");
		
		contentPane.add(eventList, "name_362220577395912");
		
		contentPane.add(addUser, "name_362200721529567");
		
		contentPane.add(addEventGUI, "name_362181513611519");

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

	public EventList getEventList() {
		return eventList;
	}

	public UserList getUserList() {
		return userList;
	}
	
	public AddNote getAddNote() {
		return addNote;
	}

	public ForgotLogin getForgotLogin() {
		return forgotLogin;
	}

	public CalendarList getCalendarList() {
		return calendarList;
	}

	public DeleteCalendar getDeleteCalendar() {
		return deleteCalendar;
	}

	public CreateCalendar getCreateCalendar() {
		return createCalendar;
	}

	public DeleteEvent getDeleteEvent() {
		return deleteEvent;
	}

	public BlockUser getBlockUser() {
		return blockUser;
	}
	
}
