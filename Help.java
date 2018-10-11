import javax.swing.*;
import java.awt.*;

public class Help {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JOptionPane help = new JOptionPane();
		help.setName("help");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JOptionPane.showMessageDialog(frame,"<html><body><p style='width: 200px;'>" + "The Network Analysis Program is designed to create a lsit of required paths to be completed by the user after accepting a number of inputs"
				 + "Inputs come in the form of an activity name, a duration, and a list of dependencies. The NAP will use these inputs to create paths, which show the total duration for each, as well as all activity names along the path."
				 + "To use, enter an activity name and duration. If the activity's start is dependent on other processess' completion, enter the name of the dependencies, separated by commas."
				  + "To add additional activities, select 'Add Another Activity'. To view the possible outcomes, select 'Generate'. To start over, select 'Restart'. To clsoe the program, select 'Quit'." + "</p></body></html>");
		help.add(panel);
		frame.add(help);
		help.setSize(300,300);
		help.setVisible(true);
	}

}