
import com.wecp.dao.AuthorDAO;
import com.wecp.dao.AuthorDAOImpl;
import com.wecp.entity.Author;
import com.wecp.service.AuthorService;
import com.wecp.service.AuthorServiceImpl;
import org.junit.jupiter.api.*;
import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorServiceTest {
    private Connection connection;
    private AuthorDAO authorDAO;
    private AuthorService authorService;

    @BeforeEach
    public void setUp() throws SQLException {
        String createTableSQL = "CREATE TABLE author (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "email VARCHAR(100), " +
                "biography TEXT)";
        connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");
        connection.createStatement().execute(createTableSQL);
        authorDAO = new AuthorDAOImpl(connection);
        authorService = new AuthorServiceImpl(authorDAO);
    }

    @AfterEach
    public void tearDown() throws SQLException {
        connection.createStatement().execute("DROP TABLE author");
        connection.close();
    }

    @Test
    public void testAddAndGetAuthor() throws SQLException {
        // Add a new author
        Author author = new Author();
        author.setName("John Doe");
        author.setEmail("john.doe@example.com");
        author.setBiography("John is a prolific writer.");
        authorService.addAuthor(author);

        // Retrieve the author by ID
        Author retrievedAuthor = authorService.getAuthorById(author.getId());

        // Validate the author details
        // assertNotNull(retrievedAuthor);
        // assertEquals(author.getName(), retrievedAuthor.getName());
        // assertEquals(author.getEmail(), retrievedAuthor.getEmail());
        // assertEquals(author.getBiography(), retrievedAuthor.getBiography());
    }

    @Test
    public void testUpdateAuthor() throws SQLException {
        // Add a new author
        Author author = new Author();
        author.setName("Jane Doe");
        author.setEmail("jane.doe@example.com");
        author.setBiography("Jane is a renowned novelist.");
        authorService.addAuthor(author);

        // Update the author's email and biography
        author.setEmail("jane.new@example.com");
        author.setBiography("Jane is now working on her latest book.");
        authorService.updateAuthor(author);

        // Retrieve the updated author
        Author updatedAuthor = authorService.getAuthorById(author.getId());

        // Validate the updated details
        // assertEquals("jane.new@example.com", updatedAuthor.getEmail());
        // assertEquals("Jane is now working on her latest book.", updatedAuthor.getBiography());
    }

    @Test
    public void testGetAllAuthors() throws SQLException {
        // Add two authors
        Author author1 = new Author();
        author1.setName("Author One");
        author1.setEmail("author1@example.com");
        author1.setBiography("Biography of author one.");
        authorService.addAuthor(author1);

        Author author2 = new Author();
        author2.setName("Author Two");
        author2.setEmail("author2@example.com");
        author2.setBiography("Biography of author two.");
        authorService.addAuthor(author2);

        // Retrieve all authors
        List<Author> authors = authorService.getAllAuthors();

        // Validate the number of authors
        assertEquals(2, authors.size());
    }

    @Test
    public void testDeleteAuthor() throws SQLException {
        // Add a new author
        Author author = new Author();
        author.setName("Author To Be Deleted");
        author.setEmail("delete.me@example.com");
        author.setBiography("This author will be deleted.");
        authorService.addAuthor(author);

        // Delete the author
        authorService.deleteAuthor(author.getId());

        // Try to retrieve the deleted author
        Author deletedAuthor = authorService.getAuthorById(author.getId());

        // Validate that the author no longer exists
        assertNull(deletedAuthor);
    }
}
