import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.text.*;

 public class GeneratePanel extends JPanel
{
	private JPanel panel, reportPanel2, updatePanel2;
	private InterfacePanel2 intPanel;
	private boolean criticalPath;
	private JCheckBox critical;
	
	public GeneratePanel(ArrayList<Node> nodelist, ArrayList<Path> paths, boolean circularError)
	{
		intPanel = new InterfacePanel2(nodelist, paths, circularError);
		criticalPath = false;
		JPanel panel = new JPanel(new GridLayout(3,1));
		JPanel displayPanel = new JPanel(new BorderLayout());
		JPanel updatePanel = new JPanel(new BorderLayout());
		JPanel reportPanel = new JPanel(new BorderLayout());
		updatePanel2 = new JPanel(new GridLayout(2,2));
		reportPanel2 = new JPanel(new GridLayout(2,2));
		
		//display panel setup
		JLabel displayLabel = new JLabel("                                                                                                Display Paths");
		critical = new JCheckBox("Only Show Critical Path(s)");
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
		critical.addItemListener(new CheckBoxListener());
		
	}
		
		private class displayButtonListener implements ActionListener
		{
		      public void actionPerformed (ActionEvent event)
		      {
		    	  if(criticalPath == false)
		    	  {
		    		  	JFrame dispFrame = new JFrame("Display Paths");
			    	  	JPanel panel = new JPanel();
			  			panel.setLayout(new FlowLayout());
			    	  	JOptionPane generatePath = new JOptionPane();
			    	  	JOptionPane.showMessageDialog(dispFrame, intPanel.printList(), "Generate Path", JOptionPane.INFORMATION_MESSAGE);
						generatePath.add(panel);
						dispFrame.add(generatePath);
						generatePath.setSize(300, 300);
						generatePath.setVisible(true);
		    	  }
		    	  else
		    	  {
		    		  //instantiations
		    		  intPanel.sortPaths();
		    		  ArrayList<Path> paths = intPanel.getPaths();
		    		  ArrayList<Path> temp = new ArrayList<Path>();
		    		  temp.add(paths.get(0));
		    		  int size = 0;
		    		  int maxDuration = paths.get(0).getDuration();
		    		  String result = "";
		    		  //loop until a smaller duration is found
		    		  for(int i = 1; i < paths.size(); i++)
		    		  {
		    			  if(paths.get(i).getDuration() == maxDuration)
		    			  {
		    				  temp.add(paths.get(i));
		    			  }
		    		  }
		    		  for(int j = 0; j <= size; j++)
	  					{
	  						result += paths.get(j).printList() + "\n";
	  					}
		    		  //message dialog box
		    		  JFrame dispFrame = new JFrame("Critical Paths");
			    	  	JPanel panel = new JPanel();
			  			panel.setLayout(new FlowLayout());
			    	  	JOptionPane generatePath = new JOptionPane();
			    	  	JOptionPane.showMessageDialog(dispFrame, intPanel.printCritical(temp), "Critical Paths", JOptionPane.INFORMATION_MESSAGE);
						generatePath.add(panel);
						dispFrame.add(generatePath);
						generatePath.setSize(300, 300);
						generatePath.setVisible(true);
		    	  }
		    	  	
		      }
		}//end of display button listener
		
		private class newPathButtonListener implements ActionListener
		{
		      public void actionPerformed (ActionEvent event)
		      {
		    	  	// variable declarations
		    	  	ArrayList<Node> nodelist = intPanel.getNodelist();
		    	  	JTextField actName, durName;
		    	  	String actNameIn, durNameIn; 
		    	  	int changeDur;
		    	  	// grabbing info from Text Fields
		    	  	actName = (JTextField)updatePanel2.getComponent(1);
		    	  	actNameIn = actName.getText();
		    	  	durName = (JTextField)updatePanel2.getComponent(3);
		    	  	durNameIn = durName.getText();
		    	  	changeDur = Integer.parseInt(durNameIn);
		    	  	
		    	  	for(int i = 0; i < nodelist.size(); i++)
		    	  	{
		    	  		if(actNameIn.compareTo(nodelist.get(i).getName()) == 0)
		    	  		{
		    	  			nodelist.get(i).setDuration(changeDur);
		    	  		}
		    	  	}
		    	  	//fix paths
		    	  	intPanel.clearPaths();
		    	  	intPanel.createPaths(nodelist);
				intPanel.sortPaths();
		    	  	
		    	  	actName.setText(null);
		    	  	durName.setText(null);
		      }
		}//end of newPath button listener
		
		private class createRepButtonListener implements ActionListener
		{
		      public void actionPerformed (ActionEvent event)
		      {
		    	  try 
		    	  {
		    		    //variables for the user input
		    		    JTextField repName;
		    		    String repNameIn, reportName;  
		    		    //initializing field
		    		    repName = (JTextField) reportPanel2.getComponent(1);
		    		    repNameIn = repName.getText();
		    		    //check if empty string
		    		    reportName = repNameIn;
		    		    
		                FileWriter fw = new FileWriter(reportName+".txt", false); // change to true if we want to append instead of overwrite
		                BufferedWriter bw = new BufferedWriter(fw);
		                PrintWriter out = new PrintWriter(bw);
		                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		                Date date = new Date();
		                //userRepName = new File("");
		                out.println();
		                out.println("Report Title: "+reportName);
		                out.println("Created on: " + formatter.format(date));
		                out.println();
		                sortNodeList();
		                out.println("ACTIVITIES:");
		                //iterates through now-sorted activities
		                ArrayList<Node> nodelist = intPanel.getNodelist();
		                for(int i = 0; i < nodelist.size(); i++)
		                {
		                    out.println("Activity: " + nodelist.get(i).getName());
		                    out.println("Duration: " + nodelist.get(i).getDuration());
		                    out.println();
		                }
		                
		                intPanel.sortPaths();
		                out.println("PATHS:");
		                //same printList method from Paths.java
		                out.println(intPanel.printList());
		                 //end PrintWriter
		                out.close();
		          } 
		    	  
		    	  catch(IOException e)
		    	  {
		                System.out.println("Error");
		          }
		        
		    }
		      
		}//end of createRepButton listener
		
		private class CheckBoxListener implements ItemListener
		{
			public void itemStateChanged(ItemEvent event)
			{
				Object source = event.getSource();
				if(critical.isSelected() == true)
				{
					criticalPath = true;
				}
				else
				{
					criticalPath = false;
				}
				
			}
		}
	
		 
		private void sortNodeList()//bubble sorts node list for report generator
		{ 
			ArrayList<Node> nodelist = intPanel.getNodelist();
	        for(int i = 0; i < nodelist.size(); i++)
	        {
	            for(int j = i; j < nodelist.size(); j++)
	            {
	                if(nodelist.get(i).getName().compareTo(nodelist.get(j).getName()) > 0)
	                {
	                    Node temp = nodelist.get(i);
	                    nodelist.set(i, nodelist.get(j));
	                    nodelist.set(j, temp);
	                }
	            }
	        }
	    } //end of sort node list 
		
} 