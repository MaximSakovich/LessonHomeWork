package homeWork39.repository;

import homeWork39.lib.MyArrayListBook;
import homeWork39.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {
    private BookRepository bookRepository;
    private MyArrayListBook<Book> books;

    @BeforeEach
    void setUp() {
        books = new MyArrayListBook<>();
        bookRepository = new BookRepository(books);
    }

    @Test
    void testAddBook() {
        Book book = new Book("Title", "Author", 1, false);
        bookRepository.addBook(book);
        assertEquals(1, bookRepository.getAllBooks().size());
    }

    @Test
    void testRemoveBook() {
        Book book = new Book("Title", "Author", 1, false);
        bookRepository.addBook(book);
        bookRepository.removeBook(book);
        assertEquals(0, bookRepository.getAllBooks().size());
    }

    @Test
    void testGetAllBooks() {
        Book book1 = new Book("Title1", "Author1", 1, false);
        Book book2 = new Book("Title2", "Author2", 2, false);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);
        assertEquals(2, bookRepository.getAllBooks().size());
    }

    @Test
    void testGetAvailableBooks() {
        Book book1 = new Book("Title1", "Author1", 1, false);
        Book book2 = new Book("Title2", "Author2", 2, true);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);
        assertEquals(1, bookRepository.getAvailableBooks().size());
    }

    @Test
    void testGetBookById() {
        Book book1 = new Book("Title1", "Author1", 1, false);
        Book book2 = new Book("Title2", "Author2", 2, false);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);
        assertEquals(book2, bookRepository.getBookById(2));
        assertNull(bookRepository.getBookById(3));
    }

    @Test
    void testAddAndRemoveBook() {
        Book book1 = new Book("Title1", "Author1", 1, false);
        Book book2 = new Book("Title2", "Author2", 2, false);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);
        bookRepository.removeBook(book1);
        assertEquals(1, bookRepository.getAllBooks().size());
    }

    @Test
    void testGetBookByIdNonExisting() {
        Book book1 = new Book("Title1", "Author1", 1, false);
        Book book2 = new Book("Title2", "Author2", 2, false);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);
        assertNull(bookRepository.getBookById(3));
    }
}