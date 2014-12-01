package model.DailyUpdate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import JsonClasses.DailyUpdate;
import model.Forecast.Forecast;
import model.Forecast.ForecastModel;
import model.QueryBuild.QueryBuilder;


public class DailyUpdateController {
QueryBuilder qb = new QueryBuilder();
DailyUpdate DU = new DailyUpdate();
Gson gson = new GsonBuilder().create();
    
    private ResultSet resultSet;
    
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
	     	System.out.println("timeSinceUpdate: "+timeSinceUpdate);
	     	double daysPassed = timeSinceUpdate / 86400000;
	     	System.out.println("daysPassed: "+daysPassed);
	     	int days = (int)daysPassed;
	     	System.out.println("days: "+days);     	
	     	// if more than 1 hour ago, do update
	     	if(days >= 1){
	     	
	     		// return fresh weather data
	     		QOTDModel qotdModel = new QOTDModel();		
	     		
	     		qotdModel.saveQuote(lastUpdateTime, days);	
	     	}
	     	String answer = returnDailyUpdate();
			return answer; 
	     }
    
    public String returnDailyUpdate(){
    	String date = "";
    	String apparentTemperature = "";
    	String summary = "";
  		String qotd = "";
  		String author = "";
  		String topic = "";	
  		try {
  			resultSet = qb.selectFrom("dailyupdate").all().ExecuteQuery();
			while(resultSet.next()) {
				
				
				summary = resultSet.getString("summary");
				qotd = resultSet.getString("qotd");
				author = resultSet.getString("author");
				topic = resultSet.getString("topic");
				
				DU.setSummary(summary);
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
