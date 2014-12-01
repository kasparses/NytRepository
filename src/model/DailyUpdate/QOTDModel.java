package model.DailyUpdate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.QueryBuild.QueryBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import JsonClasses.DailyUpdate;

public class QOTDModel {
	DailyUpdate DU = new DailyUpdate();

	QueryBuilder qb = new QueryBuilder();
    
    private ResultSet resultSet;
    
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
 
    }
    
     	public void saveQuote(long lastUpdateTime, int days) {
    	
    	QueryBuilder qb = new QueryBuilder();
            /**
             * getting text from website and putiing into string
             * Making a new object of JSON, and prints out quote
             */
            String json;
			try {
				int daysToMilliSeconds = days*86400000;
				long newUpdateTime = daysToMilliSeconds+ lastUpdateTime;
				json = readUrl("http://dist-sso.it-kartellet.dk/quote/");
			           
    			JSONParser jsonParser = new JSONParser();
    			JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
    			
    			String quote = (String) jsonObject.get("quote");
    			String author = (String) jsonObject.get("author");
    			String topic = (String) jsonObject.get("topic");

    			String[] keys = {"qotd", ",author", ",topic", ",LastUpdateTime" };
    			String[] keys2 = {quote, author, topic, Long.toString(newUpdateTime)};
    			
    			qb.update("dailyupdate", keys, keys2).where("msg_type", "=", "hej").Execute();
    			
			} catch (Exception e) {
				e.printStackTrace();
			}			
    }
     
   
}
