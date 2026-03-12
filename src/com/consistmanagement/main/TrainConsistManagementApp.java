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

/**
 * =================================================================================
 * MAIN CLASS - USE CASE 7 - TRAIN CONSIST MANAGEMENT APP
 * =================================================================================
 * 
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 * 
 * Description: This class sorts passenger bogies based on seating capacity using
 * a custom comparator.
 * 
 * At this stage, the application:
 * 	- Creates bogie objects
 *  - Stores them in a list
 *  - Displays unsorted array
 *  - Sorts using Comparator logic
 *  - Displays sorted result
 * 
 * This maps lookup based access HashMap.
 * 
 * @author Developer
 * @version 7.0
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
	 * Main entry point for UC6
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("======================================");
		System.out.println(" === Train Consist Management App === ");
		System.out.println("======================================");

		List<Bogie> bogies = new ArrayList<Bogie>();
//		Map<String, Integer> capacityMap = new HashMap<String, Integer>();

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
//					capacityMap.put(bogie, capacity);
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
