package model.Forecast;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.QueryBuild.QueryBuilder;

/**
 * Created by jesperbruun on 10/10/14.
 * Den laver selve arrayet af alle generede Event
 */
public class Forecasts {
	Gson gson = new GsonBuilder().create();
    ArrayList<Forecast> forecasts = new ArrayList<Forecast>();

    public ArrayList<Forecast> getForecasts() {
    	
    	
    	return forecasts;
    }
    
    public String ForecastOutput(){
    	QueryBuilder qb = new QueryBuilder();
    	try {
			ResultSet rs = qb.selectFrom("forecast").all().ExecuteQuery();
			while (rs.next())
			{
				
//				int forecastID = rs.getInt("ForecastID");
				String date = rs.getString("date");
				String celcius = rs.getString("celcius");
				String description = rs.getString("description");
//				String count = rs.getString("count");
				
				
//				String stringForecastID = String.valueOf(forecastID);				
				
				forecasts.add(new Forecast(date, celcius, description));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    	
    	String gsonString = gson.toJson(forecasts);
    	
		return gsonString;
		
    }
    
   
    
    
    // Konverterer array events til en tekst streng
  
   
}