import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class InterfacePanel extends JPanel
{
	private JPanel panel;
	private ArrayList<Node> nodelist;

	public InterfacePanel(ArrayList<Node> list)
	{
		//nodelist is an arraylist of nodes of inputted activities
		nodelist = list;

		//Panel layout
		panel = new JPanel(new GridLayout(6,2));

		//Initialize Labels
		JLabel actName = new JLabel("Activity Name");
		JLabel duration = new JLabel("Duration");
		JLabel depend = new JLabel("Dependencies (separate by comma)");

		//Initialize Buttons
		JButton enter = new JButton("Enter another activity");
		JButton generate = new JButton("Generate Path");
		JButton restart = new JButton("Restart");
		JButton quit = new JButton("Quit");
		JButton about = new JButton("About");
		JButton help = new JButton("Help");

		//Button Listeners
		about.addActionListener(new AboutButtonListener());
		help.addActionListener(new HelpButtonListener());
		quit.addActionListener(new QuitButtonListener());
		enter.addActionListener(new EnterButtonListener());
		generate.addActionListener(new GenerateButtonListener());
		restart.addActionListener(new RestartButtonListener());


		//Set size for buttons
		enter.setPreferredSize(new Dimension(350, 100));
		generate.setPreferredSize(new Dimension(350, 100));
		restart.setPreferredSize(new Dimension(350, 100));
		quit.setPreferredSize(new Dimension(350, 100));
		about.setPreferredSize(new Dimension(350, 100));
		help.setPreferredSize(new Dimension(350, 100));

		//Initialize text fields
		JTextField actText = new JTextField();
		JTextField durationText = new JTextField();
		JTextField dependText = new JTextField();
		actText.setColumns(10);
		durationText.setColumns(10);
		dependText.setColumns(10);

		//Add all components to panel
		panel.add(actName);
		panel.add(actText);
		panel.add(duration);
		panel.add(durationText);
		panel.add(depend);
		panel.add(dependText);
		panel.add(enter);
		panel.add(generate);
		panel.add(restart);
		panel.add(quit);
		panel.add(about);
		panel.add(help);

		//add panel to frame
		this.add(panel);

	}//end of panel constructor

	//About button listener for when about button is clicked
	private class AboutButtonListener implements ActionListener
	{
	      public void actionPerformed (ActionEvent event)
	      {
	    	  	JFrame frame = new JFrame();
	    	  	JOptionPane about = new JOptionPane();
		  		about.setName("About");
		  		JPanel panel = new JPanel();
		 		panel.setLayout(new FlowLayout());

		  		JOptionPane.showMessageDialog(frame, "The Network Analysis Program was created by Zadig Alvarez, Miguel Cuen,\n"
		 			+ "Matthew Davison, and Christian Lopez for CSE360 with Dr. Debra Callis.\n"
		 			+ "The program assists with project planning by providing a list of possible\n"
		 			+ "paths required for project completion based on activites, durations, and \ndependencies.", "About", JOptionPane.INFORMATION_MESSAGE);

		 		about.add(panel);
		 		frame.add(about);
		  		about.setSize(300,300);
		  		about.setVisible(true);
	      }
	}//end of about button listener

	//Help button listener for when Help button is clicked
	private class HelpButtonListener implements ActionListener
	{
	      public void actionPerformed (ActionEvent event)
	      {
		   	  	JFrame frame = new JFrame();
		  		JOptionPane help = new JOptionPane();
		  		help.setName("Help");
		  		JPanel panel = new JPanel();
			  	panel.setLayout(new FlowLayout());

		 		JOptionPane.showMessageDialog(frame, "The Network Analysis Program is designed to create a list of required paths\n"
		  				+ "to be completed by the user after accepting a number of inputs. Inputs come\n"
		  				+ "in the form of an activity name, a duration, and a list of dependencies. The\n"
		  				+ "NAP will use these inputs to create paths, which show the total duration for\n"
			  			+ "each, as well as all activity names along the path.\n\n"
			  			+ "To use, enter an activity name and duration. If the activity's start is dependent\n"
			  			+ "on other processes' completion, enter the name of the dependencies, separated by\n"
			 			+ "commas. To add additional activities, select \"Add Another Activity\". To view the\n"
			 			+ "possible outcomes, select \"Generate Path\". To start over, select \"Restart\". To\n"
			  			+ "close the program, select \"Quit\".", "Help", JOptionPane.INFORMATION_MESSAGE);

				help.add(panel);
				frame.add(help);
			 	help.setSize(300,300);
			  	help.setVisible(true);
	      }
	}//end of help button listener

	//Quit button Listener for when quit button is clicked
	private class QuitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
		      System.exit(0);
		}
	}//end of quit button listener

	//Enter button Listener for when enter button is clicked
	private class EnterButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			  //variables used to get user input and eventually enter the information as a node if input is correct
		      JTextField field1, field2, field3;
		      String fieldin1, fieldin2, fieldin3;
		      ArrayList<String> dependencies = new ArrayList<String>();
		      String name;
		      int duration;
		      Node node;

		      //initialize fields
		      field1 = (JTextField) panel.getComponent(1);
		      field2 = (JTextField) panel.getComponent(3);
		      field3 = (JTextField) panel.getComponent(5);

		      //obtain user input
		      fieldin1 = field1.getText();
		      fieldin2 = field2.getText();
		      fieldin3 = field3.getText();

		      //if either the activity name or duration is empty, give out an error
		      if(fieldin1.isEmpty() || fieldin2.isEmpty())
		      {
		    	  	JFrame frame = new JFrame();
			  		JOptionPane error = new JOptionPane();
			  		error.setName("Error");
			  		JPanel panel = new JPanel();
				  	panel.setLayout(new FlowLayout());
			 		JOptionPane.showMessageDialog(frame, "Please enter a name and duration", "Error", JOptionPane.INFORMATION_MESSAGE);
					error.add(panel);
					frame.add(error);
				 	error.setSize(300,300);
				  	error.setVisible(true);
				  	return;
		      }

		      //store the inputed name
		      name = fieldin1;

		      //check if duration is an integer
		      for(int i = 0; i < fieldin2.length(); i++)
		      {
					char digit = fieldin2.charAt(i);
					if(Character.isDigit(digit) == false)
					{
						JFrame frame = new JFrame();
				  		JOptionPane error = new JOptionPane();
				  		error.setName("Error");
				  		JPanel panel = new JPanel();
					  	panel.setLayout(new FlowLayout());

				 		JOptionPane.showMessageDialog(frame, "Please enter an integer for the duration", "Error", JOptionPane.INFORMATION_MESSAGE);

						error.add(panel);
						frame.add(error);
					 	error.setSize(300,300);
					  	error.setVisible(true);
						return;
					}
		      }

		      //parse integer
		      duration = Integer.parseInt(fieldin2);

		      //if dependencies field is not empty, check if they are valid dependencies to add to the node for this activity
		      if(fieldin3.isEmpty() == false)
		      {
		    	  //temp variables for checking dependencies
		    	  String stemp;
		    	  char ctemp;

		    	  //checks if there is a comma at beginning or end of string and throws error if it occurs
		    	  char ctemp1 = fieldin3.charAt(0);
		    	  char ctemp2 = fieldin3.charAt(fieldin3.length() - 1);
		    	  if(ctemp1 == ',' || ctemp2 == ',')
		    	  {
		    		  	JFrame frame = new JFrame();
			  			JOptionPane error = new JOptionPane();
			  			error.setName("Error");
			  			JPanel panel = new JPanel();
			  			panel.setLayout(new FlowLayout());
			  			JOptionPane.showMessageDialog(frame, "Please enter strings separated by commas", "Error", JOptionPane.INFORMATION_MESSAGE);
			  			error.add(panel);
			  			frame.add(error);
				 		error.setSize(300,300);
				 		error.setVisible(true);
				 		return;
		    	  }


		    	  //if input is correctly formatted
		    	  else
		    	  {

		    		  	//check if there is a comma somewhere in the input
		    	  		boolean comma = false;
		    	  		for(int i = 0; i < fieldin3.length(); i++)
		    	  		{
		    	  			char temp = fieldin3.charAt(i);
		    	  			if(temp == ',')
		    	  			{
		    	  				comma = true;
		    	  			}
		    	  		}

		    	  		//if no commas, check if the single dependency is valid
		    	  		if(comma == false)
		    	  		{
		    	  			boolean validdep = checkDependencies(fieldin3);
		    	  			if(validdep == false)
		    	  			{
		    	  				JFrame frame = new JFrame();
		    	  				JOptionPane error = new JOptionPane();
		    	  				error.setName("Error");
		    	  				JPanel panel = new JPanel();
		    	  				panel.setLayout(new FlowLayout());
		    	  				JOptionPane.showMessageDialog(frame, "Please enter valid dependencies", "Error", JOptionPane.INFORMATION_MESSAGE);
						  		error.add(panel);
						  		frame.add(error);
						  		error.setSize(300,300);
						  		error.setVisible(true);
						  		return;
		    	  			}
		    	  		}

		    	  		//multiple dependencies
		    	  		else
		    	  		{
		    	  			//adds dependencies to arraylist of dependencies
		    	  			for(int i = 0; i < fieldin3.length(); i++)
		    	  			{
		    	  				ctemp = fieldin3.charAt(i);
		    	  				if(ctemp == ',')
		    	  				{
		    	  					stemp = fieldin3.substring(0,i);
		    	  					dependencies.add(stemp);
		    	  					fieldin3 = fieldin3.substring(i+1);
		    	  				}
		    	  			}
		    	  			dependencies.add(fieldin3);

		    	  			boolean validdep = false;
		    	  			for(int i = 0; i < dependencies.size(); i++)
		    	  			{
		    	  				validdep = checkDependencies(dependencies.get(i));
		    	  				if(validdep == false)
		    	  				{
		    	  					JFrame frame = new JFrame();
		    	  					JOptionPane error = new JOptionPane();
		    	  					error.setName("Error");
		    	  					JPanel panel = new JPanel();
		    	  					panel.setLayout(new FlowLayout());
		    	  					JOptionPane.showMessageDialog(frame, "Please enter valid dependencies", "Error", JOptionPane.INFORMATION_MESSAGE);
		    	  					error.add(panel);
		    	  					frame.add(error);
		    	  					error.setSize(300,300);
		    	  					error.setVisible(true);
		    	  					return;
		    	  				}
		    	  			}

		    	  		}//end of multiple dependencies handle
		    	  }//end of input is correctly formated
		      	}//end of not empty dependency


		      		//if all input is correct, the activity is added to the nodelist
		      		node = new Node(name, duration, dependencies);
		      		nodelist.add(node);


		      //resets the text fields to null
		      field1.setText(null);
		      field2.setText(null);
		      field3.setText(null);

		}
	}//end of enter button listener

	private class GenerateButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{


		    /*
		     *
		     * enter code here
		     *
		     */
		}
	}//end of generate button listener

	private class RestartButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

			//resets the text fields to null
		    JTextField field1 = (JTextField) panel.getComponent(1);
		    JTextField field2 = (JTextField) panel.getComponent(3);
		    JTextField field3 = (JTextField) panel.getComponent(5);
		    field1.setText(null);
		    field2.setText(null);
		    field3.setText(null);
		    nodelist.clear();

		}
	}//end of restart button listener

	//function returns true if the dependency sent was found in the nodelist
	//in other words, the dependency must exist in the nodelist for it to be valid
	public boolean checkDependencies(String dep)
	{
		boolean result = false;
		for(int j = 0; j < nodelist.size(); j++)
		{
			if(dep.equals(nodelist.get(j).getName()))
			{
				result = true;
			}
		}
		return result;
	}

}