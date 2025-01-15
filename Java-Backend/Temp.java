
// public class LibraryService {
public class Temp {
    private BookDAO bookDAO;
    private UserDAO userDAO;
    private Map<String, List<Book>> borrowedBooks = new HashMap<>();
 
    public LibraryService(BookDAO bookDAO, UserDAO userDAO) {
        this.bookDAO = bookDAO;
        this.userDAO = userDAO;
    }
 
    public void addBook(String bookId, String title, String author, double price, int quantity) {
        Book book = new Book(bookId, title, author, price, quantity);
        bookDAO.addBook(book);
    }
 
    public void registerUser(String username, String password) {
        User user = new User(username, password);
        userDAO.registerUser(user);
    }
 
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }
 
    public Book getBookById(String bookId) {
        return bookDAO.getBookById(bookId);
    }
 
    public void borrowBook(String bookId, String username) {
        Book book = bookDAO.getBookById(bookId);
        if (book != null && book.getQuantityInStock() > 0) {
            book.setQuantityInStock(book.getQuantityInStock() - 1);
            List<Book> userBooks = borrowedBooks.getOrDefault(username, new ArrayList<>());
            userBooks.add(book);
            borrowedBooks.put(username, userBooks);
        }
    }
 
    public void returnBook(String bookId, String username) {
        List<Book> userBooks = borrowedBooks.get(username);
        if (userBooks != null) {
            Book bookToReturn = null;
            for (Book book : userBooks) {
                if (book.getBookId().equals(bookId)) {
                    bookToReturn = book;
                    break;
                }
            }
            if (bookToReturn != null) {
                bookToReturn.setQuantityInStock(bookToReturn.getQuantityInStock() + 1);
                userBooks.remove(bookToReturn);
            }
        }
    }
 
    public List<Book> getBorrowedBooks(String username) {
        return borrowedBooks.getOrDefault(username, new ArrayList<>());
    }
}