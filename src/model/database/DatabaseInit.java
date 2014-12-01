package model.database;

import model.Model;
import java.io.IOException;
import java.sql.SQLException;

public class DatabaseInit extends Model {

	//Test main method
	public static void main(String[] args) throws IOException, SQLException {
		new DatabaseInit().go();
	}


	public void go() throws SQLException, IOException {
		readfromSqlFile("src/SQLFiles/createDBscript.sql");

	}
}
