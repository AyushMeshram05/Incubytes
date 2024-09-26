package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books = new ArrayList<>();

    // Add a new book
    public void addBook(Book book) {
        if (books.stream().anyMatch(b -> b.getIsbn().equals(book.getIsbn()))) {
            throw new IllegalArgumentException("Book with the same ISBN already exists.");
        }
        books.add(book);
    }

    // Borrow a book by ISBN
    public void borrowBook(String isbn) {
        Optional<Book> bookOpt = books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
        if (!bookOpt.isPresent()) {
            throw new IllegalArgumentException("Book not found.");
        }
        Book book = bookOpt.get();
        if (!book.isAvailable()) {
            throw new IllegalArgumentException("Book is not available.");
        }
        book.setAvailable(false);
    }

    // Return a book by ISBN
    public void returnBook(String isbn) {
        Optional<Book> bookOpt = books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
        if (!bookOpt.isPresent()) {
            throw new IllegalArgumentException("Book not found.");
        }
        bookOpt.get().setAvailable(true);
    }

    // View all available books
    public List<Book> viewAvailableBooks() {
        return books.stream().filter(Book::isAvailable).toList();
    }
}
