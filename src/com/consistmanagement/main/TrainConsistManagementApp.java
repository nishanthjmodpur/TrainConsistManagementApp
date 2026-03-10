package com.consistmanagement.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * =================================================================================
 * MAIN CLASS - USE CASE 2 - TRAIN CONSIST MANAGEMENT APP
 * =================================================================================
 * 
 * Use Case 2: Add Passenger Bogies to Train
 * 
 * Description: This class demonstrates how passenger bogies can be managed
 * dynamically using ArrayList operations.
 * 
 * At this stage, the application: - Adds new Bogies to the train - Removes
 * existing bogies - Checks for bogie availability - Displays the final consist
 * 
 * This maps CRUD operations to ArrayList
 * 
 * @author Development
 * @version 2.0
 */

public class TrainConsistManagementApp {
	/**
	 * Main entry point for UC2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("======================================");
		System.out.println(" === Train Consist Management App === ");
		System.out.println("======================================");

		List<String> trainConsist = new ArrayList<String>();

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
					trainConsist.add(bogie);
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
