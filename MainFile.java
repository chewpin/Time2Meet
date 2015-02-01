package calendartest;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFile
{
  public static WelcomeWindow mainWindow;
  public static void main( String[] args )
  {
    mainWindow = new WelcomeWindow();
    mainWindow.setResizable(false);
    //mainWindow.setSize(new Dimension(400,400));
    mainWindow.pack();
    mainWindow.setVisible(true);
    mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
