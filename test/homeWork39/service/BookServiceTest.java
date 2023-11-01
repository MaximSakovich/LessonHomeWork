package homeWork39.service;

import homeWork39.lib.MyArrayListBook;
import homeWork39.model.Book;
import homeWork39.repository.BookRepository;
import homeWork39.repository.ReaderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    @Test
    void getDaysBookHasBeenTaken_validDate() {
        String takenDateStr = "2023-10-20";
        Book book = new Book(1, "Title", "Author");
        book.setTaken(true);
        book.setTakenDate(takenDateStr);

        // Вычисление количества дней, которое книга находится в аренде
        long result = bookService.getDaysBookHasBeenTaken(book);
        LocalDate currentDate = LocalDate.now();
        LocalDate takenDate = LocalDate.parse(takenDateStr);
        long expectedDays = ChronoUnit.DAYS.between(takenDate, currentDate);
        assertEquals(expectedDays, result);
    }

    @Test
    void getAvailableBooks_emptyRepository() {
        // Проверка, что метод возвращает пустой список, если нет доступных книг
        MyArrayListBook<Book> result = bookService.getAvailableBooks();
        assertTrue(result.isEmpty());
    }
}

