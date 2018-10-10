package DreamTeam360;

import java.util.ArrayList;
import java.util.HashMap;

public class TextInput {

  public static void main(String[] args) {
    System.out.println("BEFORE SORTING:\n");
    printArray();
    sortArray();
    System.out.println("\n\n\nAFTER SORTING:\n");
    printArray();
  }

  /**
   * 
   * Three structures to store data:
   * An array list with the activity name at an arbitrary index before sorting and the sequential index after sorting
   * A hash map where the key is the name and the value is the duration
   * A hash map where the key is the name and the value is the dependency
   */
  static ArrayList<String> userArray = new ArrayList<String>();
  static HashMap<String, Integer> userDurations = new HashMap<String, Integer>();
  static HashMap<String, String> userDependencies = new HashMap<String, String>();

  /**
   * 
   * @param name
   * @param duration
   * @param dependencies
   */
  public static void addToArray(String name, int duration, String dependencies) {
    userArray.add(name);
    userDurations.put(name, duration);
    userDependencies.put(name, dependencies);
  }

  /**
   * 
   * Prints array using for loop - there's probably a better way to do this
   */
  public static void printArray() {
	  System.out.println("PATHS: \n");
	  int total = 0;
    for (int i = 0; i < userArray.size(); i++) {
      String name = userArray.get(i);
      if (i == 0)
      {
    	  System.out.print(name);
    	  total += userDurations.get(name);
      }
      else
      {
      System.out.print(" -> " + name);
      total += userDurations.get(name);
      }
      //System.out.println("Name: " + name);
      //System.out.println("Duration: " + userDurations.get(name));
      //System.out.println("Dependencies: " + userDependencies.get(name) + "\n");
    }
    System.out.println("\nDuration: " + total);
  }

  /**
   * 
   * Starts with for loop to iterate through array of names
   * If an element is found that matches the current dependency we're searching for (which starts with
   * an empty string) the current element is put at the right index and the dependency is updated
   * Repeats until newCount (which represents the current index we're searching for) is equal to the size of userArray
   * 
   * This only works if there is a single path i.e. if no activities share the same dependency
   * I used a while loop but a for loop might look better/make more sense
   */
  public static void sortArray() {
    String searchingDependency = "";
    int newCount = 0;

    while (newCount < userArray.size()) {
      for (int i = 0; i < userArray.size(); i++) {
        String currentActivity = userArray.get(i);
        String currentDependency = userDependencies.get(currentActivity);
        //String comparison method rather than (== 0)
        if (currentDependency.compareTo(searchingDependency) == 0) {
          String temp = userArray.get(newCount);
          userArray.set(newCount, currentActivity);
          userArray.set(i, temp);
          newCount++;
          searchingDependency = currentActivity;
        }
      }
    }
  }

}
