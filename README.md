TrainConsistManagementApp
TrainConsistManagementApp is a modular Java console application for managing train consists (arrangements of locomotives and cars).
It demonstrates object-oriented principles and classic design patterns through twenty use cases (UC‑01 to UC‑20).
The application covers train creation, validation, safety compliance, grouping, counting, searching, sorting, performance benchmarking,
and exception handling. Each use case is implemented step by step to show how features evolve in a structured, educational way.

Use Cases
UC‑01: Initialize Train and Display Consist Summary
Goal: Initialize the Train Consist Management App and display the initial state of the train.
Drawback: The train consist is initialized but contains no bogies. There is no way yet to add, remove, or inspect bogies dynamically.

UC‑02: Add Passenger Bogies (ArrayList Operations)
Goal: Allow dynamic insertion and removal of passenger bogies using ArrayList.
Drawback: Bogies can be added and removed, but duplicates are possible, which is unsafe in a railway system.

UC‑03: Track Unique Bogie IDs (Set – HashSet)
Goal: Ensure no duplicate bogie IDs are added to the train.
Drawback: HashSet enforces uniqueness but does not preserve order, which is critical for real train formation.

UC‑04: Maintain Ordered Bogie IDs (TreeSet & SortedSet)
Goal: Maintain a predictable, ordered sequence of bogies (e.g., Passenger → Cargo → Guard Coach).
Drawback: While order is preserved, insertion/removal flexibility is limited compared to linked structures.

UC‑05: LinkedList for Train Chaining
Goal: Model real train chaining with insertion order preserved and efficient add/remove operations.

UC‑06: Validate Train Consist
Goal: Check rules such as minimum bogies or maximum capacity.

UC‑07: Safety Compliance Check
Goal: Verify compliance with safety rules such as brake ratio and weight limits.

UC‑08: Group Bogies by Type
Goal: Group bogies into passenger or freight categories.

UC‑09: Count Bogies by Attribute
Goal: Count bogies by type, capacity, or other attributes.

UC‑10: Search Bogies
Goal: Search bogies by ID, type, or capacity.

UC‑11: Sort Bogies
Goal: Sort bogies by ID, type, or capacity.

UC‑12: Performance Benchmarking
Goal: Compare loop vs stream performance using System.nanoTime().

UC‑13: Exception Handling
Goal: Handle invalid input or missing bogie errors with custom exceptions.

UC‑14: Bulk Operations
Goal: Perform bulk delete, validation, or export operations.

UC‑15: Advanced Filtering
Goal: Filter bogies by multiple attributes such as type or capacity.

UC‑16: Reporting
Goal: Generate reports on train consists (e.g., total bogies, compliance status).

UC‑17: Exception Logging & Recovery
Goal: Log errors and apply recovery strategies.

UC‑18: Grouping Variants
Goal: Explore additional grouping scenarios (e.g., by frequency, date added).

UC‑19: Sorting Variants
Goal: Implement extended sorting scenarios (multi‑criteria, chained comparators).

UC‑20: Searching Variants
Goal: Implement extended search scenarios (multi‑criteria, tag‑based).
