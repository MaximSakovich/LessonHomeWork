package homeWork39.repository;

import homeWork39.model.Book;
import homeWork39.lib.MyArrayListBook;

public class BookRepository {

    private MyArrayListBook<Book> books;

    public BookRepository(MyArrayListBook<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книга успешно добавлена в репозиторий.");
        System.out.println("Содержимое репозитория после добавления книги:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public MyArrayListBook<Book> getAllBooks() {
        MyArrayListBook<Book> copyOfBooks = new MyArrayListBook<>();
        for (Book book : books) {
            copyOfBooks.add(book);
        }
        return copyOfBooks;
    }

// метод возвращает список книг, доступных для взятия, из общего списка книг.
    public MyArrayListBook<Book> getAvailableBooks() {
        MyArrayListBook<Book> availableBooks = new MyArrayListBook<>();
        for (Book book : books) {
            if (!book.isTaken()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
