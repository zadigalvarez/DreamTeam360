package DreamTeam360;

import java.util.ArrayList;
import java.util.HashMap;

public class TextInput {

	public static void main(String[] args) {

		ArrayList<String> firstDep = new ArrayList<String>();
		firstDep.add("");
		ArrayList<String> secondDep = new ArrayList<String>();
		secondDep.add("A");
		ArrayList<String> thirdDep = new ArrayList<String>();
		thirdDep.add("A");
		ArrayList<String> fourthDep = new ArrayList<String>();
		fourthDep.add("B");
		ArrayList<String> fifthDep = new ArrayList<String>();
		fifthDep.add("C");
		ArrayList<String> sixthDep = new ArrayList<String>();
		sixthDep.add("D");
		sixthDep.add("E");

		addToArray("A", 2, firstDep);
		addToArray("B", 3, secondDep);
		addToArray("C", 4, thirdDep);
		addToArray("D", 5, fourthDep);
		addToArray("E", 6, fifthDep);
		addToArray("F", 7, sixthDep);

		//System.out.println("BEFORE SORTING:\n"); printArray();
		//sortArray();
		//System.out.println("\n\n\nAFTER SORTING:\n"); printArray();

		System.out.println(findNumPaths());
		System.out.println(findFinalNums());
	}

	/**
	 * 
	 * Three structures to store data: An array list with the activity name at an
	 * arbitrary index before sorting and the sequential index after sorting A hash
	 * map where the key is the name and the value is the duration A hash map where
	 * the key is the name and the value is the dependency
	 */
	static ArrayList<String> userArray = new ArrayList<String>();
	static HashMap<String, Integer> userDurations = new HashMap<String, Integer>();
	static HashMap<String, ArrayList<String>> userDependencies = new HashMap<String, ArrayList<String>>();
	static ArrayList<String> finalNums = new ArrayList<String>();

	/**
	 * 
	 * @param name
	 * @param duration
	 * @param dependencies
	 */
	public static void addToArray(String name, int duration, ArrayList<String> dependencies) {
		userArray.add(name);
		userDurations.put(name, duration);
		userDependencies.put(name, dependencies);
	}

	public static void resetArray() {
		userArray = new ArrayList<String>();
		userDurations = new HashMap<String, Integer>();
		userDependencies = new HashMap<String, ArrayList<String>>();
	}

	/**
	 * 
	 * Prints array using for loop - there's probably a better way to do this
	 */
	public static void printArray() {
		for (int i = 0; i < userArray.size(); i++) {
			String name = userArray.get(i);
			System.out.println("Name: " + name);
			System.out.println("Duration: " + userDurations.get(name));
			System.out.println("Dependencies: " + userDependencies.get(name) + "\n");
		}
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
				ArrayList<String> currentDependencies = userDependencies.get(currentActivity);
				for(int j = 0; j < currentDependencies.size(); j++) {
					String currentDependency = currentDependencies.get(j);
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

	public static int findNumPaths() {
		int numPaths = 1;
		for(int i = 0; i < userArray.size(); i++) {
			String currentActivity = userArray.get(i);
			for(int j = 0; j < userDependencies.get(currentActivity).size(); j++) {
				for(int k = i+1; k < userArray.size(); k++) {
					String nextActivity = userArray.get(k);
					for(int l = 0; l < userDependencies.get(nextActivity).size(); l++) {
						if(userDependencies.get(currentActivity).get(j) == userDependencies.get(nextActivity).get(l)) {
							numPaths++;
						}
					}
				}
			}
		}
		return numPaths;
	}

	public static ArrayList<String> findFinalNums() {
		ArrayList<String> finalNums = new ArrayList<String>();
		boolean isEnd = true;

		for(int i = 0; i < userArray.size(); i++) {
			isEnd = true;
			String currentActivity = userArray.get(i);
			for(int j = 0; j < userArray.size(); j++) {
				String nextActivity = userArray.get(j);
				for(int k = 0; k < userDependencies.get(nextActivity).size(); k++) {
					String nextDependency = userDependencies.get(nextActivity).get(k);
					if(currentActivity.compareTo(nextDependency) == 0) {
						isEnd = false;
					}
				}
			}
			if(isEnd == true) {
				for(int l = 0; l < userDependencies.get(currentActivity).size(); l++) {
					finalNums.add(currentActivity);
				}
			}
		}

		return finalNums;
	}

}
