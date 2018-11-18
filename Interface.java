import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class Interface extends JFrame
{
	public static void main(String[] args) 
	{
		
		ArrayList<Node> nodelist = new ArrayList<Node>();
		ArrayList<Path> paths = new ArrayList<Path>();
		boolean circularError = false;
		InterfacePanel2 panel = new InterfacePanel2(nodelist, paths, circularError);
		
		//frame setup
		JFrame frame = new JFrame("Network Analysis Program");
		frame.add(panel);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
}