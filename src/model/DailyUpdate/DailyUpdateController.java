package model.DailyUpdate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import JsonClasses.DailyUpdate;
import model.Forecast.Forecast;
import model.Forecast.ForecastModel;
import model.QueryBuild.QueryBuilder;


public class DailyUpdateController {
QueryBuilder qb = new QueryBuilder();
DailyUpdate DU = new DailyUpdate();
    
    private ResultSet resultSet;
    
    public Object dailyUpdate(){
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
	     		ForecastModel fm = new ForecastModel();   
	     		
	             ArrayList<Forecast> forecastList = fm.requestForecast();

	             			int i = 0; 
	                      String forecastDate =  forecastList.get(i).getDate();
	                      String forecastCelsius =  forecastList.get(i).getCelsius();
	                      String forecastDesc =  forecastList.get(i).getDesc();
	                         
	                    String[] keys = {"date", ",apparentTemperature", ",summary" };
	          			String[] keys2 = {forecastDate, forecastCelsius, forecastDesc,};
	          			
	          			try {
							qb.update("dailyupdate", keys, keys2).where("msg_type", "=", "hej").Execute();
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
	              

	     		qotdModel.saveQuote(lastUpdateTime, days);	
	     	}
	     	Object answer = returnDailyUpdate();
			return answer; 
	     }
    
    public Object returnDailyUpdate(){
    	String date = "";
    	String apparentTemperature = "";
    	String summary = "";
  		String qotd = "";
  		String author = "";
  		String topic = "";	
  		try {
  			resultSet = qb.selectFrom("dailyupdate").all().ExecuteQuery();
			while(resultSet.next()) {
				date = resultSet.getString("date");
				apparentTemperature = resultSet.getString("apparentTemperature");
				summary = resultSet.getString("summary");
				qotd = resultSet.getString("qotd");
				author = resultSet.getString("author");
				topic = resultSet.getString("topic");
				
				DU.setDate(date);
				DU.setApparentTemperature(apparentTemperature);
				DU.setSummary(summary);
				DU.setQotd(qotd);
				DU.setTopic(topic);
				DU.setAuthor(author);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DU;
  	}

}
