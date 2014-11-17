package model.DailyUpdate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.QueryBuild.QueryBuilder;

public class DailyUpdateController {
QueryBuilder qb = new QueryBuilder();
    
    private ResultSet resultSet;
    
    public Object dailyUpdate(){
 		 Object noReturn = "";
 		 long lastUpdateTime = 0;
 		try {
 			resultSet= qb.selectFrom("dailyupdate").where("msg_type", "=", "hej").ExecuteQuery();
 			while (resultSet.next()){
 	  			lastUpdateTime = resultSet.getLong("LastUpdateTime");

 			}
 			System.out.println("lastUpdateTime: "+lastUpdateTime);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     	Date date = new Date(); // Current date & time
	     	long maxTimeNoUpdate = 86400; // Maximum one day with no update
	     	long currentTime = date.getTime(); //getTime method show how many milliseconds that have passed since January 1 1970 00:00:00
	     	
	     	long timeSinceUpdate = currentTime - lastUpdateTime; 
	     	//86400000 milliseconds on an hour
	     	
	     	System.out.println("timeSinceUpdate: "+timeSinceUpdate);
	     	double daysPassed = timeSinceUpdate / 86400000;
	     	System.out.println("daysPassed: "+daysPassed);
	     	int days = (int)daysPassed;
	     	System.out.println("days: "+days);
	     	
	     	for(int i = 0; i<30; i++){
	     		
	     	}
	      	
	     	// if more than 1 hour ago, do update
	     	if(days > 1){
	     		// return fresh weather data
	     		QOTDModel qotdModel = new QOTDModel();
	     		qotdModel.saveQuote(lastUpdateTime, days);	
	     	}
			return noReturn; 
	     }

}
