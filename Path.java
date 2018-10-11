import java.util.ArrayList;

public class Path {
	private int totalduration;
	private ArrayList<Node> nodelist;
	public Path(ArrayList<Node> list)
	{
		nodelist = list;
		totalduration = calculateDuration(nodelist);
	}
	
	public int calculateDuration(ArrayList<Node> list){
		int total = 0;
		for(int i = 0; i < list.size(); i++)
		{
			total += list.get(i).getDuration();
		}
		return total;
	}
	
	//getter methods
	public int getDuration()
	{
		return totalduration;
	}
	
	public String printList()
	{
		String result = "";
		
		for(int i = 0; i < nodelist.size() - 1; i++)
		{
			result += nodelist.get(i).getName() + "->";
			
		}
		result += nodelist.get(nodelist.size() - 1).getName();
		result += "\nDuration: " + totalduration;
		
		return result;
				
	}
	
}
