package homeWork39.service;

import homeWork39.lib.MyArrayListBook;
import homeWork39.model.Book;
import homeWork39.model.Reader;
import homeWork39.repository.BookRepository;
import homeWork39.repository.ReaderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookService bookService;
    private ReaderRepository readerRepository;
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository(new MyArrayListBook<>());
        ReaderRepository readerRepository = new ReaderRepository();
        bookService = new BookService(bookRepository, readerRepository);
    }

    @Test
    void editBookInfo() {
        Book book = new Book("Title", "Author", 1, false);
        bookService.getAllBooks().add(book);
        bookService.editBookInfo(book, "New Title", "New Author");
        assertEquals("New Title", book.getTitle());
        assertEquals("New Author", book.getAuthor());
    }

    @Test
    void changeBorrowDate() {
        Book book = new Book("Title", "Author", 1, false);
        bookService.getAllBooks().add(book);
        bookService.changeBorrowDate(book, "2023-11-01");
        assertEquals("2023-11-01", book.getTakenDate());
    }

    @Test
    void changeBorrowDate2() {
        Book book = new Book("Title", "Author", 1, false);
        bookService.getAllBooks().add(book);
        bookService.changeBorrowDate2(book, "2023-11-01");
        assertEquals("2023-11-01", book.getTakenDate());
    }
}

