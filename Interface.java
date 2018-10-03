import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Interface extends JPanel{

	public static void main(String[] args) {
		//Frame setup
		JFrame frame = new JFrame("Network Analysis Program");
		JPanel panel = new JPanel(new GridLayout(6,6));
		
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
		
		//Generic frame stuff
		frame.add(panel);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}