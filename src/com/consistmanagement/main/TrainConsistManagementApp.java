package com.consistmanagement.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * =================================================================================
 * MAIN CLASS - USE CASE 3 - TRAIN CONSIST MANAGEMENT APP
 * =================================================================================
 * 
 * Use Case 3: Track Unique Bogie IDs
 * 
 * Description: This class ensures that duplicate bogie IDs are not added into
 * the train formation using HashSet.
 * 
 * At this stage, the application:
 * 	- Store bogie IDs
 *  - Prevents duplicates automatically
 *  - Displays unique bogie identifiers
 * 
 * This maps uniqueness validation using Set.
 * 
 * @author Developer
 * @version 3.0
 */

public class TrainConsistManagementApp {
	/**
	 * Main entry point for UC3
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("======================================");
		System.out.println(" === Train Consist Management App === ");
		System.out.println("======================================");

		Set<String> trainConsist = new HashSet<String>();

		System.out.println("Train initialized successfully.....");
		System.out.println("Initial Bogie Count: " + trainConsist.size());

		Scanner scanner = new Scanner(System.in);
		String choice;

		do {
			System.out.println("1. Add Bogies");
			System.out.println("2. Remove Bogies");
			System.out.println("3. Check if Bogie Exists");
			System.out.println("4. Display Consists");
			System.out.println("5. Exit");
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
						System.out.println("Couldn't add bogie");
					}
				}
				case "2" -> {
					System.out.println("Enter bogie name to remove: ");
					String bogie = scanner.nextLine();
					if (trainConsist.contains(bogie)) {
						trainConsist.remove(bogie);
					} else {
						System.out.println("Bogie doesn't exist");
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
				case "5" -> {
					System.out.println("EXITING");
				}
			}
		} while (!choice.equals("5"));
		
		
		scanner.close();
	}
}
