package com.wecp;

import com.wecp.dao.AuthorDAO;
import com.wecp.dao.AuthorDAOImpl;
import com.wecp.entity.Author;
import com.wecp.service.AuthorService;
import com.wecp.service.AuthorServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/authorDB_wecp";
    private static final String USER = "root";
    private static final String PASSWORD = "hellowecp";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            AuthorDAO authorDAO = new AuthorDAOImpl(connection);
            AuthorService authorService = new AuthorServiceImpl(authorDAO);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Add Author");
                System.out.println("2. Get Author by ID");
                System.out.println("3. Get All Authors");
                System.out.println("4. Update Author");
                System.out.println("5. Delete Author");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter biography: ");
                        String biography = scanner.nextLine();
                        Author newAuthor = new Author();
                        newAuthor.setName(name);
                        newAuthor.setEmail(email);
                        newAuthor.setBiography(biography);
                        authorService.addAuthor(newAuthor);
                        System.out.println("Author added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter author ID: ");
                        int id = scanner.nextInt();
                        Author author = authorService.getAuthorById(id);
                        if (author != null) {
                            System.out.println("ID: " + author.getId());
                            System.out.println("Name: " + author.getName());
                            System.out.println("Email: " + author.getEmail());
                            System.out.println("Biography: " + author.getBiography());
                        } else {
                            System.out.println("Author not found.");
                        }
                        break;
                    case 3:
                        List<Author> authors = authorService.getAllAuthors();
                        for (Author a : authors) {
                            System.out.println("ID: " + a.getId());
                            System.out.println("Name: " + a.getName());
                            System.out.println("Email: " + a.getEmail());
                            System.out.println("Biography: " + a.getBiography());
                            System.out.println("---------------------------");
                        }
                        break;
                    case 4:
                        System.out.print("Enter author ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Author updateAuthor = authorService.getAuthorById(updateId);
                        if (updateAuthor != null) {
                            System.out.print("Enter new name: ");
                            updateAuthor.setName(scanner.nextLine());
                            System.out.print("Enter new email: ");
                            updateAuthor.setEmail(scanner.nextLine());
                            System.out.print("Enter new biography: ");
                            updateAuthor.setBiography(scanner.nextLine());
                            authorService.updateAuthor(updateAuthor);
                            System.out.println("Author updated successfully.");
                        } else {
                            System.out.println("Author not found.");
                        }
                        break;
                    case 5:
                        System.out.print("Enter author ID to delete: ");
                        int deleteId = scanner.nextInt();
                        authorService.deleteAuthor(deleteId);
                        System.out.println("Author deleted successfully.");
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
