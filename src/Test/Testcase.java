package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Testcase {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("1234", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        book2 = new Book("5678", "To Kill a Mockingbird", "Harper Lee", 1960);
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        library.addBook(book2);
        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(2, availableBooks.size());
    }

    @Test
    public void testAddDuplicateBookThrowsException() {
        library.addBook(book1);
        assertThrows(IllegalArgumentException.class, () -> library.addBook(book1));
    }

    @Test
    public void testBorrowBook() {
        library.addBook(book1);
        library.borrowBook("1234");
        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(0, availableBooks.size());
    }

    @Test
    public void testBorrowUnavailableBookThrowsException() {
    	
    	
        library.addBook(book1);
        library.borrowBook("1234");
        assertThrows(IllegalArgumentException.class, () -> library.borrowBook("1234"));
    }

    @Test
    public void testReturnBook() {
        library.addBook(book1);
        library.borrowBook("1234");
        library.returnBook("1234");
        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(1, availableBooks.size());
    }

    @Test
    public void testReturnNonexistentBookThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.returnBook("9999"));
    }
}
