package com.consistmanagement.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * =================================================================================
 * MAIN CLASS - USE CASE 6 - TRAIN CONSIST MANAGEMENT APP
 * =================================================================================
 * 
 * Use Case 6: Map Bogie to Capacity (Hash Map)
 * 
 * Description: This class associates each bogie with its seating
 * or load capacity using key-value mapping structure.
 * 
 * At this stage, the application:
 * 	- Creates a HashMap for bogie capacity mapping
 *  - Inserts capacity values for each bogie
 *  - Iterates through map entries
 *  - Displays bogie and capacity information
 * 
 * This maps lookup based access HashMap.
 * 
 * @author Developer
 * @version 6.0
 */

public class TrainConsistManagementApp {
	/**
	 * Main entry point for UC6
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("======================================");
		System.out.println(" === Train Consist Management App === ");
		System.out.println("======================================");

		Map<String, Integer> capacityMap = new HashMap<String, Integer>();

		System.out.println("Train initialized successfully.....");
		System.out.println("Initial Bogie Count: " + capacityMap.size());

		Scanner scanner = new Scanner(System.in);
		String choice;

		do {
			System.out.println();
			System.out.println("1. Add Bogies");
			System.out.println("2. Remove Bogies");
			System.out.println("3. Check if Bogie Exists");
			System.out.println("4. Display Consists");
			System.out.println("0. Exit");
			System.out.print("Enter your Choice: ");

			choice = scanner.nextLine();
			switch (choice) {
				case "1" -> {
					System.out.println("Adding Bogies");
					System.out.println("Enter bogie name to add: ");
					String bogie = scanner.nextLine();
					System.out.println("Enter the capacity of the bogie: ");
					int capacity = scanner.nextInt();
					scanner.nextLine();
					capacityMap.put(bogie, capacity);
					System.out.println(bogie + " with capacity " + capacity + " added successfully");
				}
				case "2" -> {
					System.out.println("Removing bogies");
					System.out.println("Enter bogie name to remove: ");
					String bogie = scanner.nextLine();
					if (capacityMap.containsKey(bogie)) {
						capacityMap.remove(bogie);
						System.out.println(bogie + " removed successfully");
					} else {
						System.out.println("Bogie not found");
					}
				}
				case "3" -> {
					System.out.println("Enter bogie name: ");
					String bogie = scanner.nextLine();
					if (capacityMap.containsKey(bogie)) {
						System.out.println("Bogie exists");
					} else {
						System.out.println("Bogie doesn't exist");
					}
				}
				case "4" -> {
					System.out.println("Displaying consist");
					for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
				}
				case "0" -> {
					System.out.println("EXITING");
				}
				default -> {
					System.out.println("Enter a valid choice");
				}
			}
		} while (!choice.equals("0"));
		scanner.close();
	}
}
