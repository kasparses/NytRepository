package model.calendar;
 
import com.google.gson.Gson;
import model.QueryBuild.QueryBuilder;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
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
    public void getDataFromCalendar() throws Exception {
 
        /**
         * Get URL From calendar.cbs.dk -> Subscribe -> change URL to end with .json
         * Encrypt hash from
         */
 
 
        //tester events activityID's
        //for (int i = 0; i < events.getEvents().size(); i++){
        //    System.out.println(events.getEvents().get(i).getActivityid());
        //}
    }
 
    public static void main(String[] args) throws Exception {
 
        String json = readUrl("http://calendar.cbs.dk/events.php/" + EncryptUserID.getUserId() + "/" + EncryptUserID.getKey() + ".json");
//        String json = readUrl("http://calendar.cbs.dk/events.php/caha13ag/02a24d4e002e6e3571227c39e2f63784.json");
 
 
        Gson gson = new Gson();
        Events events = gson.fromJson(json, Events.class);
        QueryBuilder queryBuilder = new QueryBuilder();
 
        String[] fields = {"activity_id", "event_id", "location", "createdby", "start", "end", "title", "text", "customevent", "CalenderID"};
 
        Date dateStart, dateEnd;
        long time;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");
 
        for (int i = 0; i < 1; i++) {
 
            int monthStart = Integer.parseInt(events.getEvents().get(i).getStart().get(1)) + 1;
            String start =
                    events.getEvents().get(i).getStart().get(2) + "-" +
                            monthStart + "-" +
                            events.getEvents().get(i).getStart().get(0) + " " +
                            events.getEvents().get(i).getStart().get(3) + ":" +
                            events.getEvents().get(i).getStart().get(4);
            dateStart = formatter.parse(start);
 
            int monthEnd = Integer.parseInt(events.getEvents().get(i).getEnd().get(1)) + 1;
            String end =
                    events.getEvents().get(i).getEnd().get(2) + "-" +
                            monthEnd + "-" +
                            events.getEvents().get(i).getEnd().get(0) + " " +
                            events.getEvents().get(i).getEnd().get(3) + ":" +
                            events.getEvents().get(i).getEnd().get(4);
            dateEnd = formatter.parse(end);
 
            String[] values = {
                    events.getEvents().get(i).getActivityid(),  //Activity ID
                    events.getEvents().get(i).getEventid(),     //EventID
                    events.getEvents().get(i).getLocation(),    //Location
                    "1",                                        //CreatedBy
                    dateStart.toString(),                       //Start
                    dateEnd.toString(),                         //End
                    events.getEvents().get(i).getTitle(),       //Title
                    "Text - text",
                    "1",
                    "1",
            };
        queryBuilder.insertInto("events", fields).values(values).Execute();
        }
 
    }
 
}