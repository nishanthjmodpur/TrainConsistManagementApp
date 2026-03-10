package com.consistmanagement.main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * =================================================================================
 * MAIN CLASS - USE CASE 4 - TRAIN CONSIST MANAGEMENT APP
 * =================================================================================
 * 
 * Use Case 4: Maintain Ordered Bogie IDs
 * 
 * Description: This class models the physical chaining of
 * train bogies using LinkedList for ordered operations.
 * 
 * At this stage, the application:
 * 	- Adds bogies in sequence
 *  - Inserts bogies at specific positions
 *  - Removes bogies from front and rear
 *  - Displays updated train structure
 * 
 * This maps positional operations using LinkedList.
 * 
 * @author Developer
 * @version 4.0
 */

public class TrainConsistManagementApp {
	/**
	 * Main entry point for UC4
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("======================================");
		System.out.println(" === Train Consist Management App === ");
		System.out.println("======================================");

		List<String> trainConsist = new LinkedList<String>();

		System.out.println("Train initialized successfully.....");
		System.out.println("Initial Bogie Count: " + trainConsist.size());

		Scanner scanner = new Scanner(System.in);
		String choice;

		do {
			System.out.println("1. Add Bogie to a specific position");
			System.out.println("2. Add bogies to front");
			System.out.println("3. Add bogies to rear");
			System.out.println("4. Remove Bogie from front");
			System.out.println("5. Remove Bogie from rear");
			System.out.println("6. Check if Bogie Exists");
			System.out.println("7. Display Consists");
			System.out.println("0. Exit");
			System.out.print("Enter your Choice: ");

			choice = scanner.nextLine();

			switch (choice) {
				case "1" -> {
					System.out.println("Adding Bogies");
					System.out.println("Enter bogie name to add: ");
					String bogie = scanner.nextLine();
					System.out.println("Enter position of bogie to add");
					int position = scanner.nextInt();
					scanner.nextLine();
					trainConsist.add(position, bogie);
					System.out.println(bogie + " added successfully");
				}
				case "2" -> {
					System.out.println("Adding Bogies to Front");
					System.out.println("Enter bogie name to add: ");
					String bogie = scanner.nextLine();
					trainConsist.addFirst(bogie);
					System.out.println(bogie + " added successfully");
				}
				case "3" -> {
					System.out.println("Adding Bogies to Back");
					System.out.println("Enter bogie name to add: ");
					String bogie = scanner.nextLine();
					trainConsist.addLast(bogie);
					System.out.println(bogie + " added successfully");
				}
				case "4" -> {
					System.out.println("Removing bogies from front");
					trainConsist.removeFirst();
					System.out.println("front bogie removed successfully");
				}
				case "5" -> {
					System.out.println("Removing bogies from front");
					trainConsist.removeLast();
					System.out.println("front bogie removed successfully");
				}
				case "6" -> {
					System.out.println("Enter bogie name: ");
					String bogie = scanner.nextLine();
					if (trainConsist.contains(bogie)) {
						System.out.println("Bogie exists");
					} else {
						System.out.println("Bogie doesn't exist");
					}
				}
				case "7" -> {
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
