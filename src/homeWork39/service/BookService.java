package homeWork39.service;

import homeWork39.lib.MyArrayListBook;
import homeWork39.model.Book;
import homeWork39.model.Reader;
import homeWork39.repository.BookRepository;
import homeWork39.repository.ReaderRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class BookService {
    private BookRepository bookRepository;
    private ReaderRepository readerRepository;

    public BookService(BookRepository bookRepository, ReaderRepository readerRepository) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }

    // Метод взятия книги в библиотеке с фиксацией даты
    public void borrowBook(Reader reader, Book book, String date) {
        if (book.isTaken()) {
            System.out.println("Книга уже взята другим читателем.");
        } else {
            book.setTaken(true);
            book.setTakenDate(date);
            book.setReader(reader);
        }
    }

    // Метод возврата книги в библиотеку
    public void returnBook(Reader reader, Book book) {
        book.setTaken(false);
        book.setTakenDate("");
    }

    public MyArrayListBook<Book> findBooksByTitle(String title) {
        MyArrayListBook<Book> booksByTitle = new MyArrayListBook<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getTitle().equals(title)) {
                booksByTitle.add(book);
            }
        }
        return booksByTitle;
    }

    public MyArrayListBook<Book> getBooksByAuthor(String author) {
        MyArrayListBook<Book> booksByAuthor = new MyArrayListBook<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public MyArrayListBook<Book> searchBooksByTitle(String title) {
        MyArrayListBook<Book> booksByTitle = new MyArrayListBook<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getTitle().contains(title)) {
                booksByTitle.add(book);
            }
        }
        return booksByTitle;
    }

    // Добавленные методы
    public Book findBookByTitle(String title) {
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookById(int id) {
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    public MyArrayListBook<Book> getBorrowedBooks() {
        MyArrayListBook<Book> borrowedBooks = new MyArrayListBook<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (book.isTaken()) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

    public MyArrayListBook<Book> getBorrowedBooks(Reader reader) {
        MyArrayListBook<Book> borrowedBooks = new MyArrayListBook<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (book.isTaken() && book.getReader() != null && book.getReader().equals(reader)) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

    public void editBookInfo(Book book, String newTitle, String newAuthor) {
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        System.out.println("Информация о книге успешно отредактирована.");
    }
    public void changeBorrowDate(Book book, String date) {
        book.setTakenDate(date);
    }
    public void changeBorrowDate2(Book book, String newDate) {
        book.setTakenDate(newDate);
    }

    public long getDaysBookHasBeenTaken(Book book) {
        if (!book.isTaken()) {
            return 0;
        }
        try {
            String takenDateStr = book.getTakenDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate takenDate = LocalDate.parse(takenDateStr, formatter);
            LocalDate currentDate = LocalDate.now();
            return ChronoUnit.DAYS.between(takenDate, currentDate);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка разбора даты: " + e.getMessage());
            return 0;
        }
    }

    public MyArrayListBook<Book> getAvailableBooks() {
        MyArrayListBook<Book> availableBooks = new MyArrayListBook<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (!book.isTaken()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    public MyArrayListBook<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}