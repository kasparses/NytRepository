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
	
	/**
	 * This method extracts the forecast information from the database and adds it to an the ArrayList forecasts of the class Forecast.
	 * @return forecasts, the ArrayList containing the forecast information
	 */
	public String ForecastOutput(){
		QueryBuilder qb = new QueryBuilder();
		try {
			ResultSet rs = qb.selectFrom("forecast").all().ExecuteQuery();
			while (rs.next())
			{

				String date = rs.getString("date");
				String celcius = rs.getString("celcius");
				String description = rs.getString("description");					
				forecasts.add(new Forecast(date, celcius, description));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		String gsonString = gson.toJson(forecasts); 	
		return gsonString;

	}



}