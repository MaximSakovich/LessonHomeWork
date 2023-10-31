package homeWork39.view;

import homeWork39.model.Reader;
import homeWork39.model.Book;
import homeWork39.service.BookService;
import homeWork39.service.ReaderService;
import homeWork39.repository.BookRepository;
import homeWork39.lib.MyArrayListBook;
import homeWork39.lib.MyLinkedListReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleMenu {
    private BookService bookService;
    private ReaderService readerService;
    private BookRepository bookRepository;
    MyLinkedListReader<Reader> borrowedBooks = new MyLinkedListReader<Reader>();
    MyArrayListBook<Book> availableBooks = new MyArrayListBook<>();
    public ConsoleMenu() {
        this.bookService = new BookService();
        this.readerService = new ReaderService();
        this.bookRepository = new BookRepository();
    }

    public void showMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // выводим команды меню
            System.out.println("1. Добавление книги");
            System.out.println("2. Список всех книг");
            System.out.println("3. Взятие книги из библиотеки с фиксацией даты");
            System.out.println("4. Возврат книги в библиотеку");
            System.out.println("5. Список всех свободных книг");
            System.out.println("6. Список всех книг, находящихся сейчас у читателей");
            System.out.println("7. Список всех по автору");
            System.out.println("8. Поиск книг по названию книги");
            System.out.println("9. Пользователи библиотеки");
            System.out.println("10. Авторизация пользователей");
            System.out.println("11. Регистрация пользователя");
            System.out.println("12. Список книг, которые сейчас у пользователя");
            System.out.println("13. Права доступа у пользователей, в зависимости от роли");
            System.out.println("14. Редактирование информации о книге");
            System.out.println("15. Посмотреть у кого находится книга, если занята");
            System.out.println("16. Дата, когда была книга взята на прокат (добавить метод изменяющий эту дату)");
            System.out.println("17. Получить информацию сколько дней книга находится у пользователя");
            System.out.println("0. Выход");

            while (!scanner.hasNextInt()) {
                System.err.println("Неверная команда, попробуйте снова.");
                scanner.next();
            }
            int command = scanner.nextInt();
            scanner.nextLine();
            if (command < 0 || command > 17) {
                System.err.println("Неверная команда, попробуйте снова.");
                continue;
            }

            switch (command) {
                case 0: {
                    System.out.println("Выход из программы...");
                    System.exit(0);
                }
                break;

                case 1: {
                    // 1. Добавление книги
                    System.out.println("Введите название книги:");
                    String title = scanner.nextLine();
                    System.out.println("Введите автора книги:");
                    String author = scanner.nextLine();
                    // Создайте новый экземпляр книги и добавьте его в список доступных книг
                    Book newBook = new Book(title, author, bookRepository.getAllBooks().size() + 1, false);
                    bookRepository.addBook(newBook); // Добавьте метод добавления книги в ваш репозиторий
                    System.out.println("Книга добавлена: " + newBook);
                }
                break;
                case 2: {
                    // 2. Список всех книг
                    MyArrayListBook<Book> allBooks = bookService.getAllBooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("В библиотеке нет доступных книг.");
                    } else {
                        System.out.println("Список всех книг:");
                        for (Book book : allBooks) {
                            System.out.println(book);
                        }
                    }
                }
                break;

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
                        System.out.println("Читатель с именем и фамилией " + firstName + lastName + " не найден.");
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
                            System.out.println("Книга взята читателем: " + firstName + lastName);
                        }
                    }
                }
                break;

                case 4: {
                    // 4. Возврат книги в библиотеку
                    System.out.println("Введите ваше имя:");
                    String firstName = scanner.nextLine();
                    System.out.println("Введите вашу фамилию:");
                    String lastName = scanner.nextLine();
                    System.out.println("Введите название книги, которую вы хотите вернуть:");
                    String bookTitle = scanner.nextLine();

                    // Проверка, существует ли читатель с введенным именем
                    Reader reader = readerService.findReaderByName(firstName, lastName);
                    if (reader == null) {
                        System.out.println("Читатель с именем " + firstName + lastName + " не найден.");
                    } else {
                        // Проверка, существует ли книга с введенным названием
                        Book book = bookService.findBookByTitle(bookTitle);
                        if (book == null) {
                            System.out.println("Книга с названием " + bookTitle + " не найдена.");
                        } else {
                            bookService.returnBook(reader, book);
                            System.out.println("Книга возвращена в библиотеку: " + bookTitle);
                        }
                    }
                }
                break;
                case 5: {
                    // 5. Список всех свободных книг
                    MyArrayListBook<Book> availableBooks = bookService.getAvailableBooks();
                    if (availableBooks.isEmpty()) {
                        System.out.println("Нет доступных книг в библиотеке.");
                    } else {
                        System.out.println("Список всех доступных книг:");
                        for (Book book : availableBooks) {
                            System.out.println(book);
                        }
                    }
                }
                break;

                case 6: {
                    // 6. Список всех книг, находящихся сейчас у читателей
                    MyArrayListBook<Book> borrowedBooks = bookService.getBorrowedBooks();
                    if (borrowedBooks.isEmpty()) {
                        System.out.println("В настоящее время у читателей нет взятых книг.");
                    } else {
                        System.out.println("Список книг, находящихся у читателей:");
                        for (Book book : borrowedBooks) {
                            System.out.println(book);
                        }
                    }
                }
                break;
                case 7: {
                    // 7. Список всех по автору
                    System.out.println("Введите имя автора:");
                    String author = scanner.nextLine();
                    MyArrayListBook<Book> booksByAuthor = bookService.getBooksByAuthor(author);
                    if (booksByAuthor.isEmpty()) {
                        System.out.println("Нет книг данного автора.");
                    } else {
                        System.out.println("Список книг автора " + author + ":");
                        for (Book book : booksByAuthor) {
                            System.out.println(book);
                        }
                    }
                }
                break;

                case 8: {
                    System.out.println("Введите название книги для поиска:");
                    String bookTitle = scanner.nextLine();

                    MyArrayListBook<Book> foundBooks = bookService.findBooksByTitle(bookTitle);

                    if(foundBooks.isEmpty()) {
                        System.out.println("Книги с названием " + bookTitle + " не найдены.");
                    } else {
                        System.out.println("Найденные книги по запросу " + bookTitle + ":");
                        for(Book book : foundBooks) {
                            System.out.println(book.toString());
                        }
                    }
                }
                break;

                case 9: {
                    // 9. Пользователи библиотеки
                    MyLinkedListReader<Reader> allReaders = readerService.getAllReaders();
                    if (allReaders.isEmpty()) {
                        System.out.println("В библиотеке нет зарегистрированных пользователей.");
                    } else {
                        System.out.println("Список пользователей библиотеки:");
                        for (Reader reader : allReaders) {
                            System.out.println(reader);
                        }
                    }
                }
                break;

                case 10: {
                    //10. Авторизация пользователей
                    System.out.println("Введите имя пользователя:");
                    String username = scanner.nextLine();
                    System.out.println("Введите пароль:");
                    String password = scanner.nextLine();
                    if (readerService.authenticate(username, password)) {
                        System.out.println("Авторизация прошла успешно.");
                    } else {
                        System.out.println("Неверное имя пользователя или пароль.");
                    }
                }
                break;

                case 11: {
                    // 11 Регистрации пользователя
                    boolean validInput = false;
                    String email = "";
                    String password = "";
                    System.out.println("Введите логин пользователя:");
                    String username = scanner.nextLine();
                    System.out.println("Введите имя: ");
                    String firstname = scanner.nextLine();
                    System.out.println("Введите фамилию: ");
                    String lastname = scanner.nextLine();

                    while (!validInput) {

                        System.out.println("Введите email: ");
                        email = scanner.nextLine();
                      Reader newReader = new Reader(firstname, lastname, email, username, password, availableBooks);

                        if (!readerService.isEmailValid(email)) {
                            System.err.println("Неверный формат электронной почты. " +
                                    "Пожалуйста, введите корректный е-мейл.");
                        } else {
                            validInput = true;
                        }
                    }

                    validInput = false;
                    while (!validInput) {
                        System.out.println("Придумайте корректный пароль пользователя: ");
                        password = scanner.nextLine();
                      Reader newReader = new Reader(firstname, lastname, email, username, password, availableBooks);
                        newReader.setPassword(password);
                        if (!readerService.isPasswordValid(password)) {
                            System.err.println("Попробуйте еще раз!!!");
                        } else {
                            validInput = true;
                        }
                    }
                    readerService.registerUser(firstname, lastname, email, username, password);
                }
                break;

                case 12: {
                    //12. Список книг, которые сейчас у пользователя
                    System.out.println("Введите имя пользователя:");
                    String username = scanner.nextLine();
                    Reader reader = readerService.findReaderByUsername(username);
                    if (reader != null) {
                        MyArrayListBook<Book> borrowedBooks = bookService.getBorrowedBooks(reader);
                        if (borrowedBooks.isEmpty()) {
                            System.out.println("У данного пользователя нет взятых книг.");
                        } else {
                            System.out.println("Книги, которые сейчас у пользователя " +
                                    reader.getFirstName() + " " + reader.getLastName() + ":");
                            for (Book book : borrowedBooks) {
                                System.out.println(book);
                            }
                        }
                    } else {
                        System.out.println("Пользователь не найден.");
                    }
                    break;
                }

                case 13: {
                    // Вывести права доступа у пользователей
                  //  readerService.displayUserPermissions();
                }
                break;

                case 14: {
                    // 14. Редактирование информации о книге
                    System.out.println("Введите ID книги, информацию о которой нужно отредактировать:");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    Book bookToEdit = bookRepository.getBookById(bookId);
                    if (bookToEdit == null) {
                        System.out.println("Книга с указанным ID не найдена.");
                    } else {
                        System.out.println("Введите новое название книги:");
                        String newTitle = scanner.nextLine();
                        System.out.println("Введите нового автора книги:");
                        String newAuthor = scanner.nextLine();
                        bookService.editBookInfo(bookToEdit, newTitle, newAuthor);
                    }
                }
                break;

                case 15: {
                    System.out.println("Введите имя пользователя:");
                    String username = scanner.nextLine();
                    Reader reader = readerService.findReaderByUsername(username);
                    if (reader != null) {
                        System.out.println("Введите название книги:");
                        String bookTitle = scanner.nextLine();
                        Book book = bookService.findBookByTitle(bookTitle);
                        if (book != null) {
                            if (book.isTaken()) {
                                System.out.println("Книга " + bookTitle + " находится у читателя: " +
                                        reader.getFirstName() + " " + reader.getLastName());
                            } else {
                                System.out.println("Книга " + bookTitle + " свободна и находится в библиотеке.");
                            }
                        } else {
                            System.out.println("Книга с названием " + bookTitle + " не найдена.");
                        }
                    } else {
                        System.out.println("Пользователь не найден.");
                    }
                }
                break;

                case 16: {
                    System.out.println("Введите название книги:");
                    String bookTitle = scanner.nextLine();
                    Book book = bookService.findBookByTitle(bookTitle);
                    if (book != null) {
                        if (book.isTaken()) {
                            System.out.println("Дата, когда книга была взята на прокат: " + book.getTakenDate());
                            System.out.println("Вы хотите изменить дату? (yes/no)");
                            String choice = scanner.nextLine();
                            if (choice.equals("yes")) {
                                System.out.println("Введите новую дату в формате гггг-мм-дд:");
                                String newDate = scanner.nextLine();
                                // Здесь ваш код должен обрабатывать новую строку с датой
                                bookService.changeBorrowDate2(book, newDate);
                                System.out.println("Дата изменена успешно.");
                            } else if (choice.equals("no")) {
                                System.out.println("Действие отменено.");
                            } else {
                                System.out.println("Неверный ввод.");
                            }
                        } else {
                            System.out.println("Книга не находится у читателя.");
                        }
                    } else {
                        System.out.println("Книга не найдена.");
                    }
                }
                break;

                case 17: {
                    // Получить информацию о том, сколько дней книга находится у пользователя
                    System.out.println("Введите название книги:");
                    String bookTitle = scanner.nextLine();
                    Book book = bookService.findBookByTitle(bookTitle);
                    if (book != null) {
                        long daysTaken = bookService.getDaysBookHasBeenTaken(book);
                        if (daysTaken > 0) {
                            System.out.println("Книга была взята на прокат " + daysTaken + " дней назад.");
                        } else {
                            System.out.println("Книга не взята на прокат.");
                        }
                    } else {
                        System.out.println("Книга не найдена.");
                    }
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        MyArrayListBook<Book> availableBooks = new MyArrayListBook<>();
        // Создание экземпляров книг
        Book book1 = new Book("Название книги 1", "Автор 1", 1, false);
        Book book2 = new Book("Название книги 2", "Автор 2", 2, false);
        Book book3 = new Book("Название книги 3", "Автор 3", 3, false);
        // Добавьте остальные книги таким же образом

        availableBooks.add(book1);
        availableBooks.add(book2);
        availableBooks.add(book3);
       //ReaderRepository readerRepository  = new ReaderRepository();
     // BookRepository bookRepository1  = new BookRepository();

       ///ReaderService readerService1 = new ReaderService();
       // BookService bookService1 = new BookService();





        //availableBooks.remove(book1);
        ConsoleMenu consoleMenu = new ConsoleMenu();
        consoleMenu.showMenu();
    }
}

