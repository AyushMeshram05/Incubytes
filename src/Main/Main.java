package Main;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        Book book1 = new Book("1234", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("5678", "To Kill a Mockingbird", "Harper Lee", 1960);

        library.addBook(book1);
        library.addBook(book2);

        System.out.println("Available books: " + library.viewAvailableBooks());

        // Borrowing a book
        library.borrowBook("1234");
        System.out.println("Available books after borrowing: " + library.viewAvailableBooks());

        // Returning a book
        library.returnBook("1234");
        System.out.println("Available books after returning: " + library.viewAvailableBooks());
    }
}
