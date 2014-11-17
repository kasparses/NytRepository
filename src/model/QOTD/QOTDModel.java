package model.QOTD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.QueryBuild.QueryBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import JsonClasses.DailyUpdate;

public class QOTDModel {
	DailyUpdate DU = new DailyUpdate();

	private ArrayList<QOTD> qotdlist = new ArrayList<>();
	
	QOTD qotdlist2 = new QOTD(null, null, null);
	QueryBuilder qb = new QueryBuilder();
    
    private ResultSet resultSet;
    
    /**
     *
     */ 
    
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
//    public static void main(String []args) {
    	
    	QueryBuilder qb = new QueryBuilder();
            /**
             * getting text from website and putiing into string
             * Making a new object of JSON, and prints out quote
             */
            String json;
			try {
				int days * 
				json = readUrl("http://dist-sso.it-kartellet.dk/quote/");
			           
    			JSONParser jsonParser = new JSONParser();
    			JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
    			
    			String quote = (String) jsonObject.get("quote");
    			String author = (String) jsonObject.get("author");
    			String topic = (String) jsonObject.get("topic");
    			System.out.println("quote:"+quote);
    			System.out.println("author:"+author);
    			System.out.println("topic:"+topic);

    			String[] keys = {"qotd", ",author", ",topic" };
    			String[] keys2 = {quote, author, topic };
    			
    			qb.update("dailyupdate", keys, keys2).where("msg_type", "=", "hej").Execute();
    			
			} catch (Exception e) {
				e.printStackTrace();
			}			
    }
     
    /**
     * Retrieve Quote from a website and put it into a String, 
     * Afterwards we will make it into a json object so it can be printed out to the client.
     */
  	public Object getQuote(){
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
		return DU;
  	}
  	
 
  	 public Object updateQuote(String userName){
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
	     	long date1 = date.getTime(); //getTime method show how many milliseconds that have passed since January 1 1970 00:00:00
	     	long date2 = date.getTime() - maxTimeNoUpdate; // minus 1 hour -- should be fetched from database
	     	long timeSinceUpdate = date1 - lastUpdateTime; 
	     	System.out.println("timeSinceUpdate: "+timeSinceUpdate);
	      	
	     	// if more than 1 hour ago, do update
	     	if(timeSinceUpdate > 864000){
	     		// return fresh weather data
	     		saveQuote();	
	     	}
			return noReturn; 
	     }
  	
}
