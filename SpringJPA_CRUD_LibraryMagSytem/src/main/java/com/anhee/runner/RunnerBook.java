package com.anhee.runner;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anhee.controller.BookController;
import com.anhee.entity.Book;

@Component
public class RunnerBook implements CommandLineRunner{

	@Autowired
	private BookController bookcon;

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner= new Scanner(System.in);
		
		while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add a new book");
            System.out.println("2. Retrieve all books");
            System.out.println("3. Find a book by ID");
            System.out.println("4. Delete a book by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                	
                	System.out.println("Book Author name");
                	String name = scanner.next();
                	
                	System.out.println("Book Catogry");
                	String cat = scanner.next();
                	
                	
                	System.out.println("Book price");
                	
                	 double price = scanner.nextDouble();
                	 scanner.nextLine();
                	bookcon.addBook(new Book(cat,name,price));
                    break;
                case 2:
                	Iterable<Book> allBooks = bookcon.retrieveAllBooks();
                	allBooks.forEach(System.out::println);
                	
                	break;
                case 3:
                	System.out.println("Enter Book ID");
                	int id = scanner.nextInt();
                	
                	Optional<Book> bookById = bookcon.findBookById(id);
                    bookById.ifPresent((p)->System.out.print(p));
                	
                	break;
                case 4:
                	System.out.println("Enter Book ID");
                	int iddel = scanner.nextInt();
                	bookcon.deleteBookById(iddel);
                  
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
		
	}
	
	

	}


