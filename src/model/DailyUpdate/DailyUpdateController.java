package model.DailyUpdate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import JsonClasses.DailyUpdate;
import model.QueryBuild.QueryBuilder;


public class DailyUpdateController {
QueryBuilder qb = new QueryBuilder();
DailyUpdate DU = new DailyUpdate();
Gson gson = new GsonBuilder().create();
    
    private ResultSet resultSet;
    
    /**
     * This method checks how long time it has been since the dailyupdate table, which contains the quote of the day, has been updated. 
     * if it has been more than one day since the quote of the day has been updated then the method saveQuote is called to update the quote of the day. 
     * @return
     */
    public String dailyUpdate(){
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
	     	long currentTime = date.getTime(); //getTime method show how many milliseconds that have passed since January 1 1970 00:00:00
	     	long timeSinceUpdate = currentTime - lastUpdateTime; 
	     	
	     ;
	     	//86400000 milliseconds on a day
	     	double daysPassed = timeSinceUpdate / 86400000;	     
	     	int days = (int)daysPassed;	     	     	
	     	// if more than 1 hour ago, do update
	     	if(days >= 1){
	     	
	     		// return fresh weather data
	     		QOTDModel qotdModel = new QOTDModel();		
	     		
	     		qotdModel.saveQuote(lastUpdateTime, days);	
	     	}
	     	String answer = returnDailyUpdate();
			return answer; 
	     }
    
    /**
     * This method gets the quote of the day from the database.
     * @return gsonString, a Json object created from the DailyUpdate class. 
     */
    public String returnDailyUpdate(){
  		String qotd = "";
  		String author = "";
  		String topic = "";	
  		try {
  			resultSet = qb.selectFrom("dailyupdate").all().ExecuteQuery();
			while(resultSet.next()) {
				
				
				
				qotd = resultSet.getString("qotd");
				author = resultSet.getString("author");
				topic = resultSet.getString("topic");
				
			
				DU.setQotd(qotd);
				DU.setTopic(topic);
				DU.setAuthor(author);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
  		String gsonString = gson.toJson(DU);
		return gsonString;
  	}

}
