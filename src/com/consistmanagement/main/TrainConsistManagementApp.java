package com.consistmanagement.main;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * =================================================================================
 * MAIN CLASS - USE CASE 5 - TRAIN CONSIST MANAGEMENT APP
 * =================================================================================
 * 
 * Use Case 5: Preserve Insertion Order of Bogies
 * 
 * Description: This class maintains the exact attachment order
 * of bogies while also preventing duplicate entries using
 * LinkedHashSet.
 * 
 * At this stage, the application:
 * 	- Attaches bogies in order
 *  - Preserves Insertion sequence
 *  - Avoids duplicate bogies
 *  - Displays final train formation
 * 
 * This maps positional operations using LinkedList.
 * 
 * @author Developer
 * @version 5.0
 */

public class TrainConsistManagementApp {
	/**
	 * Main entry point for UC5
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("======================================");
		System.out.println(" === Train Consist Management App === ");
		System.out.println("======================================");

		Set<String> trainConsist = new LinkedHashSet<String>();

		System.out.println("Train initialized successfully.....");
		System.out.println("Initial Bogie Count: " + trainConsist.size());

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
					if (trainConsist.add(bogie)) {
						System.out.println(bogie + " added successfully");
					} else {
						System.out.println("Bogie already exists");
					}
				}
				case "2" -> {
					System.out.println("Removing bogies");
					System.out.println("Enter bogie name to remove: ");
					String bogie = scanner.nextLine();
					if (trainConsist.contains(bogie)) {
						trainConsist.remove(bogie);
						System.out.println(bogie + " removed successfully");
					} else {
						System.out.println("Bogie not found");
					}
				}
				case "3" -> {
					System.out.println("Enter bogie name: ");
					String bogie = scanner.nextLine();
					if (trainConsist.contains(bogie)) {
						System.out.println("Bogie exists");
					} else {
						System.out.println("Bogie doesn't exist");
					}
				}
				case "4" -> {
					System.out.println("Displaying consist");
					System.out.println(trainConsist);
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
