package calendartest;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class ResultPage extends JFrame
{
  
  private JPanel P1;
  private JPanel P2;
  private JPanel P3;
  private JPanel P4;
  private JPanel P5;
  private JPanel P6;
  
  private JLabel L1;
  private JLabel L2;
  private JLabel L3;
  private JLabel L4;
  private JLabel L5;
  private JLabel L6;
  
  private int [] startYear;
  private int [] startMonth;
  private int [] startDay;
  private int [] startHour;
  private int [] startMinute;
  
  private int [] endYear;
  private int [] endMonth;
  private int [] endDay;
  private int [] endHour;
  private int [] endMinute;
  
  private int timeNum = 1;
  
  
  
  public ResultPage()
  {
    super("Result");
    Process aha = AccountWindow.finalresult.get(0);
    P1 = new JPanel();
    P1.add(new JLabel(String.valueOf(aha.start_year)+"/"+String.valueOf(aha.start_month)+"/"+String.valueOf(aha.start_day)
        +String.valueOf(aha.start_hour)+String.valueOf(aha.start_minute)+"-"+String.valueOf(aha.end_year)+"/"+String.valueOf(aha.end_month)+"/"
        +String.valueOf(aha.end_day)
        +String.valueOf(aha.end_hour)+String.valueOf(aha.end_minute) , JLabel.CENTER));
    

    startYear = new int[6];
    startMonth = new int[6];
    startDay = new int[6];
    startHour = new int[6];
    startMinute = new int[6];
    
    endYear = new int[6];
    endMonth = new int[6];
    endDay = new int[6];
    endHour = new int[6];
    endMinute = new int[6];
    
    for(int i = 0; i < AccountWindow.finalresult.size(); i++){
      
    }
    // update timeNum here
    //
    // update all arrays here
    //
    
    for (int i = 0; i < Integer.min(AccountWindow.finalresult.size(), 6); i++)
    {
      startYear[i] = 2015;
      endYear[i] = 2015;
      startMonth[i] = AccountWindow.finalresult.get(i).start_month;
      endMonth[i] = AccountWindow.finalresult.get(i).end_month;
      startDay[i] = AccountWindow.finalresult.get(i).start_day;
      endDay[i] = AccountWindow.finalresult.get(i).end_day;
      startHour[i] = AccountWindow.finalresult.get(i).start_hour;
      endHour[i] = AccountWindow.finalresult.get(i).end_hour;
      startMinute[i] = AccountWindow.finalresult.get(i).start_minute;
      endMinute[i] = AccountWindow.finalresult.get(i).start_minute;
    }
    
    if (timeNum == 0)
    {
      P1 = new JPanel(new BorderLayout());
      P1.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P2 = new JPanel(new BorderLayout());
      P2.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P3 = new JPanel(new BorderLayout());
      P3.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P4 = new JPanel(new BorderLayout());
      P4.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P5 = new JPanel(new BorderLayout());
      P5.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P6 = new JPanel(new BorderLayout());
      P6.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P6.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
    }
    else if (timeNum == 1)
    {
      P1 = new JPanel(new GridLayout(3,1));
      P1.add(new JLabel(String.valueOf(startMonth[0]) + "." + String.valueOf(startDay[0]) + "." + String.valueOf(startYear[0]), JLabel.CENTER));
      P1.add(new JLabel("to", JLabel.CENTER));
      P1.add(new JLabel(String.valueOf(endMonth[0]) + "." + String.valueOf(endDay[0]) + "." + String.valueOf(endYear[0]), JLabel.CENTER));
      
      
      P2 = new JPanel(new BorderLayout());
      P2.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P3 = new JPanel(new BorderLayout());
      P3.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P4 = new JPanel(new BorderLayout());
      P4.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P5 = new JPanel(new BorderLayout());
      P5.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P6 = new JPanel(new BorderLayout());
      P6.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P6.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
    }
    else if (timeNum == 2)
    {
      P1 = new JPanel(new GridLayout(3,1));
      P1.add(new JLabel(String.valueOf(startMonth[0]) + "." + String.valueOf(startDay[0]) + "." + String.valueOf(startYear[0]), JLabel.CENTER));
      P1.add(new JLabel("to", JLabel.CENTER));
      P1.add(new JLabel(String.valueOf(endMonth[0]) + "." + String.valueOf(endDay[0]) + "." + String.valueOf(endYear[0]), JLabel.CENTER));
      P2 = new JPanel(new GridLayout(3,1));
      P2.add(new JLabel(String.valueOf(startMonth[1]) + "." + String.valueOf(startDay[1]) + "." + String.valueOf(startYear[1]), JLabel.CENTER));
      P2.add(new JLabel("to", JLabel.CENTER));
      P2.add(new JLabel(String.valueOf(endMonth[1]) + "." + String.valueOf(endDay[1]) + "." + String.valueOf(endYear[1]), JLabel.CENTER));
      
   
      P3 = new JPanel(new BorderLayout());
      P3.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P4 = new JPanel(new BorderLayout());
      P4.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P5 = new JPanel(new BorderLayout());
      P5.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P6 = new JPanel(new BorderLayout());
      P6.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P6.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
    }
    else if (timeNum == 3)
    {
      P1 = new JPanel(new GridLayout(3,1));
      P1.add(new JLabel(String.valueOf(startMonth[0]) + "." + String.valueOf(startDay[0]) + "." + String.valueOf(startYear[0]), JLabel.CENTER));
      P1.add(new JLabel("to", JLabel.CENTER));
      P1.add(new JLabel(String.valueOf(endMonth[0]) + "." + String.valueOf(endDay[0]) + "." + String.valueOf(endYear[0]), JLabel.CENTER));
      P2 = new JPanel(new GridLayout(3,1));
      P2.add(new JLabel(String.valueOf(startMonth[1]) + "." + String.valueOf(startDay[1]) + "." + String.valueOf(startYear[1]), JLabel.CENTER));
      P2.add(new JLabel("to", JLabel.CENTER));
      P2.add(new JLabel(String.valueOf(endMonth[1]) + "." + String.valueOf(endDay[1]) + "." + String.valueOf(endYear[1]), JLabel.CENTER));
      P3 = new JPanel(new GridLayout(3,1));
      P3.add(new JLabel(String.valueOf(startMonth[2]) + "." + String.valueOf(startDay[2]) + "." + String.valueOf(startYear[2]), JLabel.CENTER));
      P3.add(new JLabel("to", JLabel.CENTER));
      P3.add(new JLabel(String.valueOf(endMonth[2]) + "." + String.valueOf(endDay[2]) + "." + String.valueOf(endYear[2]), JLabel.CENTER));
   

      P4 = new JPanel(new BorderLayout());
      P4.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P5 = new JPanel(new BorderLayout());
      P5.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P6 = new JPanel(new BorderLayout());
      P6.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P6.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
    }
    else if (timeNum == 4)
    {
      P1 = new JPanel(new GridLayout(3,1));
      P1.add(new JLabel(String.valueOf(startMonth[0]) + "." + String.valueOf(startDay[0]) + "." + String.valueOf(startYear[0]), JLabel.CENTER));
      P1.add(new JLabel("to", JLabel.CENTER));
      P1.add(new JLabel(String.valueOf(endMonth[0]) + "." + String.valueOf(endDay[0]) + "." + String.valueOf(endYear[0]), JLabel.CENTER));
      P2 = new JPanel(new GridLayout(3,1));
      P2.add(new JLabel(String.valueOf(startMonth[1]) + "." + String.valueOf(startDay[1]) + "." + String.valueOf(startYear[1]), JLabel.CENTER));
      P2.add(new JLabel("to", JLabel.CENTER));
      P2.add(new JLabel(String.valueOf(endMonth[1]) + "." + String.valueOf(endDay[1]) + "." + String.valueOf(endYear[1]), JLabel.CENTER));
      P3 = new JPanel(new GridLayout(3,1));
      P3.add(new JLabel(String.valueOf(startMonth[2]) + "." + String.valueOf(startDay[2]) + "." + String.valueOf(startYear[2]), JLabel.CENTER));
      P3.add(new JLabel("to", JLabel.CENTER));
      P3.add(new JLabel(String.valueOf(endMonth[2]) + "." + String.valueOf(endDay[2]) + "." + String.valueOf(endYear[2]), JLabel.CENTER));
      P4 = new JPanel(new GridLayout(3,1));
      P4.add(new JLabel(String.valueOf(startMonth[3]) + "." + String.valueOf(startDay[3]) + "." + String.valueOf(startYear[3]), JLabel.CENTER));
      P4.add(new JLabel("to", JLabel.CENTER));
      P4.add(new JLabel(String.valueOf(endMonth[3]) + "." + String.valueOf(endDay[3]) + "." + String.valueOf(endYear[3]), JLabel.CENTER));

      P5 = new JPanel(new BorderLayout());
      P5.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
      P6 = new JPanel(new BorderLayout());
      P6.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P6.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
    }
    else if (timeNum == 5)
    {
      P1 = new JPanel(new GridLayout(3,1));
      P1.add(new JLabel(String.valueOf(startMonth[0]) + "." + String.valueOf(startDay[0]) + "." + String.valueOf(startYear[0]), JLabel.CENTER));
      P1.add(new JLabel("to", JLabel.CENTER));
      P1.add(new JLabel(String.valueOf(endMonth[0]) + "." + String.valueOf(endDay[0]) + "." + String.valueOf(endYear[0]), JLabel.CENTER));
      P2 = new JPanel(new GridLayout(3,1));
      P2.add(new JLabel(String.valueOf(startMonth[1]) + "." + String.valueOf(startDay[1]) + "." + String.valueOf(startYear[1]), JLabel.CENTER));
      P2.add(new JLabel("to", JLabel.CENTER));
      P2.add(new JLabel(String.valueOf(endMonth[1]) + "." + String.valueOf(endDay[1]) + "." + String.valueOf(endYear[1]), JLabel.CENTER));
      P3 = new JPanel(new GridLayout(3,1));
      P3.add(new JLabel(String.valueOf(startMonth[2]) + "." + String.valueOf(startDay[2]) + "." + String.valueOf(startYear[2]), JLabel.CENTER));
      P3.add(new JLabel("to", JLabel.CENTER));
      P3.add(new JLabel(String.valueOf(endMonth[2]) + "." + String.valueOf(endDay[2]) + "." + String.valueOf(endYear[2]), JLabel.CENTER));
      P4 = new JPanel(new GridLayout(3,1));
      P4.add(new JLabel(String.valueOf(startMonth[3]) + "." + String.valueOf(startDay[3]) + "." + String.valueOf(startYear[3]), JLabel.CENTER));
      P4.add(new JLabel("to", JLabel.CENTER));
      P4.add(new JLabel(String.valueOf(endMonth[3]) + "." + String.valueOf(endDay[3]) + "." + String.valueOf(endYear[3]), JLabel.CENTER));
      P5 = new JPanel(new GridLayout(3,1));
      P5.add(new JLabel(String.valueOf(startMonth[4]) + "." + String.valueOf(startDay[4]) + "." + String.valueOf(startYear[4]), JLabel.CENTER));
      P5.add(new JLabel("to", JLabel.CENTER));
      P5.add(new JLabel(String.valueOf(endMonth[4]) + "." + String.valueOf(endDay[4]) + "." + String.valueOf(endYear[4]), JLabel.CENTER));
      

      P6 = new JPanel(new BorderLayout());
      P6.add(new JLabel("No suitable time intervals"), BorderLayout.CENTER);
      P6.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
    }
    else if (timeNum == 6)
    {
      P1 = new JPanel(new GridLayout(3,1));
      P1.add(new JLabel(String.valueOf(startMonth[0]) + "." + String.valueOf(startDay[0]) + "." + String.valueOf(startYear[0]), JLabel.CENTER));
      P1.add(new JLabel("to", JLabel.CENTER));
      P1.add(new JLabel(String.valueOf(endMonth[0]) + "." + String.valueOf(endDay[0]) + "." + String.valueOf(endYear[0]), JLabel.CENTER));
      P2 = new JPanel(new GridLayout(3,1));
      P2.add(new JLabel(String.valueOf(startMonth[1]) + "." + String.valueOf(startDay[1]) + "." + String.valueOf(startYear[1]), JLabel.CENTER));
      P2.add(new JLabel("to", JLabel.CENTER));
      P2.add(new JLabel(String.valueOf(endMonth[1]) + "." + String.valueOf(endDay[1]) + "." + String.valueOf(endYear[1]), JLabel.CENTER));
      P3 = new JPanel(new GridLayout(3,1));
      P3.add(new JLabel(String.valueOf(startMonth[2]) + "." + String.valueOf(startDay[2]) + "." + String.valueOf(startYear[2]), JLabel.CENTER));
      P3.add(new JLabel("to", JLabel.CENTER));
      P3.add(new JLabel(String.valueOf(endMonth[2]) + "." + String.valueOf(endDay[2]) + "." + String.valueOf(endYear[2]), JLabel.CENTER));
      P4 = new JPanel(new GridLayout(3,1));
      P4.add(new JLabel(String.valueOf(startMonth[3]) + "." + String.valueOf(startDay[3]) + "." + String.valueOf(startYear[3]), JLabel.CENTER));
      P4.add(new JLabel("to", JLabel.CENTER));
      P4.add(new JLabel(String.valueOf(endMonth[3]) + "." + String.valueOf(endDay[3]) + "." + String.valueOf(endYear[3]), JLabel.CENTER));
      P5 = new JPanel(new GridLayout(3,1));
      P5.add(new JLabel(String.valueOf(startMonth[4]) + "." + String.valueOf(startDay[4]) + "." + String.valueOf(startYear[4]), JLabel.CENTER));
      P5.add(new JLabel("to", JLabel.CENTER));
      P5.add(new JLabel(String.valueOf(endMonth[4]) + "." + String.valueOf(endDay[4]) + "." + String.valueOf(endYear[4]), JLabel.CENTER));
      P6 = new JPanel(new GridLayout(3,1));
      P6.add(new JLabel(String.valueOf(startMonth[5]) + "." + String.valueOf(startDay[5]) + "." + String.valueOf(startYear[5]), JLabel.CENTER));
      P6.add(new JLabel("to", JLabel.CENTER));
      P6.add(new JLabel(String.valueOf(endMonth[5]) + "." + String.valueOf(endDay[5]) + "." + String.valueOf(endYear[5]), JLabel.CENTER));
    }
    // 一堆 else if
    
    
    
    
    
    
    
    
    
    
    setLayout(new GridLayout(2,3));
    add(P1);
    add(P2);
    add(P3);
    add(P4);
    add(P5);
    add(P6);
    
    setVisible(true);
    pack();
  }
}
