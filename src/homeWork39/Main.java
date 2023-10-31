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
*/