package model.calendar;
 
import com.google.gson.Gson;
import model.Model;
import model.QueryBuild.QueryBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
 
/**
 * Created by jesperbruun on 13/10/14.
 */
public class GetCalendarData extends Model {
	
	QueryBuilder qb = new QueryBuilder(); 
 
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
    /**
     * Allows client to retrieve CBS's calendar and then access it.
     *
     * @throws Exception
     */
    public String getDataFromCalendar(String userName) throws Exception {
    	
    	try {
			resultSet = qb.selectFrom("users").where("email", "=", userName).ExecuteQuery();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
    	String updatedCbsEvents = "";
		try {
			while(resultSet.next())
			{
				updatedCbsEvents = resultSet.getString("UpdatedCbsEvents");
				
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		System.out.println("updatedCbsEvents: "+updatedCbsEvents);
		if (updatedCbsEvents.equals("notUpdated")){
			
			String updated = "Updated";
			String[] keys = {"UpdatedCbsEvents" };
   			String[] keys2 = {updated};
   			
   			try {
					qb.update("users", keys, keys2).where("email", "=", userName).Execute();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
    	EncryptUserID EU = new EncryptUserID();
        String key = EU.keyUdregner(userName);


       String json2;
		try {
			json2 = readUrl("http://calendar.cbs.dk/events.php/" + userName + "/" +key + ".json");
			
       Gson gson = new Gson();
       Events events = gson.fromJson(json2, Events.class);
       QueryBuilder queryBuilder = new QueryBuilder();

       String[] fields = {"ID", "activityID", "eventID", "type", "title", "description", "start", "end", "location", "note"};
       
  
       for (int i = 0; i <events.getEvents().size() ; i++) {
       	
           int monthStart = Integer.parseInt(events.getEvents().get(i).getStart().get(1)) + 1; //0 = år, 1 = måned, 2 = dag, 3 = timer, 4 = minutter
           String start = events.getEvents().get(i).getStart().get(0) + "-" +  monthStart + "-" +
                           events.getEvents().get(i).getStart().get(2) + " " +
                           events.getEvents().get(i).getStart().get(3) + ":" +
                           events.getEvents().get(i).getStart().get(4) + ":00";
           
           int monthEnd = Integer.parseInt(events.getEvents().get(i).getEnd().get(1)) + 1;
           String end = events.getEvents().get(i).getEnd().get(0) + "-" + monthEnd + "-" +
                           events.getEvents().get(i).getEnd().get(2) + " " +
                           events.getEvents().get(i).getEnd().get(3) + ":" +
                           events.getEvents().get(i).getEnd().get(4) + ":00";
        
           int ID = 1;
           String note = "";
           String[] values = {
           		Integer.toString(ID),
                   events.getEvents().get(i).getActivityid(),
                   events.getEvents().get(i).getEventid(),
                   events.getEvents().get(i).getType(),
                   events.getEvents().get(i).getTitle(),
                   events.getEvents().get(i).getDescription(),
                   start.toString(),
                   end.toString(),
                   events.getEvents().get(i).getLocation(),
                   note
           };
       queryBuilder.insertInto("events", fields).values(values).Execute();
       }
		} catch (Exception e) {
			
    }

		}
		
		Events events = new Events();
    	String returnEvents = events.EventOutput();
    	return returnEvents;
    }	
 
}