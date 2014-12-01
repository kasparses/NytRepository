package model.Forecast;

import java.sql.SQLException;
import java.util.ArrayList;
import model.QueryBuild.QueryBuilder;

public class ForecastTest {

	// Main metode til at koere en test af vejrudsigt funktionen
	public String getForeCastFromDatabase() {

		ForecastModel fm = new ForecastModel();

		ArrayList<Forecast> forecastList = fm.requestForecast();

		QueryBuilder queryBuilder = new QueryBuilder();

		for (int i = 0; i < forecastList.size(); i++) {
			System.out.println(forecastList.get(i).toString());

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

