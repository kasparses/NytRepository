package model.note;
import java.sql.SQLException;

public class Testnote {
	public static void main (String [] args) throws SQLException{
		int nID = 3;
		String text = "";
		String date = "";
		String cb = "";
		int eID = 11;		
		Note note = new Note();
		note.CreateNote(nID, text, date, cb, eID);
		note.DeleteNote(nID);
	}
}
