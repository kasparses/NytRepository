package model.database;

import model.Model;
import model.QueryBuild.QueryBuilder;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseInit extends Model {

    //Test main method
    public static void main(String[] args) throws IOException, SQLException {
        new DatabaseInit().go();
    }


    public void go() throws SQLException, IOException {


//        String[] keys = {"firstKey", "secondKey"};
//        String[] wheremparamters = {"alder", "hat"};
//        QueryBuilder qb = new QueryBuilder();
//        resultSet = qb.selectFrom("user").all().ExecuteQuery();
//        resultSet = qb.selectFrom(keys, "events").where("id", "=", "123").ExecuteQuery();
//
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("email"));
//        }
//        resultSet.close();
    	
//    	String Url = "src/SQLFiles/createDBscript.sql";
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            System.out.println("Trying to connect");
//            Connection connection = (Connection) DriverManager.getConnection(Url);
//
//            System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
//                    + connection.getMetaData().getDatabaseProductName());
//        } catch (Exception e) {
//System.out.println("Unable to make connection with DB");
//            e.printStackTrace();
//        }

//        if (doesDatabaseExist()) {
//            System.out.print("Database environment does exist");
//        } else {
//            System.out.print("Database environment does NOT exist");
            readfromSqlFile("src/SQLFiles/createDBscript.sql");
//        }

    }
}
