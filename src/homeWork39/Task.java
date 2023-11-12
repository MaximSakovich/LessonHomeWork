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
import java.util.List;
import java.util.Date;
import java.util.function.Predicate;

// Интерфейс для книги
interface Book {
    String getTitle();
    String getAuthor();
    boolean isAvailable();
}

// Интерфейс для библиотеки
interface Library {
    void addBook(Book book);
    List<Book> getAllBooks();
    List<Book> getAvailableBooks();
    List<Book> getBooksByAuthor(String author);
    List<Book> searchBooksByTitle(String title);
    void borrowBook(Book book, String user, Date date);
    void returnBook(Book book, String user);
    List<Book> getBooksBorrowedByUser(String user);
}

// Пример класса реализующего интерфейс Book
class LibraryBook implements Book {
    private String title;
    private String author;
    private boolean available;

    public LibraryBook(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public boolean isAvailable() {
        return this.available;
    }
}

// Пример класса реализующего интерфейс Library
class MyLibrary implements Library {
    private List<Book> books;

    // Реализация методов интерфейса

    @Override
    public void addBook(Book book) {
        // Ваша реализация
    }

    @Override
    public List<Book> getAllBooks() {
        // Ваша реализация
        return null;
    }

    // Другие методы интерфейса
}

// Пример использования предиката и лямбда-выражения
public class Main {
    public static void main(String[] args) {
        Predicate<Book> availableBooks = Book::isAvailable;
        // Пример фильтрации списка книг по доступности
        List<Book> allBooks = new MyLibrary().getAllBooks();
        List<Book> availableBooksList = allBooks.stream().filter(availableBooks).toList();
        System.out.println("Список всех доступных книг: " + availableBooksList);
    }
}
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;

// Класс для представления пользователя
class User {
    private String name;
    // Другие поля, если необходимо

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

// Интерфейс для библиотеки с пользователями
interface Library {
    void addUser(User user);
    List<User> getAllUsers();
    // Другие методы для работы с пользователями

    // Реализация методов для работы с книгами
}

// Пример класса реализующего интерфейс Library
class MyLibrary implements Library {
    private List<Book> books;
    private List<User> users;

    public MyLibrary() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Реализация методов интерфейса

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }

    // Другие методы для работы с пользователями и книгами
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Library myLibrary = new MyLibrary();

        User user1 = new User("Иван");
        myLibrary.addUser(user1);

        // Получение всех пользователей
        List<User> allUsers = myLibrary.getAllUsers();
        System.out.println("Список всех пользователей: " + allUsers);
    }
}

case 13: {
    // 13. Права доступа у пользователей, в зависимости от роли
    System.out.println("Введите ваш логин:");
    String username = scanner.nextLine();
    User user = userService.findReaderByUsername(username);
    if (user != null) {
        System.out.println("Имя: " + user.getFirstName());
        System.out.println("Фамилия: " + user.getLastName());
        userService.displayUserPermissions(user);
    } else {
        System.out.println("Пользователь не найден.");
    }
    break;
}
 case 13: {
                    // 13. Права доступа у пользователей, в зависимости от роли
                    System.out.println("Введите ваш логин:");
                    String username = scanner.nextLine();
                    User user = userService.findReaderByUsername(username);
                    if (user != null) {
                        System.out.println("Имя: " + user.getFirstName());
                        System.out.println("Фамилия: " + user.getLastName());
                        if (user.getRole() == UserRole.ADMIN) {
                            System.out.println("Пользователь " + user.getUsername() + " имеет права администратора.");
                        } else if (user.getRole() == UserRole.CLIENT) {
                            System.out.println("Пользователь " + user.getUsername() + " имеет права клиента.");
                        } else {
                            System.out.println("Неправильная роль пользователя.");
                        }
                    } else {
                        System.out.println("Пользователь не найден.");
                    }
                }
                break;
public Book getBookById(Long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // метод возвращает список книг, доступных для взятия, из общего списка книг.
    public ListBook<Book> getAvailableBooks() {
        ListBook<Book> availableBooks = new ListBook<>();
        for (Book book : books) {
            if (!book.isTaken()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

 public ListBook<Book> searchBooksByTitle(String title) {
        ListBook<Book> booksByTitle = new ListBook<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getTitle().contains(title)) {
                booksByTitle.add(book);
            }
        }
        return booksByTitle;
    }
    public ListBook<Book> getAvailableBooks() {
        ListBook<Book> availableBooks = new ListBook<>();
        for (Book book : books) {
            if (!book.isTaken()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
 */







