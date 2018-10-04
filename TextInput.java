import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TextInput {
	
	static HashMap<String, Integer> userDurations = new HashMap<String, Integer>();
	static HashMap<String, String> userDependencies = new HashMap<String, String>();
	static ArrayList<String> userArray = new ArrayList<String>();
	
	static int count = 0;
	
	public static void addToArray(String name, int duration, String dependencies) {
		userDurations.put(name, duration);
		userDependencies.put(name, dependencies);
		userArray.add(name);
		count++;
	}
	
	public static void printArray() {
	    for(int i = 0; i < count; i++) {
	    	String name = userArray.get(i);
	    	System.out.println("Name: " + name);
	    	System.out.println("Duration: " + userDurations.get(name));
	    	System.out.println("Dependencies: " + userDependencies.get(name));
	    }
	}
	
	public static void sortArray() {
		String currentDependency = "";
		int newCount = 0;
		
		for(int i = 0; i < count; i++) {
			String currentName = userArray.get(i);
			if(userDependencies.get(currentName) == currentDependency) {
				String temp = userArray.get(newCount);
				userArray.add(newCount, currentName);
				userArray.add(i, temp);
				currentDependency = currentName;
			}
		}
	}

}
