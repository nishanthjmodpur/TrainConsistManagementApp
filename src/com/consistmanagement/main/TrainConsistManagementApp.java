package com.consistmanagement.main;

import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * =================================================================================
 * MAIN CLASS - USE CASE 20 - TRAIN CONSIST MANAGEMENT APP
 * =================================================================================
 * 
 * Use Case 20: Exception Handling During Search Operations
 * 
 * Description:
 * This class prevents searching when no bogies exist
 * by applying fail-fast validation using exceptions.
 * 
 * At this stage, the application:
 * - Creates bogie collection
 * - Validates system state
 * - Throws exception if empty
 * - Stops invalid search operation
 * - Displays meaningful message
 * 
 * This maps defensive programming using runtime exceptions.
 * 
 * @author Developer
 * @version 20.0
 */

public class TrainConsistManagementApp {
	
	static class InvalidCapacityException extends Exception {
		public InvalidCapacityException(String message) {
			super(message);
		}
	}
	
	static class CargoSafetyException extends RuntimeException {
		public CargoSafetyException(String message) {
			super(message);
		}
	}
	
	static class IllegalStateException extends RuntimeException {
		public IllegalStateException(String message) {
			super(message);
		}
	}
	
	static class Bogie {
		private String name;
		private int capacity;
		
		public Bogie(String name, int capacity) throws InvalidCapacityException {
			if (capacity <= 0) {
				throw new InvalidCapacityException("Capacity should be greater than zero");
			}
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
	
	static class GoodsBogie {
		private String type;
		private String cargo;
		
		public GoodsBogie(String type, String cargo) {
			this.type = type;
			this.cargo = cargo;
		}
		
		public String getType() {
			return type;
		}
		
		public String getCargo() {
			return cargo;
		}
	}
	
	private static void bogieConsist(Scanner scanner) throws InvalidCapacityException, IllegalStateException {
		List<Bogie> bogies = new ArrayList<Bogie>();
		bogies.add(new Bogie("Sleeper", 72));
		bogies.add(new Bogie("AC Chair", 56));
		bogies.add(new Bogie("First Class", 24));
		bogies.add(new Bogie("Sleeper", 70));
		bogies.add(new Bogie("AC Chair", 60));
		
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
			System.out.println("9. validate Train ID and Cargo ID");
			System.out.println("10. Sort Bogies using Bubble Sort");
			System.out.println("12. Linear Search");
			System.out.println("13. Binary Search");
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
				case "9" -> {
					System.out.println("Enter TrainId (Format: TRN-1234): ");
					String trainId = scanner.nextLine();
					System.out.println("Enter CargoId (Format: PET-AB");
					String cargoId = scanner.nextLine();
					if (validateTrainId(trainId)) {
						System.out.println("Train Id valid");
					} else {
						System.out.println("Train id invlaid");
					}
					
					if (validateCargoId(cargoId)) {
						System.out.println("Cargo Id valid");
					} else {
						System.out.println("Cargo Id invalid");
					}
				}
				case "10" -> {
					int capacities[] = new int[bogies.size()];
					
					int idx = 0;
					for(Bogie b : bogies) {
						capacities[idx] = b.getCapacity();
						idx++;
					}
					
					System.out.println("Original Capacity: ");
					for (int c : capacities) {
						System.out.print(c + " ");
					}
					
					for(int i = 0; i < capacities.length - 1; i++) {
						for(int j  = 0; j < capacities.length - i - 1; j++) {
							if(capacities[i] > capacities[i + 1]) {
								int temp = capacities[i];
								capacities[i] = capacities[i + 1];
								capacities[i + 1] = temp;
							}
						}
					}
					
					System.out.println("Sorted Bogies (Ascending): ");
					for (int c : capacities) {
						System.out.print(c + " ");
					}
				}
				case "11" -> {
					String types[] = new String[bogies.size()];
					
					int idx = 0;
					for(Bogie bogie : bogies) {
						types[idx] = bogie.getName();
						idx++;
					}
					
					System.out.println("Original Bogie Names: \n" + Arrays.toString(types) + "\n");
					Arrays.sort(types);
					System.out.println("Sorted Bogie Names (Alphabetical): \n" + Arrays.toString(types) + "\n");
				}
				case "12" -> {
					String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
					
					System.out.print("Enter Bogie ID to Search: ");
					String searchId = scanner.nextLine();
					
					System.out.println("Available Bogie IDs: ");
					for(String id : bogieIds) {
						System.out.println(id);
					}
					
					boolean found = false;
					for(String id : bogieIds) {
						if(searchId.equals(id)) {
							found = true;
							break;
						}
					}
					
					if(found) {
						System.out.printf("Bogie %s found in train consist\n", searchId);
					}else {
						System.out.printf("Bogie %s NOT found in train consist\n", searchId);
					}
				}
				case "13" -> {
					String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
					
					if (bogieIds.length == 0) {
						throw new IllegalStateException("No bogies exist");
					}
					
					System.out.print("Enter Bogie ID to Search: ");
					String searchId = scanner.nextLine();
					
					System.out.println("Available Bogie IDs: ");
					for(String id : bogieIds) {
						System.out.println(id);
					}
					
					boolean found = false;
					
					int start = 0;
					int end = bogieIds.length;
					
					while(start <= end) {
						int mid = start + (end - start) / 2;
						if(bogieIds[mid].equals(searchId)) {
							found = true;
							break;
						}else if(searchId.compareTo(bogieIds[mid]) < 0) {
							end = mid - 1;
						}else {
							start = mid + 1;
						}
					}
					
					
					if(found) {
						System.out.printf("Bogie %s found in train consist\n", searchId);
					}else {
						System.out.printf("Bogie %s NOT found in train consist\n", searchId);
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

	}
	
	private static void cargoTrain(Scanner scanner) throws CargoSafetyException {
		List<GoodsBogie> goodsBogies = new ArrayList<TrainConsistManagementApp.GoodsBogie>();
		
		String choice;
		
		do {
			System.out.println();
			System.out.println("1. Add Bogies");
			System.out.println("2. Remove Bogies");
			System.out.println("3. Check if Bogie Exists");
			System.out.println("4. Display Consists");
			System.out.println("5. Check Cargo compliance");
			System.out.println("0. Exit");
			System.out.print("Enter your Choice: ");
			
			choice = scanner.nextLine();
			
			switch (choice) {
			case "1" -> {
				System.out.println("Adding Bogies");
				System.out.println("Enter bogie name to add: ");
				String type = scanner.nextLine();
				System.out.println("Enter the capacity of the bogie: ");
				String cargo = scanner.nextLine();
				goodsBogies.add(new GoodsBogie(type, cargo));
				System.out.println(type + " with capacity " + cargo + " added successfully");
			}
			case "2" -> {
				System.out.println("Removing bogies");
				System.out.println("Enter bogie name to remove: ");
				String type = scanner.nextLine();
				
				for (GoodsBogie b : goodsBogies) {
					if (b.getType().equals(type)) {
						goodsBogies.remove(b);
						System.out.println(type + " removed successfully");
					} else {
						System.out.println("Bogie not found");
					}
					}
				}
			case "3" -> {
				System.out.println("Enter bogie name: ");
				String type = scanner.nextLine();
				for (GoodsBogie b : goodsBogies) {
					if (b.getType().equals(type)) {
						System.out.println(type + " exists!");
					}
				}
			}
			case "4" -> {
				System.out.println("Displaying consist");
				for (GoodsBogie b : goodsBogies) {
					System.out.println(b.getType() + ": " + b.getCargo());
				}
			}
			case "5" -> {
				long streamStartTime = System.nanoTime();
				boolean isSafe = goodsBogies.stream().allMatch(b -> b.getType().equalsIgnoreCase("Cylindrical") && b.getCargo().equalsIgnoreCase("Coal"));
				long streamStopTime = System.nanoTime();
				
				long loopStartTime = System.nanoTime();
				for (GoodsBogie g : goodsBogies) {
					if (g.getType().equalsIgnoreCase("Cylindrical") && g.getCargo().equalsIgnoreCase("Coal")) {
						isSafe = false;
						break;
					}
				}
				long loopEndTime = System.nanoTime();
				
				System.out.println("Loop: " + (loopEndTime - loopStartTime));
				System.out.println("Stream: " + (streamStopTime - streamStartTime));
				
				System.out.println("Safety Complicance Status: " + isSafe);
				System.out.println("Train formation is " + (isSafe ? "SAFE" : "NOT SAFE"));
				if (!isSafe) {
					throw new CargoSafetyException("Unsafe for Cargo Use");
				}
			}
			}
		} while (!choice.equals("0"));
	}
	
	private static boolean validateTrainId(String trainId) {
		final String TRAIN_ID_REGEX = "TRN-\\d4{4}";
		
		Pattern trainIdPattern = Pattern.compile(TRAIN_ID_REGEX);
		Matcher matcher =  trainIdPattern.matcher(trainId);
		if (matcher.matches()) {
			return true;
 		}
		return false;
	}
	
	private static boolean validateCargoId(String cargoId) {
		final String CARGO_ID_REGEX = "PET-[A-Z]{2}";
		
		Pattern cargoIdPattern = Pattern.compile(CARGO_ID_REGEX);
		Matcher matcher = cargoIdPattern.matcher(cargoId);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Main entry point for UC19
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("======================================");
		System.out.println(" === Train Consist Management App === ");
		System.out.println("======================================");



		System.out.println("Train initialized successfully.....");

		Scanner scanner = new Scanner(System.in);
		String choice;

		do {
			System.out.println();
			System.out.println("1. bogie consist");
			System.out.println("2. Cargo train");
			System.out.println("0. Exit");
			System.out.print("Enter your Choice: ");

			choice = scanner.nextLine();
			switch (choice) {
				case "1" -> {
					try {
						bogieConsist(scanner);
					} catch (InvalidCapacityException e) {
						System.out.println("Exception: " + e.getMessage());
					}
				}
				case "2" -> {
					try {
						cargoTrain(scanner);					
					} catch (CargoSafetyException e) {
						System.out.println("Exception: " + e.getMessage());
					} finally {
						System.out.println("Cargo Safety check done");
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
