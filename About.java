import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class About {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JOptionPane about = new JOptionPane();
		about.setName("About");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JOptionPane.showMessageDialog(frame, "The Network Analysis Program was created by Zadig Alvarez, Miguel Cuen, Matthew Davison, and Christian Lopez for CSE360 with Dr. Debra Callis. "
				+ "The program assists with project planning by providing a list of possible paths required for project completion based on activites, durations, and dependencies.", "About", JOptionPane.INFORMATION_MESSAGE);
		
		about.add(panel);
		frame.add(about);
		about.setSize(300,300);
		about.setVisible(true);		
	}

}
