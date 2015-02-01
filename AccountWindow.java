package calendartest;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class AccountWindow extends JFrame
{
  
  private JPasswordField P1Password;
  private JPasswordField P2Password;
  private JPasswordField P3Password;
  private JPasswordField P4Password;
  
  private JButton okButton;
  private JButton cancelButton;
  private JLabel when2meetLabel;

  private JPanel P1Panel;
  private JPanel P2Panel;
  private JPanel P3Panel;
  private JPanel P4Panel;
  private JPanel infoPanel;
  private JPanel buttonPanel;
  private JPanel timePanel;
  private JPanel startTimePanel;
  private JPanel endTimePanel;
  
  private JPanel leftPanel;
  private JPanel rightPanel;
  private JPanel firstTimePanel;
  private JPanel secondTimePanel;
  
  private static JComboBox< Integer > startYearCombo;
  private static JComboBox< Integer > startMonthCombo;
  private static JComboBox< Integer > startDayCombo;
  private static JComboBox< Integer > startHourCombo;
  private static JComboBox< String > startMinuteCombo;
  
  private static JComboBox< Integer > endYearCombo;
  private static JComboBox< Integer > endMonthCombo;
  private static JComboBox< Integer > endDayCombo;
  private static JComboBox< Integer > endHourCombo;
  private static JComboBox< String > endMinuteCombo;
  
  private int numCandidate = 1;
  private int startYear = 2015;
  private int startMonth = 1;
  private int startDay = 1;
  private int startHour = 0;
  private int startMinute = 0;
  
  private int endYear = 2015;
  private int endMonth = 1;
  private int endDay = 1;
  private int endHour = 0;
  private int endMinute = 0;
  
  public static String[] codes = {"", "", "", ""};
  public static ArrayList<Process> finalresult;
  
  public AccountWindow()
  {
    super("Account Information");
    
    // Set time Panel
    startYearCombo = new JComboBox< Integer >();
    startYearCombo.addActionListener(new startYearComboListener());
    startMonthCombo = new JComboBox< Integer >();
    startMonthCombo.addActionListener(new startMonthComboListener());
    startDayCombo = new JComboBox< Integer >();
    startDayCombo.setEnabled(false);
    startDayCombo.addActionListener(new startDayComboListener());
    startHourCombo = new JComboBox< Integer >();
    startHourCombo.addActionListener(new startHourComboListener());
    startMinuteCombo = new JComboBox< String >();
    startMinuteCombo.addActionListener(new startMinuteComboListener());
    
    endYearCombo = new JComboBox< Integer >();
    endYearCombo.addActionListener(new endYearComboListener());
    endMonthCombo = new JComboBox< Integer >();
    endMonthCombo.addActionListener(new endMonthComboListener());
    endDayCombo = new JComboBox< Integer >();
    endDayCombo.addActionListener(new endDayComboListener());
    endHourCombo = new JComboBox< Integer >();
    endHourCombo.addActionListener(new endHourComboListener());
    endMinuteCombo = new JComboBox< String >();
    endMinuteCombo.addActionListener(new endMinuteComboListener());
    
    // add items
    startYearCombo.addItem(2015);
    for (int i = 1; i <= 12; i++)
      startMonthCombo.addItem(i);
    for (int i = 0; i <= 23; i++)
      startHourCombo.addItem(i);
    startMinuteCombo.addItem("00");
    startMinuteCombo.addItem("30");
    
    endYearCombo.addItem(2015);
    for (int i = 1; i <= 12; i++)
      endMonthCombo.addItem(i);
    for (int i = 0; i <= 23; i++)
      endHourCombo.addItem(i);
    endMinuteCombo.addItem("00");
    endMinuteCombo.addItem("30");
    
    startTimePanel = new JPanel(new FlowLayout());
    startTimePanel.add(startYearCombo);
    startTimePanel.add(startMonthCombo);
    startTimePanel.add(startDayCombo);
    startTimePanel.add(startHourCombo);
    startTimePanel.add(startMinuteCombo);
    
    endTimePanel = new JPanel(new FlowLayout());
    endTimePanel.add(endYearCombo);
    endTimePanel.add(endMonthCombo);
    endTimePanel.add(endDayCombo);
    endTimePanel.add(endHourCombo);
    endTimePanel.add(endMinuteCombo);
    
    firstTimePanel = new JPanel(new GridLayout(2,1));
    firstTimePanel.add(new JLabel("Start time:           Month           Date           Hour           Minute"));
    firstTimePanel.add(startTimePanel);
    
    secondTimePanel = new JPanel(new GridLayout(2,1));
    secondTimePanel.add(new JLabel("End time:             Month           Date           Hour           Minute"));
    secondTimePanel.add(endTimePanel);
    
    timePanel = new JPanel(new GridLayout(2,1));
    timePanel.add(firstTimePanel);
    timePanel.add(secondTimePanel);
    
    
    // Set P1 Panel
    JLabel P1Account = new JLabel();
    P1Account.setText("<html><a href='#'>Click me to authorize and paste codes!</a><html>");
    P1Account.addMouseListener(new mouseListener());
    P1Account.setEnabled(false);
    P1Password = new JPasswordField(20);
    P1Password.setEnabled(false);
    P1Panel = new JPanel(new GridLayout(3,1));
    P1Panel.add(new JLabel("Input first account:"));
    P1Panel.add(P1Account);
    P1Panel.add(P1Password);
    
    // Set P2 Panel
    P2Password = new JPasswordField(20);
    P2Password.setEnabled(false);
    P2Panel = new JPanel(new GridLayout(3,2));
    P2Panel.add(new JLabel("Input second account:"));
    P2Panel.add(P2Password);
    
    // Set P3 Panel
    P3Password = new JPasswordField(20);
    P3Password.setEnabled(false);
    P3Panel = new JPanel(new GridLayout(3,3));
    P3Panel.add(new JLabel("Input third account:"));
    P3Panel.add(P3Password);
    
    // Set P4 Panel
    P4Password = new JPasswordField(20);
    P4Password.setEnabled(false);
    P4Panel = new JPanel(new GridLayout(3,4));
    P4Panel.add(new JLabel("Input fourth account:"));
    P4Panel.add(P4Password);
    
    // Set infoPanel
    infoPanel = new JPanel(new GridLayout(4,1));
    infoPanel.add(P1Panel);
    infoPanel.add(P2Panel);
    infoPanel.add(P3Panel);
    infoPanel.add(P4Panel);
    
    // Set button Panel
    okButton = new JButton("OK");
    cancelButton = new JButton("Cancel");
    buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.add(okButton);
    buttonPanel.add(cancelButton);
    
    // Set right Panel
    rightPanel = new JPanel(new BorderLayout());
    rightPanel.add(timePanel, BorderLayout.NORTH);
    rightPanel.add(infoPanel, BorderLayout.CENTER);
    rightPanel.add(buttonPanel, BorderLayout.SOUTH);
    
    // Set left Panel
    when2meetLabel = new JLabel("   When2Meet   ");
    when2meetLabel.setFont(new Font("Dialog", 1, 20));
    leftPanel = new JPanel(new GridLayout(3,1));
    leftPanel.add(new JLabel(""));
    leftPanel.add(when2meetLabel);
    leftPanel.add(new JLabel(""));
    leftPanel.setBorder(new LineBorder(Color.blue));
    
    // Set whole Panel
    setLayout(new FlowLayout());
    add(new JLabel("    "));
    add(leftPanel);
    add(new JLabel("   "));
    add(rightPanel);
    add(new JLabel("    "));
    
    // Set visibility according to input number
    numCandidate = Logic.getCandidate();
    if (numCandidate == 1)
    {
      P1Account.setEnabled(true);
      P1Password.setEnabled(true);
    }
    else if (numCandidate == 2)
    {
      P1Account.setEnabled(true);
      P1Password.setEnabled(true);
      P2Password.setEnabled(true);
    }
    else if (numCandidate == 3)
    {
      P1Account.setEnabled(true);
      P1Password.setEnabled(true);
      P2Password.setEnabled(true);
      P3Password.setEnabled(true);
    }
    else if (numCandidate == 4)
    {
      P1Account.setEnabled(true);
      P1Password.setEnabled(true);
      P2Password.setEnabled(true);
      P3Password.setEnabled(true);
      P4Password.setEnabled(true);
    }
    
    pack();
    setVisible(true);
    
    // Add Button Listener
    okButton.addActionListener(new ButtonListener());
    cancelButton.addActionListener(new ButtonListener());
  }
  
  
  public class mouseListener extends MouseAdapter 
  {
    public void mouseClicked(MouseEvent e) 
    {
      final String google = calendartest.getURL();
      Desktop desktop = Desktop.getDesktop(); 
      try {
          desktop.browse(new URI(google));
      } catch (IOException e1) {
          e1.printStackTrace();
      } catch (URISyntaxException e1) {
          e1.printStackTrace();
      }
    }
  }
  
  
  
  public class startYearComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< Integer > startYearCombo = (JComboBox< Integer >)e.getSource();
      startYear = 2015;
    }
  }
  
  
  public class endYearComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< Integer > endYearCombo = (JComboBox< Integer >)e.getSource();
      endYear = 2015;
    }
  }
  
  
  public class startMonthComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< Integer > startMonthCombo = (JComboBox< Integer >)e.getSource();
      startMonth = (int) startMonthCombo.getSelectedItem();
      
      startDayCombo.removeAllItems();
      if (startMonth == 1 || startMonth == 3 || startMonth == 5 || 
          startMonth == 7 || startMonth == 8 || startMonth == 10 ||
          startMonth == 12)
      {
        for (int j = 1; j <= 31; j++)
          startDayCombo.addItem(j);
      }
      else if (startMonth == 2)
      {
        for (int k = 1; k <= 28; k++)
          startDayCombo.addItem(k);
      }
      else
      {
        for (int m = 1; m <= 30; m++)
          startDayCombo.addItem(m);
      }
      startDayCombo.setEnabled(true);
    }
  }
  
  
  public class endMonthComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< Integer > endMonthCombo = (JComboBox< Integer >)e.getSource();
      endMonth = (int) endMonthCombo.getSelectedItem();
      
      endDayCombo.removeAllItems();
      if (endMonth == 1 || endMonth == 3 || endMonth == 5 || 
          endMonth == 7 || endMonth == 8 || endMonth == 10 ||
          endMonth == 12)
      {
        for (int j = 1; j <= 31; j++)
          endDayCombo.addItem(j);
      }
      else if (endMonth == 2)
      {
        for (int k = 1; k <= 28; k++)
          endDayCombo.addItem(k);
      }
      else
      {
        for (int m = 1; m <= 30; m++)
          endDayCombo.addItem(m);
      }
      endDayCombo.setEnabled(true);
    }
  }
  
  
  public class startDayComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< Integer > startDayCombo = (JComboBox< Integer >)e.getSource();
      //startDay = (int) startDayCombo.getSelectedItem();
      //System.out.print(startDay);
    }
  }
  
  public class endDayComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< Integer > endDayCombo = (JComboBox< Integer >)e.getSource();
      //endDay = (int) endDayCombo.getSelectedItem();
    }
  }
  
  public class startHourComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< Integer > startHourCombo = (JComboBox< Integer >)e.getSource();
      //startHour = (int) startHourCombo.getSelectedItem();
    }
  }
  
  public class endHourComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< Integer > endHourCombo = (JComboBox< Integer >)e.getSource();
      //endHour = (int) endHourCombo.getSelectedItem();
    }
  }
  
  public class startMinuteComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< String > startMinuteCombo = (JComboBox< String >)e.getSource();
      //startMinute = (int) startMinuteCombo.getSelectedItem();
    }
  }
  
  public class endMinuteComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< String > endMinuteCombo = (JComboBox< String >)e.getSource();
      //endMinute = (int) endMinuteCombo.getSelectedItem();
    }
  }
  
  
  public class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      if (e.getSource() == okButton)
      {
        
        if(Logic.getCandidate() == 1){
          codes[0] = P1Password.getText().toString();
        }
        else if(Logic.getCandidate() == 2){
          codes[0] = P1Password.getText().toString();
          codes[1] = P2Password.getText().toString();
        }
        else if(Logic.getCandidate() == 3){
          codes[0] = P1Password.getText().toString();
          codes[1] = P2Password.getText().toString();
          codes[2] = P3Password.getText().toString();
        }
        else if(Logic.getCandidate() == 4){
          codes[0] = P1Password.getText().toString();
          codes[1] = P2Password.getText().toString();
          codes[2] = P3Password.getText().toString();
          codes[3] = P4Password.getText().toString();
        }
        System.out.print(P1Password.getPassword().toString());
        startDay = (int) startDayCombo.getSelectedItem();
        System.out.print(startDayCombo.getSelectedItem().toString());
        endDay = (int) endDayCombo.getSelectedItem();
        startHour = (int) startHourCombo.getSelectedItem();
        endHour = (int) endHourCombo.getSelectedItem();
        
        if (startMinuteCombo.getSelectedItem().equals("00"))
          startMinute = 0;
        else  if (startMinuteCombo.getSelectedItem().equals("30"))
          startMinute = 30;
        
        Logic.setStartTime(startYear, startMonth, startDay, startHour, startMinute);
        Logic.setEndTime(endYear, endMonth, endDay, endHour, endMinute);
        
        calendartest.setStartyear(Logic.getStartYear());
        calendartest.setEndyear(Logic.getEndYear());
        
        if(startMonth>9){
        calendartest.setStartmonth(Logic.getStartMonth());
        }
        else{
          calendartest.setStartmonth("0"+Logic.getStartMonth());
        }
        if(endMonth>9){
          calendartest.setEndmonth(Logic.getEndMonth());
          }
          else{
            calendartest.setEndmonth("0"+Logic.getEndMonth());
        }
        if(startDay>9){
          calendartest.setStartday(Logic.getStartDay());
          }
          else{
            calendartest.setStartday("0"+Logic.getStartDay());
          }
          if(endDay>9){
            calendartest.setEndday(Logic.getEndDay());
            }
            else{
              calendartest.setEndday("0"+Logic.getEndDay());
          }
          if(startHour>9){
            calendartest.setStarthour(Logic.getStartHour());
            }
            else{
              calendartest.setStarthour("0"+Logic.getStartHour());
            }
            if(endHour>9){
              calendartest.setEndhour(Logic.getEndHour());
              }
              else{
                calendartest.setEndhour("0"+Logic.getEndHour());
            }
        System.out.println("-----------------------");
        System.out.println(calendartest.getStartday());
        System.out.println(startDay);
        
        
        
        if(startMinute>9){
          calendartest.setStartminute(Logic.getStartMinute());
          }
          else{
            calendartest.setStartminute("0"+Logic.getStartMinute());
          }
          if(endMinute>9){
            calendartest.setEndminute(Logic.getEndMinute());
            }
            else{
              calendartest.setEndminute("0"+Logic.getEndMinute());
          }
        setVisible(false);
        try
        {
          finalresult = calendartest.setUp(Logic.getCandidate());
        }
        catch( IOException | GeneralSecurityException e1 )
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        // implemented here
        

        ResultPage resultPage;
        resultPage = new ResultPage();
        resultPage.setResizable(false);
        resultPage.setSize(600, 400);
        //resultPage.pack();
        resultPage.setVisible(true);
        resultPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
      }
      else if (e.getSource() == cancelButton)
      {
        System.exit(0);
      }
      
    }
  }
  

}
