package calendartest;

import java.util.Comparator;

public class IntervalComparator implements Comparator<Process>
{

  public int compare(Process a, Process b)
  {
    if ( a.start_year < b.start_year ) {
      return 1;
    }
  else if ( (a).start_year > (b).start_year ) {
      //cout << "month 大, FALSE" << endl;
      return -1;
  }
  else if ( (a).start_month < (b).start_month ) {
      //cout << "month 小, TRUE" << endl;
      return 1;
  }
  else if ( (a).start_month > (b).start_month ) {
      //cout << "month 大, FALSE" << endl;
      return -1;
  }
  else if ( (a).start_day < (b).start_day )  {
      //cout << "day 小, TRUE" << endl;
      return 1;
  }
  else if ( (a).start_day > (b).start_day )  {
      //cout << "day 大, FALSE" << endl;
      return -1;
  }
  else if ( (a).start_hour < (b).start_hour )  {
      //cout << "hour 小, TRUE" << endl;
      return 1;
  }
  else if ( (a).start_hour > (b).start_hour )  {
      //cout << "hour 大, FALSE" << endl;
      return -1;
  }
  else if ( (a).start_minute < (b).start_minute )  {
      //cout << "minute 小, TRUE" << endl;
      return 1;
  }
  else if ( (a).start_minute > (b).start_minute )  {
      //cout << "minute 大, FALSE" << endl;
      return -1;
  }
  
  else {
      //cout << "second 大, FALSE" << endl;
      return -1;  
      }
  }


}
