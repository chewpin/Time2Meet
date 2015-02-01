package calendartest;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.swing.*;



public class WelcomeWindow extends JFrame
{
  // Declare components
  JButton okButton;
  JButton cancelButton;
  
  // Declare panels
  JPanel topPanel;
  JPanel midPanel;
  JPanel bottomPanel;
  JPanel mainPanel;
  JPanel midSubPanel;
  private int candiNum = 1;
  
  private static JComboBox< Integer > numCombo;
 
  public WelcomeWindow()
  {
    
    super("Welcome to XX program");
    
    // Top Panel
    topPanel = new JPanel(new FlowLayout());
    topPanel.add(new JLabel("Welcome!"));
    
    // Middle Panel and midSubPanel
    numCombo = new JComboBox< Integer >();
    numCombo.addItem(1);
    numCombo.addItem(2);
    numCombo.addItem(3);
    numCombo.addItem(4);
    
    
    midPanel = new JPanel(new GridLayout(2,1));
    midSubPanel = new JPanel(new BorderLayout());
    midSubPanel.add(new JLabel("                  "), BorderLayout.WEST);
    midSubPanel.add(numCombo);
    midSubPanel.add(new JLabel("                  "), BorderLayout.EAST);
    midPanel.add(new JLabel("Please select candidate number:"));
    midPanel.add(midSubPanel);
    
    // Bottom Field
    okButton = new JButton("Next");
    cancelButton = new JButton("Cancel");
    bottomPanel = new JPanel(new FlowLayout());
    bottomPanel.add(okButton);
    bottomPanel.add(cancelButton);
    
    // Set main Panel
    mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(topPanel, BorderLayout.NORTH);
    mainPanel.add(midPanel, BorderLayout.CENTER);
    mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    
    // Set whole Panel
    
    setLayout(new BorderLayout());
    add(new JLabel("   "), BorderLayout.WEST);
    add(mainPanel, BorderLayout.CENTER);
    add(new JLabel("   "), BorderLayout.EAST);
    
    // Add Listener
    okButton.addActionListener(new ButtonListener());
    cancelButton.addActionListener(new ButtonListener());
    numCombo.addActionListener(new ComboListener());
    
    pack();
    setVisible(true);
  }
  
  
  public class ComboListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      JComboBox< Integer > numCombo = (JComboBox< Integer >)e.getSource();
      candiNum = (int) numCombo.getSelectedItem();
    }
  }
  
  
  public class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      if (e.getSource() == okButton)
      {
          // implemented here
        try
        {
          calendartest.set();
        }
        catch( GeneralSecurityException e2 )
        {
          // TODO Auto-generated catch block
          e2.printStackTrace();
        }
        catch( IOException e2 )
        {
          // TODO Auto-generated catch block
          e2.printStackTrace();
        }
          Logic.setCandidate(candiNum);
          setVisible(false);
          AccountWindow accountWindow;
          accountWindow = new AccountWindow();
          accountWindow.setResizable(false);
          accountWindow.pack();
          accountWindow.setVisible(true);
          accountWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   
      }
      else if (e.getSource() == cancelButton)
      {
        System.exit(0);
      }
    }
  }
}
