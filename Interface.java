import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Interface extends JFrame
{
	public static void main(String[] args) {
		//Frame setup
		JFrame frame = new JFrame("Network Analysis Program");
		JPanel panel = new JPanel(new GridLayout(6,2));

		//Label setup
		JLabel actName = new JLabel("Activity Name");
		JLabel duration = new JLabel("Duration");
		JLabel depend = new JLabel("Dependencies (separate by comma)");

		//Button setup
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

		enter.setPreferredSize(new Dimension(300, 150));
		generate.setPreferredSize(new Dimension(300, 150));
		restart.setPreferredSize(new Dimension(300, 150));
		quit.setPreferredSize(new Dimension(300, 150));

		//Text Field Setup
		JTextField actText = new JTextField();
		JTextField durationText = new JTextField();
		JTextField dependText = new JTextField();

		actText.setColumns(10);
		durationText.setColumns(10);
		dependText.setColumns(10);

		//Generic Panel Stuff
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

		frame.add(panel);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	//About button listener
	private static class AboutButtonListener implements ActionListener
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
	}

	//Help button listener
	private static class HelpButtonListener implements ActionListener
	{
	      public void actionPerformed (ActionEvent event)
	      {
	    	  	JFrame frame = new JFrame();
		  		JOptionPane about = new JOptionPane();
		  		about.setName("About");
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

		  		about.add(panel);
		  		frame.add(about);
		  		about.setSize(300,300);
		  		about.setVisible(true);
	      }
	}

	//Quit button Listener
	private static class QuitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
		      System.exit(0); //calling the method is a must
		}
	}

}