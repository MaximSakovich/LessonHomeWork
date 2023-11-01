package homeWork39;


/*### Требования к программе:
- Добавление книги
- Список всех книг
- Взятие книги из библиотеки с фиксацией даты
- Возврат книги в библиотеку
- Список всех свободных книг
- Список всех книг, находящихся сейчас у читателей
- Нельзя взять книгу, если она сейчас у другого читателя!!!!!!!!!!!!!
- Список всех по автору
- Поиск книг по названию книги
- JUnit тесты
- Для хранения списков использовать самописные MyArrayList или MyLinkedList

### Опционально можно добавлять функционал на ваш выбор (для тех кто успеет / хочет)
- Пользователи библиотеки
- Авторизация пользователей
- Регистрация пользователя
- Список книг, которые сейчас у пользователя
- Права доступа у пользователей, в зависимости от роли
- Редактирование информации о книге
- Посмотреть у кого находится книга, если занята
- Дата, когда была книга взята на прокат (добавить метод изменяющий эту дату)
- Получить информацию сколько дней книга находится у пользователя
*/
/*
import java.util.Date;

public class MyArrayListBook<T>
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 100;

public class MyLinkedListReader<T>
        private Object[] array;
        private int size;
        private static final int DEFAULT_CAPACITY = 100;

public class Book
        private String title;
        private String author;
        private int id;
        private boolean isTaken;
        private String takenDate;


public class Reader
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private MyLinkedListReader<Book> borrowedBooks;

public class Role

        private String roleName;


public class ReaderRepository
        private homeWork39.lib.MyLinkedList<homeWork39.model.Reader> readers;
public class BookRepository
        private homeWork39.lib.MyArrayList<homeWork39.model.Book> books;

public class Main {

    /*public static void main(String[] args) {
        MyArrayList<Book> availableBooks = new MyArrayList<>();

        // Создание экземпляров книг
        Book book1 = new Book("Название книги 1", "Автор 1", 1);
        Book book2 = new Book("Название книги 2", "Автор 2", 2);
        // Добавьте остальные книги таким же образом

        availableBooks.add(book1);
        availableBooks.add(book2);




        availableBooks.remove(book1);
        ConsoleMenu consoleMenu = new ConsoleMenu();
        consoleMenu.showMenu();
    }


}
case 3: {
                    // 3. Взятие книги из библиотеки с фиксацией даты
                    System.out.println("Введите ваше имя:");
                    String firstName = scanner.nextLine();
                    System.out.println("Введите вашу фамилию:");
                    String lastName = scanner.nextLine();
                    System.out.println("Введите название книги, которую вы хотите взять:");
                    String bookTitle = scanner.nextLine();
                    System.out.println("Введите дату в формате yyyy-MM-dd:");
                    String takenDateStr = scanner.nextLine();

                    // Проверка, существует ли читатель с введенным именем
                    Reader reader = readerService.findReaderByName(firstName, lastName);
                    if (reader == null) {
                        System.out.println("Читатель с именем и фамилией " + firstName + " " + lastName + " не найден.");
                    } else {
                        // Проверка, существует ли книга с введенным названием
                        Book book = bookService.findBookByTitle(bookTitle);
                        if (book == null) {
                            System.out.println("Книга с названием " + bookTitle + " не найдена.");
                        } else {
                            LocalDate takenDate;
                            try {
                                takenDate = LocalDate.parse(takenDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            } catch (DateTimeParseException e) {
                                System.out.println("Некорректный формат даты. Введите дату в формате yyyy-MM-dd.");
                                break;
                            }
                            bookService.borrowBook(reader, book, takenDateStr);
                            System.out.println("Книга взята читателем: " + firstName + " " + lastName);
                        }
                    }
                }
                break;


@Test
    void testGetBorrowedBooks() {
        Book book1 = new Book("Title 1", "Author 1", 1, true);
        Book book2 = new Book("Title 2", "Author 2", 2, true);
        Reader reader = new Reader("John", "Doe", "john_doe");
        book1.setReader(reader);
        book2.setReader(reader);
        bookService.getAllBooks().add(book1);
        bookService.getAllBooks().add(book2);

        MyArrayListBook<Book> borrowedBooks = bookService.getBorrowedBooks(reader);

        assertEquals(2, borrowedBooks.size());
        assertEquals("Title 1", borrowedBooks.get(0).getTitle());
        assertEquals("Title 2", borrowedBooks.get(1).getTitle());
    }

    @Test
    void returnBook() {
        Book book = new Book("Title", "Author", 1, true);
        Reader reader = new Reader("John", "Doe", "john_doe");
        book.setReader(reader);
        bookService.getAllBooks().add(book);

        bookService.returnBook(reader, book);

        assertFalse(book.isTaken());
        assertNull(book.getTakenDate());
        assertNull(book.getReader());
    }
    @Test
    void borrowBook() {
        Book book = new Book("Title", "Author", 1, false);
        Reader reader = new Reader("John", "Doe", "john_doe");
        bookService.getAllBooks().add(book);

        bookService.borrowBook(reader, book, "2023-11-01");

        assertTrue(book.isTaken());
        assertEquals("2023-11-01", book.getTakenDate());
        assertEquals(reader, book.getReader());
    }
@Test
    void getBorrowedBooks() {
        Book book1 = new Book("Title 1", "Author 1", 1, true);
        Book book2 = new Book("Title 2", "Author 2", 2, true);
        Reader reader = new Reader("John", "Doe", "john_doe");
        book1.setReader(reader);
        book2.setReader(reader);
        bookService.getAllBooks().add(book1);
        bookService.getAllBooks().add(book2);

        MyArrayListBook<Book> borrowedBooks = bookService.getBorrowedBooks();

        assertEquals(2, borrowedBooks.size());
        assertEquals("Title 1", borrowedBooks.get(0).getTitle());
        assertEquals("Title 2", borrowedBooks.get(1).getTitle());
    }
@Test
    void searchBooksByTitle() {
        Book book1 = new Book("Title", "Author 1", 1, false);
        Book book2 = new Book("Another Title", "Author 2", 2, false);
        bookService.getAllBooks().add(book1);
        bookService.getAllBooks().add(book2);

        MyArrayListBook<Book> foundBooks = bookService.searchBooksByTitle("Title");

        assertEquals(1, foundBooks.size());
        assertEquals("Title", foundBooks.get(0).getTitle());
    }

    @Test
    void findBookById() {
        Book book = new Book("Title", "Author", 1, false);
        bookService.getAllBooks().add(book);

        Book foundBook = bookService.findBookById(1);

        assertNotNull(foundBook);
        assertEquals("Title", foundBook.getTitle());
    }
    @Test
    void findBooksByTitle() {
        Book book1 = new Book("Title", "Author", 1, false);
        Book book2 = new Book("Title", "Another Author", 2, false);
        bookService.getAllBooks().add(book1);
        bookService.getAllBooks().add(book2);

        MyArrayListBook<Book> foundBooks = bookService.findBooksByTitle("Title");

        assertEquals(2, foundBooks.size());
        assertEquals("Title", foundBooks.get(0).getTitle());
        assertEquals("Title", foundBooks.get(1).getTitle());
    }




 */
