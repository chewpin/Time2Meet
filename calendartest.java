package calendartest;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar.Events;
import com.google.api.services.calendar.Calendar.Events.List;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

public class calendartest{
  
  private static String authorizationURL;
  private static HttpTransport httpTransport;
  private static JacksonFactory jsonFactory;
  private static String clientID;
  private static String clientsecret;
  private static String redirectUrl;
  private static GoogleAuthorizationCodeFlow flow;
  private static String startyear;
  private static String endyear;
  private static String startmonth;
  private static String endmonth;
  private static String startday; 
  private static String endday;
  private static String starthour;
  private static String endhour;
  private static String startminute;
  private static String endminute;
  
  public static String getEndminute()
  {
    return endminute;
  }

  public static void setEndminute(String edminute)
  {
    endminute = edminute;
  }

  public static String getStartminute()
  {
    return startminute;
  }

  public static void setStartminute(String stminute)
  {
    startminute = stminute;
  }

  public static String getEndhour()
  {
    return endhour;
  }

  public static void setEndhour(String edhour)
  {
    endhour = edhour;
  }

  public static String getStarthour()
  {
    return starthour;
  }

  public static void setStarthour(String sthour)
  {
    starthour = sthour;
  }

  public static String getEndday()
  {
    return endday;
  }

  public static void setEndday(String eday)
  {
    endday = eday;
  }

  public static String getStartday()
  {
    return startday;
  }

  public static void setStartday(String stday)
  {
    startday = stday;
  }

  public static String getEndmonth()
  {
    return endmonth;
  }

  public static void setEndmonth(String edmonth)
  {
    endmonth = edmonth;
  }

  public static String getStartmonth()
  {
    return startmonth;
  }

  public static void setStartmonth(String stmonth)
  {
    startmonth = stmonth;
  }

  public static String getEndyear()
  {
    return endyear;
  }

  public static void setEndyear(String edyear)
  {
    endyear = edyear;
  }

  public static String getStartyear()
  {
    return startyear;
  }

  public static void setStartyear(String styear)
  {
    startyear = styear;
  }

  public static String getClientsecret()
  {
    return clientsecret;
  }

  public static void setClientsecret(String clientsecret)
  {
    calendartest.clientsecret = clientsecret;
  }

  public static String getClientID()
  {
    return clientID;
  }

  public static void setClientID(String clientID)
  {
    calendartest.clientID = clientID;
  }

  public static void sethttp(HttpTransport http){
    calendartest.httpTransport = http;
  }
  
  public static HttpTransport HttpTransport(){
    return httpTransport;
  }
  
  public static void setjson(JacksonFactory json){
    calendartest.jsonFactory = json;
  }
  
  public static JacksonFactory getjson(){
    return jsonFactory;
  }
  
  public static void setURL(String URL){
    calendartest.authorizationURL = URL;
  }
  
  public static String getURL(){
    return authorizationURL;
  }
  
  public static void set() throws GeneralSecurityException, IOException{
    sethttp(GoogleNetHttpTransport.newTrustedTransport());
    setjson(JacksonFactory.getDefaultInstance());
    
    // The clientId and clientSecret can be found in Google Developers Console
    setClientID("388598075638-t3ldfvgk0cbkn1uoqpustm6o9v6igcvj.apps.googleusercontent.com");
    setClientsecret("LKzH6QgfK2ZBEdLPQdixoKNY");

    // Or your redirect URL for web based applications.
    redirectUrl = "urn:ietf:wg:oauth:2.0:oob";
    String scope = "https://www.googleapis.com/auth/calendar";

    flow = new GoogleAuthorizationCodeFlow(
        httpTransport, jsonFactory, clientID, clientsecret, Collections.singleton(scope));
    // Step 1: Authorize
    String authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(redirectUrl).build();
    setURL(authorizationUrl);
    System.out.println("Go to the following link in your browser:");
    System.out.println(authorizationUrl);
    
  }

  public static ArrayList<Process> setUp(int number) throws IOException, GeneralSecurityException {

    String pageToken = null;
    boolean onlyone = false;
    String timezone = null;
    
    ArrayList<Process> result = new ArrayList<Process>();
    ArrayList<Process> answer = new ArrayList<Process>();
    
    for(int i = 0; i < number; i++){
      
      

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("What is the authorization code?");
      System.out.println(AccountWindow.codes[i]);
      String code = AccountWindow.codes[i];

      //AccountWindow.codes[i];
      GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(redirectUrl)
        .execute();

      Credential credential = new GoogleCredential.Builder()
        .setTransport(httpTransport)
        .setJsonFactory(jsonFactory)
        .setClientSecrets(clientID, clientsecret)
        .build().setFromTokenResponse(response);

      Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credential)
        .setApplicationName("Calendar").build();
      Process into = new Process(0,0,0,0,0,0,0,0,0,0);
      Process defaultresult = new Process(2015, Integer.valueOf(getStartmonth()), Integer.valueOf(getStartday())
          , Integer.valueOf(getStarthour()), Integer.valueOf(getStartminute()), 2015, Integer.valueOf(getEndmonth())
          , Integer.valueOf(getEndday()), Integer.valueOf(getEndhour()), Integer.valueOf(getEndminute()));
      
      DateTime mintime = new DateTime( getStartyear()+"-"+getStartmonth() + "-" + getStartday() + "T" +  getStarthour() + ":" + getStartminute()+ ":00-04:00");
      DateTime maxtime = new DateTime( getEndyear()+"-"+getEndmonth() + "-" + getEndday() + "T" +  getEndhour() + ":" + getEndminute()+ ":00-04:00");  
      System.out.println(mintime.toString());
      System.out.println(maxtime.toString());

      do {
        com.google.api.services.calendar.model.Events events = service.events().list("primary").setTimeMin(mintime).setTimeMax(maxtime).execute();
        
        java.util.List<Event> items = events.getItems();
        if(items.isEmpty()){
          onlyone  = true;
          break;
        }
        
        for (Event event : items) {
          
          into.start_year = Integer.valueOf( event.getStart().toString().substring(13, 17));
          into.start_month = Integer.valueOf( event.getStart().toString().substring(18, 20));
          into.start_day = Integer.valueOf( event.getStart().toString().substring(21, 23) );
          into.start_hour = Integer.valueOf( event.getStart().toString().substring(24, 26) );
          into.start_minute = Integer.valueOf( event.getStart().toString().substring(27, 29) );
          
          into.end_year = Integer.valueOf( event.getEnd().toString().substring(13, 17));
          into.end_month = Integer.valueOf( event.getEnd().toString().substring(18, 20) );
          into.end_day = Integer.valueOf( event.getEnd().toString().substring(21, 23) );
          into.end_hour = Integer.valueOf( event.getEnd().toString().substring(24, 26) );
          into.end_minute = Integer.valueOf( event.getEnd().toString().substring(27, 29) );
        }
        result.add(into);
        pageToken = events.getNextPageToken();
      } 
      while (pageToken != null);
    }
    answer = Solution.merge(result);
    Process defaultresult = new Process(2015, Integer.valueOf(getStartmonth()), Integer.valueOf(getStartday())
        , Integer.valueOf(getStarthour()), Integer.valueOf(getStartminute()), 2015, Integer.valueOf(getEndmonth())
        , Integer.valueOf(getEndday()), Integer.valueOf(getEndhour()), Integer.valueOf(getEndminute()));
    ArrayList<Process> finalanswer = new ArrayList<Process>();
    if(onlyone) finalanswer.add(defaultresult);
    else  finalanswer = Solution.reverse(answer, defaultresult);
    return finalanswer;
  }
}
