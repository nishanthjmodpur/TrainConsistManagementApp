package com.consistmanagement.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * =================================================================================
 * MAIN CLASS - USE CASE 10 - TRAIN CONSIST MANAGEMENT APP
 * =================================================================================
 * 
 * Use Case 10: Count total seats in train
 * 
 * Description: This class aggregates seating capacity of all bogies into a single 
 * total using Stream reduce().
 * 
* At this stage, the application:
 * - Creates a list of bogies
 * - Maps bogies to capacity
 * - Reduces values into total
 * - Displays total seat count
 * 
 * This maps aggregation logic using reduce().
 *  
 * @author Developer
 * @version 10.0
 */

public class TrainConsistManagementApp {
	
	static class Bogie {
		private String name;
		private int capacity;
		
		public Bogie(String name, int capacity) {
			this.name = name;
			this.capacity = capacity;
		}
		
		public String getName() {
			return name;
		}
		
		public int getCapacity() {
			return capacity;
		}
		
		
	}
	/**
	 * Main entry point for UC10
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("======================================");
		System.out.println(" === Train Consist Management App === ");
		System.out.println("======================================");

		List<Bogie> bogies = new ArrayList<Bogie>();
		bogies.add(new Bogie("Sleeper", 72));
		bogies.add(new Bogie("AC Chair", 56));
		bogies.add(new Bogie("First Class", 24));
		bogies.add(new Bogie("Sleeper", 70));
		bogies.add(new Bogie("AC Chair", 60));

		System.out.println("Train initialized successfully.....");
		System.out.println("Initial Bogie Count: " + bogies.size());

		Scanner scanner = new Scanner(System.in);
		String choice;

		do {
			System.out.println();
			System.out.println("1. Add Bogies");
			System.out.println("2. Remove Bogies");
			System.out.println("3. Check if Bogie Exists");
			System.out.println("4. Display Consists");
			System.out.println("5. Sort Bogies");
			System.out.println("6. Filter Bogies");
			System.out.println("7. Group bogies");
			System.out.println("8. Get total capacity");
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
					bogies.add(new Bogie(bogie, capacity));
					System.out.println(bogie + " with capacity " + capacity + " added successfully");
				}
				case "2" -> {
					System.out.println("Removing bogies");
					System.out.println("Enter bogie name to remove: ");
					String bogie = scanner.nextLine();
					for (Bogie b : bogies) {
						if (b.getName().equals(bogie)) {
							bogies.remove(bogie);
							System.out.println(bogie + " removed successfully");
						} else {
							System.out.println("Bogie not found");
						}
					}
				}
				case "3" -> {
					System.out.println("Enter bogie name: ");
					String bogie = scanner.nextLine();
					for (Bogie b : bogies) {
						if (b.getName().equals(bogie)) {
							System.out.println(bogie + " exists!");
						}
					}
				}
				case "4" -> {
					System.out.println("Displaying consist");
					for (Bogie b : bogies) {
						System.out.println(b.getName() + ": " + b.getCapacity());
					}
				}
				case "5" -> {
					Collections.sort(bogies, Comparator.comparingInt(Bogie::getCapacity));
					System.out.println("Bogies sorted successfully!!");
				}
				case "6" -> {
					System.out.println("Filtering Bogies with Capacity > 60: ");
					for(Bogie b : bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList())) {
						System.out.printf("%s -> %s\n", b.getName(), b.getCapacity());
					}
				}
				case "7" -> {
					Map<String, List<Bogie>> groupedBogies = bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
					System.out.println("Grouped bogies:");
					for(Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
						System.out.println(entry.getKey() + ": ");
						for(Bogie bogie : entry.getValue()) {
							System.out.printf("Capacity: %s\n", bogie.getCapacity());
						}
					}
				}
				case "8" -> {
					System.out.println("Total capacity: " + bogies.stream().map(b -> b.getCapacity()).reduce(0, Integer::sum));
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
