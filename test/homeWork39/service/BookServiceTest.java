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
    @Test
    void getDaysBookHasBeenTaken_bookNotTaken() {
        // Подготовка данных
        Book book = new Book(1, "Title", "Author");
        book.setTaken(false);

        // Проверка количества дней, когда книга не находится в аренде
        long result = bookService.getDaysBookHasBeenTaken(book);
        assertEquals(0, result);
    }
    @Test
    void getAvailableBooks_nonEmptyRepository() {
        // Подготовка данных
        Book book1 = new Book(1, "Title1", "Author1");
        Book book2 = new Book(2, "Title2", "Author2");
        book1.setTaken(true);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Получение доступных книг из непустого репозитория
        MyArrayListBook<Book> result = bookService.getAvailableBooks();
        assertEquals(1, result.size());
        assertFalse(result.get(0).isTaken());
    }

    @Test
    void getAllBooks_emptyRepository() {
        // Проверка, что метод возвращает пустой список, если нет книг в репозитории
        MyArrayListBook<Book> result = bookService.getAllBooks();
        assertTrue(result.isEmpty());
    }

    @Test
    void getAllBooks_nonEmptyRepository() {
        // Подготовка данных
        Book book1 = new Book(1, "Title1", "Author1");
        Book book2 = new Book(2, "Title2", "Author2");
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Получение всех книг из непустого репозитория
        MyArrayListBook<Book> result = bookService.getAllBooks();
        assertEquals(2, result.size());
    }

    @Test
    void findBookById_nonExistingId() {
        // Подготовка данных
        Book book1 = new Book(1, "Title1", "Author1");
        Book book2 = new Book(2, "Title2", "Author2");
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Поиск несуществующей книги по идентификатору
        Book result = bookService.findBookById(3);
        assertNull(result);
    }
    @Test
    void getBorrowedBooks_noBorrowedBooks() {
        // Подготовка данных
        Book book1 = new Book(1, "Title1", "Author1");
        Book book2 = new Book(2, "Title2", "Author2");
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Получение списка арендованных книг, если нет арендованных книг
        MyArrayListBook<Book> result = bookService.getBorrowedBooks();
        assertTrue(result.isEmpty());
    }

    @Test
    void getBorrowedBooks_someBorrowedBooks() {
        // Подготовка данных
        Book book1 = new Book(1, "Title1", "Author1");
        Book book2 = new Book(2, "Title2", "Author2");
        book1.setTaken(true);
        book2.setTaken(true);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Получение списка арендованных книг из непустого репозитория
        MyArrayListBook<Book> result = bookService.getBorrowedBooks();
        assertEquals(2, result.size());
    }
    @Test
    void getDaysBookHasBeenTaken_bookTaken() {
        // Подготовка данных
        Book book = new Book(1, "Title", "Author");
        book.setTaken(true);
        book.setTakenDate("2023-10-20");

        // Проверка количества дней, когда книга находится в аренде
        long result = bookService.getDaysBookHasBeenTaken(book);
        // Предполагаем, что текущая дата 2023-11-01
        assertEquals(12, result);
    }

    @Test
    void getDaysBookHasBeenTaken_invalidDate() {
        // Подготовка данных
        Book book = new Book(1, "Title", "Author");
        book.setTaken(true);
        book.setTakenDate("Invalid Date");

        // Проверка обработки недопустимой даты аренды книги
        long result = bookService.getDaysBookHasBeenTaken(book);
        assertEquals(0, result);
    }


    @Test
    void getAvailableBooks_someBooksAvailable() {
        // Подготовка данных
        Book book1 = new Book(1, "Title1", "Author1");
        Book book2 = new Book(2, "Title2", "Author2");
        book1.setTaken(true);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Получение списка доступных книг, когда некоторые книги доступны
        MyArrayListBook<Book> result = bookService.getAvailableBooks();
        assertEquals(1, result.size());
    }

    @Test
    void getAllBooks() {
        // Подготовка данных
        Book book1 = new Book(1, "Title1", "Author1");
        Book book2 = new Book(2, "Title2", "Author2");
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Получение всех книг из репозитория
        MyArrayListBook<Book> result = bookService.getAllBooks();
        assertEquals(2, result.size());
    }
    @Test
    void getBorrowedBooks() {
        // Подготовка данных
        Book book1 = new Book(1, "Title1", "Author1");
        Book book2 = new Book(2, "Title2", "Author2");
        book1.setTaken(true);
        book2.setTaken(true);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Получение списка арендованных книг
        MyArrayListBook<Book> result = bookService.getBorrowedBooks();
        assertEquals(2, result.size());
    }

    @Test
    void getBorrowedBooks_empty() {
        // Получение списка арендованных книг при отсутствии арендованных книг
        MyArrayListBook<Book> result = bookService.getBorrowedBooks();
        assertTrue(result.isEmpty());
    }
    @Test
    void getAvailableBooks_allAvailable() {
        // Подготовка данных
        Book book1 = new Book(1, "Title1", "Author1");
        Book book2 = new Book(2, "Title2", "Author2");
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Получение списка доступных книг
        MyArrayListBook<Book> result = bookService.getAvailableBooks();
        assertEquals(2, result.size());
    }

    @Test
    void getAvailableBooks_someTaken() {
        // Подготовка данных
        Book book1 = new Book(1, "Title1", "Author1");
        Book book2 = new Book(2, "Title2", "Author2");
        book1.setTaken(true);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Получение списка доступных книг при наличии арендованных книг
        MyArrayListBook<Book> result = bookService.getAvailableBooks();
        assertEquals(1, result.size());
    }
}

