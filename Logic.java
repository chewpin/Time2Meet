package calendartest;

public class Logic 
{
  private static int numCandidate = 0;
  private static int startYear = 2015;
  private static int startMonth = 0;
  private static int startDay = 0;
  private static int startHour = 0;
  private static int startMinute = 0;
  private static int endYear = 2015;
  private static int endMonth = 0;
  private static int endDay = 0;
  private static int endHour = 0;
  private static int endMinute = 0;
  
  public static void setCandidate(int inCandidate)
  {
    numCandidate = inCandidate;
  }
  
  public static int getCandidate()
  {
    return numCandidate;
  }
  
  public static void setStartTime(int inYear, int inMonth, int inDay, int inHour, int inMinute)
  {
    startYear = inYear;
    startMonth = inMonth;
    startDay = inDay;
    startHour = inHour;
    startMinute = inMinute;
  }
  
  public static void setEndTime(int inYear, int inMonth, int inDay, int inHour, int inMinute)
  {
    endYear = inYear;
    endMonth = inMonth;
    endDay = inDay;
    endHour = inHour;
    endMinute = inMinute;
  }
  
  public static String getStartYear()
  {
    return Integer.toString(startYear);
  }
  
  public static String getStartMonth()
  {
    return Integer.toString(startMonth);
  }
  
  public static String getStartDay()
  {
    return Integer.toString(startDay);
  }
  
  public static String getStartHour()
  {
    return Integer.toString(startHour);
  }
  
  public static String getStartMinute()
  {
    return Integer.toString(startMinute);
  }
  
  public static String getEndYear()
  {
    return Integer.toString(endYear);
  }
  
  public static String getEndMonth()
  {
    return Integer.toString(endMonth);
  }
  
  public static String getEndDay()
  {
    return Integer.toString(endDay);
  }
  
  public static String getEndHour()
  {
    return Integer.toString(endHour);
  }
  
  public static String getEndMinute()
  {
    return Integer.toString(endMinute);
  }
}
