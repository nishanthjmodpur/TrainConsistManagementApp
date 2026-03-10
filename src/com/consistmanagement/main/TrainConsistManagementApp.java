package com.consistmanagement.main;

import java.util.ArrayList;
import java.util.List;

/**
 * =================================================================================
 *  MAIN CLASS - USE CASE 1 - TRAIN CONSIST MANAGEMENT APP 
 * =================================================================================
 * 
 * Use Case 1: Initialize Train and Display Consist Summary
 * 
 * Description:
 *  This class represents the entry point of the train consist management application.
 *  
 *  At this stage, the application:
 *  	- Creates an empty train consist
 *  	- Uses a dynamic list to store bogies
 *  	- Display initial bogie count
 *  	- Prints the current state of the train
 *  
 *  This use case introduces collection initialization and basic program
 *  startup flow.
 *  
 *  @author Development
 *  @version 1.0
 */


public class TrainConsistManagementApp {
	/**
	 * Main entry point for UC1
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("======================================");
		System.out.println(" === Train Consist Management App === ");
		System.out.println("======================================");
		
		List<String> trainConsist = new ArrayList<String>();
		
		System.out.println("Train initialized successfully.....");
		System.out.println("Initial Bogie Count: " + trainConsist.size());
		
	}
}
