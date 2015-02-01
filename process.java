package calendartest;

import java.util.Comparator;
import java.util.Vector;

class Process{
  String start_time;
  String end_time;
  int start_year;
  int start_month;
  int start_day;
  int start_hour;
  int start_minute;
  int end_year;
  int end_month;
  int end_day;
  int end_hour;
  int end_minute;
  
  Process(int s1, int s2, int s3, int s4, int s5, int e1, int e2, int e3, int e4, int e5){
    start_year = s1;
    start_month = s2;
    start_day = s3; 
    start_hour = s4;
    start_minute = s5;
    end_year = e1;
    end_hour = e2;
    end_day = e3;
    end_hour = e4;
    end_minute = e5;
  }
}
