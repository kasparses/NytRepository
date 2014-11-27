package model.calendar;
 
import com.google.gson.Gson;

import model.QueryBuild.QueryBuilder;
 



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
 
/**
 * Created by jesperbruun on 13/10/14.
 */
public class GetCalendarData {
 
    //henter data fra URL og l??er ind til en string
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
    //Nu har vi alle data liggende i en string (JSON). 
    //Saa bruger vi Google's udviklede library Json string. den kan lave det om til java objekter
    //Events laver en arraylist af Event
 
    /**
     * Allows client to retrieve CBS's calendar and then access it.
     *
     * @throws Exception
     */
    public String getDataFromCalendar(String userName) throws Exception {
    	
//    	EncryptUserID EU = new EncryptUserID();
//        String key = EU.keyUdregner(userName);
////        System.out.println(key);
//
//       String json = "";
//		try {
//			json = readUrl("http://calendar.cbs.dk/events.php/" + userName + "/" +key + ".json");
//		} catch (Exception e) {
//			
//			
//		}
//		return json;
//    	
//        /**
//         * Get URL From calendar.cbs.dk -> Subscribe -> change URL to end with .json
//         * Encrypt hash from
//         */
    	
    	Events events = new Events();
    	String returnEvents = events.EventOutput();
    	return returnEvents;
 
 
        //tester events activityID's
        //for (int i = 0; i < events.getEvents().size(); i++){
        //    System.out.println(events.getEvents().get(i).getActivityid());
        //}
    }
 
    public static void main(String[] args) {
    	 EncryptUserID EU = new EncryptUserID();
    	 String userName = "kabj13ab";
         String key = EU.keyUdregner(userName);

 
        String json2;
		try {
			json2 = readUrl("http://calendar.cbs.dk/events.php/" + userName + "/" +key + ".json");

        System.out.println(json2);
        Gson gson = new Gson();
        Events events = gson.fromJson(json2, Events.class);
        QueryBuilder queryBuilder = new QueryBuilder();
 
        String[] fields = {"ID", "activityID", "eventID", "type", "title", "description", "start", "end", "location"};
        
        System.out.println(events.getEvents().size());
        for (int i = 0; i <events.getEvents().size() ; i++) {
        	
 
            int monthStart = Integer.parseInt(events.getEvents().get(i).getStart().get(1)) + 1; //0 = år, 1 = måned, 2 = dag, 3 = timer, 4 = minutter
            String start = events.getEvents().get(i).getStart().get(0) + "-" +  monthStart + "-" +
                            events.getEvents().get(i).getStart().get(2) + " " +
                            events.getEvents().get(i).getStart().get(3) + ":" +
                            events.getEvents().get(i).getStart().get(4) + ":00";
            
            //dateStart = formatter.parse(start);
 
            int monthEnd = Integer.parseInt(events.getEvents().get(i).getEnd().get(1)) + 1;
            String end = events.getEvents().get(i).getEnd().get(0) + "-" + monthEnd + "-" +
                            events.getEvents().get(i).getEnd().get(2) + " " +
                            events.getEvents().get(i).getEnd().get(3) + ":" +
                            events.getEvents().get(i).getEnd().get(4) + ":00";
            
            
            int ID = 1;
            //dateEnd = formatter.parse(end);
 
            String[] values = {
            		Integer.toString(ID),
                    events.getEvents().get(i).getActivityid(),
                    events.getEvents().get(i).getEventid(),
                    events.getEvents().get(i).getType(),
                    events.getEvents().get(i).getTitle(),
                    events.getEvents().get(i).getDescription(),
                    start.toString(),
                    end.toString(),
                    events.getEvents().get(i).getLocation()
            };
        queryBuilder.insertInto("events", fields).values(values).Execute();
        }
		} catch (Exception e) {
			System.out.println(e);
			
		}
    	
    	Events events = new Events();
    	events.EventOutput();
		
    }
		
 
}