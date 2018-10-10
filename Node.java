import java.util.*;

public class Node 
{
	private String name;
	private int duration;
	private ArrayList<String> dependencies;
	
	public Node(String name, int duration, ArrayList<String> dependencies)
	{
		this.name = name;
		this.duration = duration;
		this.dependencies = dependencies;
	}
	
	//setter methods
	public void setName(String nam)
	{
		name = nam;
	}
	public void setDuration(int dur)
	{
		duration = dur;
	}
	public void setDependencies(ArrayList<String> dep)
	{
		dependencies = dep;
	}
	
	//getter methods
	public String getName()
	{
		return name;
	}	
	public int getDuration()
	{
		return duration;
	}
	public ArrayList<String> getDependencies()
	{
		return dependencies;
	}
	
}
