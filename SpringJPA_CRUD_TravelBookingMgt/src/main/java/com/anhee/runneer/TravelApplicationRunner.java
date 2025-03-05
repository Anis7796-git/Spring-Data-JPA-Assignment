package com.anhee.runneer;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anhee.controller.TravelController;
import com.anhee.entity.Travel;

@Component
public class TravelApplicationRunner implements CommandLineRunner {

    @Autowired
    private TravelController travelController;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Travel Booking Application Menu ---");
            System.out.println("1. Add a new travel booking");
            System.out.println("2. Retrieve all travel bookings");
            System.out.println("3. Find a travel booking by ID");
            System.out.println("4. Delete a travel booking by ID");
            System.out.println("5. Check if a travel booking exists");
            System.out.println("6. Count total travel bookings");
            System.out.println("7. Delete a specific travel booking");
            System.out.println("8. Delete all travel bookings");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                	System.out.println("Enter travel details");

                	System.out.print("Enter your Destination: ");
                	String destination = scanner.nextLine();  

                	System.out.print("Enter your Transportation Mode: ");
                	String tmode = scanner.nextLine();  
                	System.out.print("Enter price: ");
                	double price = scanner.nextDouble();
                	scanner.nextLine(); 
                    
                    Travel travel = new Travel();
                    travel.setDestination(destination);
                    travel.setTransportatoinMode(tmode);
                    travel.setPrice(price);
                    
                    System.out.println(travelController.addTravel(travel));
                    break;

                case 2:
                    travelController.retrieveAllTravels().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Travel ID: ");
                    int id = scanner.nextInt();
                	scanner.nextLine(); 
                    Optional<Travel> travelById = travelController.findTravelById(id);
                    
                    
                    travelById.ifPresentOrElse(
                    	    System.out::println,
                    	    () -> System.out.println("No travel found with this ID")
                    	);

                    break;

                case 4:
                    System.out.print("Enter Travel ID to delete: ");
                    id = scanner.nextInt();
                	scanner.nextLine(); 
                    System.out.println(travelController.deleteTravelById(id));
                    break;

                case 5:
                    System.out.print("Enter Travel ID to check: ");
                    id = scanner.nextInt();
                	scanner.nextLine(); 
                    if (travelController.checkIfTravelExists(id)) {
                        System.out.println("Travel exists");
                    } else {
                        System.out.println("Travel does not exist");
                    }

                    break;

                case 6:
                    System.out.println("Total travels: " + travelController.countTravels());
                    break;

                case 7:
                    System.out.print("Enter Travel ID to delete by object: ");
                    id = scanner.nextInt();
                    Travel travelObj = new Travel();
                    travelObj.setId(id);
                    System.out.println(travelController.deleteTravelObject(travelObj));
                    break;

                case 8:
                    System.out.println(travelController.deleteAllTravels());
                    break;

                case 9:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
