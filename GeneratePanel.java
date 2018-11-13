import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class GeneratePanel extends JPanel
{
	private JPanel panel;
	
	public GeneratePanel()
	{
		
		
		JPanel panel = new JPanel(new GridLayout(3,1));
		JPanel displayPanel = new JPanel(new BorderLayout());
		JPanel updatePanel = new JPanel(new BorderLayout());
		JPanel reportPanel = new JPanel(new BorderLayout());
		JPanel updatePanel2 = new JPanel(new GridLayout(2,2));
		JPanel reportPanel2 = new JPanel(new GridLayout(2,2));
		
		//display panel setup
		JLabel displayLabel = new JLabel("                                                                                                Display Paths");
		JCheckBox critical = new JCheckBox("Only Show Critical Path(s)");
		JButton displayPaths = new JButton("Display Paths");
		displayPanel.add(displayLabel, BorderLayout.NORTH);
		displayPanel.add(critical, BorderLayout.CENTER);
		displayPanel.add(displayPaths, BorderLayout.EAST);
		
		//update panel setup
		JLabel updateLabel = new JLabel("                                                                                                Change a Duration");
		JLabel activity = new JLabel("Activity");
		JTextField activityName = new JTextField();
		JLabel duration = new JLabel("New Duration");
		JTextField newDuration = new JTextField();
		JButton newPaths = new JButton("Update Paths");
		updatePanel2.add(activity);
		updatePanel2.add(activityName);
		updatePanel2.add(duration);
		updatePanel2.add(newDuration);
		updatePanel.add(updateLabel, BorderLayout.NORTH);
		updatePanel.add(updatePanel2, BorderLayout.CENTER);
		updatePanel.add(newPaths, BorderLayout.EAST);
		
		//create report setup
		JLabel reportLabel = new JLabel("                                                                                                Create a Report");
		JLabel report = new JLabel("Report Name");
		JLabel blank = new JLabel(" ");
		JLabel blank2 = new JLabel(" ");
		JTextField reportName = new JTextField();
		JButton createReport = new JButton("Create Report");
		reportPanel2.add(report);
		reportPanel2.add(reportName);
		reportPanel2.add(blank);
		reportPanel2.add(blank2);
		reportPanel.add(reportLabel, BorderLayout.NORTH);
		reportPanel.add(reportPanel2, BorderLayout.CENTER);
		reportPanel.add(createReport, BorderLayout.EAST);
		
		//add all to main panel
		panel.add(displayPanel);
		panel.add(updatePanel);
		panel.add(reportPanel);

		displayLabel.setPreferredSize(new Dimension(350, 25));
		updateLabel.setPreferredSize(new Dimension(350, 25));
		reportLabel.setPreferredSize(new Dimension(350, 50));
		activity.setPreferredSize(new Dimension(300, 50));
		duration.setPreferredSize(new Dimension(300, 50));
		report.setPreferredSize(new Dimension(300, 50));
		this.add(panel);
		
		//buttonlisteners
		displayPaths.addActionListener(new displayButtonListener());
		newPaths.addActionListener(new newPathButtonListener());
		createReport.addActionListener(new createRepButtonListener());
		
	}
		
		private class displayButtonListener implements ActionListener
		{
		      public void actionPerformed (ActionEvent event)
		      {
		    	  	
		      }
		}//end of display button listener
		
		private class newPathButtonListener implements ActionListener
		{
		      public void actionPerformed (ActionEvent event)
		      {
		    	  	
		      }
		}//end of newPath button listener
		
		private class createRepButtonListener implements ActionListener
		{
		      public void actionPerformed (ActionEvent event)
		      {
		    	  	
		      }
		}//end of createRepButton listener
	

}