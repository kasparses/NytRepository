package model.Forecast;

import java.sql.SQLException;
import java.util.ArrayList;
import model.QueryBuild.QueryBuilder;

public class ForecastTest {

	
	/**
	 * This method calls the method requestForecast from the class ForecastModel which gets the forecast information from the openweathermap api.
	 * afterwards it insets the forecast information into the database and calls the ForecastOutput method from the forecasts class which extracts the 
	 * forecast information from the database.
	 * @return String returnForecast, a JsonString of an ArrayList containing the forecast information. 
	 */
	public String getForeCastFromDatabase() {

		ForecastModel fm = new ForecastModel();

		ArrayList<Forecast> forecastList = fm.requestForecast();

		QueryBuilder queryBuilder = new QueryBuilder();

		for (int i = 0; i < forecastList.size(); i++) {

			String[] keys = {"date", ",celcius", ",description"};

			String[] values = {
					forecastList.get(i).getDate(),
					forecastList.get(i).getCelsius(),
					forecastList.get(i).getDesc(),

			};
			try {
				queryBuilder.update("forecast", keys, values).where("count", "=", Integer.toString(i)).Execute();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		Forecasts forecasts = new Forecasts();
		String returnForecast = forecasts.ForecastOutput();
		return returnForecast;
	}

}

