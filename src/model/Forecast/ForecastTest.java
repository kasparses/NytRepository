package model.Forecast;

import java.sql.SQLException;
import java.util.ArrayList;

import model.QueryBuild.QueryBuilder;

public class ForecastTest {

	// Main metode til at koere en test af vejrudsigt funktionen
    public static void main(String[] args) throws SQLException {

        ForecastModel fm = new ForecastModel();
        
        ArrayList<Forecast> forecastList = fm.requestForecast();
        
        QueryBuilder queryBuilder = new QueryBuilder();
        
        String[] fields = {"date", "celcius", "description"};
        
        for (int i = 0; i < forecastList.size(); i++) {
        	System.out.println(forecastList.get(i).toString());
        	
        	
        	
        	
        	 String[] values = {
                     forecastList.get(i).getDate(),
                     forecastList.get(i).getCelsius(),
                     forecastList.get(i).getDesc(),
                    
             };
         queryBuilder.insertInto("Forecast", fields).values(values).Execute();
         }
		}
       
    }




