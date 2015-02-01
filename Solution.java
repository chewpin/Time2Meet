package calendartest;

import java.util.ArrayList;
import java.util.Collections;


public class Solution 
{

  public static ArrayList<Process> merge(ArrayList<Process> intervals) {
    if (intervals == null || intervals.size() <= 1)
      return intervals;
    
    Collections.sort(intervals, new IntervalComparator());
    
    ArrayList<Process> result = new ArrayList<Process>();
        
    Process begin = intervals.get(0);
    for(int i = 1; i<intervals.size(); i++){
      Process curr = intervals.get(i);
      if(front(begin, curr)) {
        Process merge = new Process(begin.start_year, begin.start_month, begin.start_day, begin.start_hour, begin.start_minute,
           curr.start_year, curr.start_month, curr.start_day, curr.start_hour, curr.start_minute);
        begin = merge;
      }
      else{
        result.add(begin);
        begin = curr;
      }
    }
    return result;
  }
  
  public static ArrayList<Process> reverse(ArrayList<Process> intervals, Process limit){
    ArrayList<Process> result = new ArrayList<Process>();
    Process into = intervals.get(0);
    if(front(intervals.get(0), limit)&&(end_earlier(limit, intervals.get(0)))){
      return null;
    }
    else if(front(intervals.get(0), limit)&&(end_earlier(intervals.get(0),limit))){

      Process getin = new Process(into.end_year, into.end_month, into.end_day, into.end_hour,  into.end_minute, 
          limit.end_year, limit.end_month, limit.end_day, limit.end_hour, limit.end_minute);
      result.add(getin);

      if(intervals.size()!=1){
        for(int i = 1; i < intervals.size()-1; i++){
          into = new Process(intervals.get(i).end_year, intervals.get(i).end_month, intervals.get(i).end_day, intervals.get(i).end_hour,  intervals.get(i).end_minute, 
              intervals.get(i+1).end_year, intervals.get(i+1).end_month, intervals.get(i+1).end_day, intervals.get(i+1).end_hour, intervals.get(i+1).end_minute);
          result.add(into);
        }
      }
    }
    
    else if(front(limit, intervals.get(0))&&(end_earlier(intervals.get(0), limit))){

      Process getin = new Process(limit.start_year, limit.start_month, limit.start_day, limit.start_hour,  limit.start_minute, 
          into.start_year, into.start_month, into.start_day, into.start_hour, into.start_minute);
      result.add(getin);

      if(intervals.size()!=1){
        for(int i = 1; i < intervals.size()-1; i++){
          into = new Process(intervals.get(i).end_year, intervals.get(i).end_month, intervals.get(i).end_day, intervals.get(i).end_hour,  intervals.get(i).end_minute, 
              intervals.get(i+1).end_year, intervals.get(i+1).end_month, intervals.get(i+1).end_day, intervals.get(i+1).end_hour, intervals.get(i+1).end_minute);
          result.add(into);
        }
      }
      Process last = intervals.get(intervals.size()-1);
      getin = new Process(last.end_year, last.end_month, last.end_day, last.end_hour,  last.end_minute, 
          limit.end_year, limit.end_month, limit.end_day, limit.end_hour, limit.end_minute);
      result.add(getin);
    }
    else{
      Process getin = new Process(limit.start_year, limit.start_month, limit.start_day, limit.start_hour,  limit.start_minute, 
          into.start_year, into.start_month, into.start_day, into.start_hour, into.start_minute);
      result.add(getin);

      if(intervals.size()!=1){
        for(int i = 1; i < intervals.size()-1; i++){
          into = new Process(intervals.get(i).end_year, intervals.get(i).end_month, intervals.get(i).end_day, intervals.get(i).end_hour,  intervals.get(i).end_minute, 
              intervals.get(i+1).end_year, intervals.get(i+1).end_month, intervals.get(i+1).end_day, intervals.get(i+1).end_hour, intervals.get(i+1).end_minute);
          result.add(into);
        }
      }
    }
    return result;
  }
  
  static boolean end_earlier( Process a, Process b){ // b: time_stamp
    if ( (a).end_year < (b).end_year ) {
        //cout << "year 小, TRUE" << endl;
        return true;
    }
    else if ( (a).end_year > (b).end_year ) {
        //cout << "month 大, FALSE" << endl;
        return false;
    }
    else if ( (a).end_month < (b).end_month ) {
        //cout << "month 小, TRUE" << endl;
        return true;
    }
    else if ( (a).end_month > (b).end_month ) {
        //cout << "month 大, FALSE" << endl;
        return false;
    }
    else if ( (a).end_day < (b).end_day )  {
        //cout << "day 小, TRUE" << endl;
        return true;
    }
    else if ( (a).end_day > (b).end_day )  {
        //cout << "day 大, FALSE" << endl;
        return false;
    }
    else if ( (a).end_hour < (b).end_hour )  {
        //cout << "hour 小, TRUE" << endl;
        return true;
    }
    else if ( (a).end_hour > (b).end_hour )  {
        //cout << "hour 大, FALSE" << endl;
        return false;
    }
    else if ( (a).end_minute < (b).end_minute )  {
        //cout << "minute 小, TRUE" << endl;
        return true;
    }
    else if ( (a).end_minute > (b).end_minute )  {
        //cout << "minute 大, FALSE" << endl;
        return false;
    }
    else {
        //cout << "second 大, FALSE" << endl;
        return false;  }
  }
  
  static boolean front( Process a, Process b) {
    if ( (a).start_year < (b).start_year ) {
        //cout << "year 小, TRUE" << endl;
        return true;
    }
    else if ( (a).start_year > (b).start_year ) {
        //cout << "month 大, FALSE" << endl;
        return false;
    }
    else if ( (a).start_month < (b).start_month ) {
        //cout << "month 小, TRUE" << endl;
        return true;
    }
    else if ( (a).start_month > (b).start_month ) {
        //cout << "month 大, FALSE" << endl;
        return false;
    }
    else if ( (a).start_day < (b).start_day )  {
        //cout << "day 小, TRUE" << endl;
        return true;
    }
    else if ( (a).start_day > (b).start_day )  {
        //cout << "day 大, FALSE" << endl;
        return false;
    }
    else if ( (a).start_hour < (b).start_hour )  {
        //cout << "hour 小, TRUE" << endl;
        return true;
    }
    else if ( (a).start_hour > (b).start_hour )  {
        //cout << "hour 大, FALSE" << endl;
        return false;
    }
    else if ( (a).start_minute < (b).start_minute )  {
        //cout << "minute 小, TRUE" << endl;
        return true;
    }
    
    else {
        //cout << "second 大, FALSE" << endl;
        return false;  }
}
}

