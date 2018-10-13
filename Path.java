import java.util.*;

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
	public ArrayList<Node> getNodeList()
	{
		return nodelist;
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
	
	@Override
	public boolean equals(Object o)
	{
		boolean result = true;
		
		if (o != null && o instanceof Path)
		{
			Path object = (Path)o;
			//paths are of same size
			if(this.getNodeList().size() == object.getNodeList().size())
			{
				Node temp;
				ArrayList<Node> list1 = this.getNodeList();
				ArrayList<Node> list2 = object.getNodeList();
				for(int i = 0; i < this.getNodeList().size(); i++)
				{
					//nodes in same position are not equal
					if (list1.get(i).equals(list2.get(i)) == false)
					{
						result = false;
					}
				}
			}
			//paths are of different size
			else
			{
				result = false;
			}
		}
		
		else
		{
			result = false;
		}
		return result;
	}
	
	@Override
	public int hashCode() 
	{
	      return this.getNodeList().hashCode();
	}
	
}
