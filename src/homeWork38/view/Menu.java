package homeWork38.view;

import homeWork38.models.Order;
import homeWork38.models.Product;
import homeWork38.models.User;
import homeWork38.services.OrderService;
import homeWork38.services.ProductsService;
import homeWork38.services.UsersService;

import java.util.Scanner;

public class Menu {
    private UsersService usersService;
    private ProductsService productsService;
    private OrderService orderService;

    public Menu(UsersService usersService, ProductsService productsService, OrderService orderService) {
        this.usersService = usersService;
        this.productsService = productsService;
        this.orderService = orderService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String customerEmail = "";
        User[] allUsers = new User[0];

        while (true) {
            // выводим команды меню
            System.out.println("1. Регистрация пользователя");
            System.out.println("2. Добавить товар");
            System.out.println("3. Разместить заказ");
            System.out.println("4. Показать всех пользователей");
            System.out.println("5. Показать все товары");
            System.out.println("6. Показать все заказы");
            System.out.println("0. Выход");

            while (!scanner.hasNextInt()) {
                System.err.println("Неверная команда, попробуйте снова.");
                scanner.next();
            }
            int command = scanner.nextInt();
            scanner.nextLine();
            if (command < 0 || command > 6) {
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
                    // Регистрации пользователя
                    boolean validInput = false;
                    String email = "";
                    String password = "";

                    System.out.println("Введите имя пользователя: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Введите фамилию пользователя: ");
                    String lastName = scanner.nextLine();

                    while (!validInput) {

                        System.out.println("Введите email пользователя: ");
                        email = scanner.nextLine();
                        User user = new User(firstName, lastName, email, "");
                        if (!user.isEmailValid(email)) {
                            System.err.println("Неверный формат электронной почты. Пожалуйста, введите корректный е-мейл.");
                        } else {
                            validInput = true;
                        }
                    }

                    validInput = false;

                    while (!validInput) {
                        System.out.println("Придумайте корректный пароль пользователя: ");
                        password = scanner.nextLine();
                        User user = new User("", "");
                        user.setPassword(password);
                        if (!user.isPasswordValid(password)) {
                            System.err.println("Попробуйте еще раз!!!");
                        } else {
                            validInput = true;
                        }
                    }
                    usersService.register(firstName, lastName, email, password);
                }
                break;

                case 2:
                    // Добавление товара
                    boolean validPriceInput = false;
                    double price = 0.00;
                    System.out.println("Введите наименование товара: ");
                    String title = scanner.nextLine();
                    while (!validPriceInput) {
                        try {
                            System.out.println("Введите цену товара в формате xx.xx: ");
                            String priceInput = scanner.nextLine();
                            if (!priceInput.matches("\\d+\\.\\d{2}")) {
                                throw new NumberFormatException();
                            }
                            price = Double.parseDouble(priceInput);
                            validPriceInput = true;
                        } catch (NumberFormatException e) {
                            System.err.println("Неверный формат цены. Пожалуйста, введите корректную цену в формате xx.xx");
                        }
                    }
                    System.out.println("Введите описание товара: ");
                    String description = scanner.nextLine();
                    System.out.println("Введите количество товара: ");
                    int residual = scanner.nextInt();
                    scanner.nextLine();
                    productsService.addProduct(title, price, description, residual);
                    break;

                case 3:
                    // Размещение заказа товара
                    System.out.println("Введите email заказчика: ");
                    customerEmail = scanner.nextLine();

                    while (true) {
                        User user = new User("", "");
                        if (!user.isEmailValid(customerEmail)) {
                            System.err.println("Неверный формат электронной почты. Пожалуйста, введите корректный е-мейл.");
                            System.out.println("Введите email заказчика: ");
                            customerEmail = scanner.nextLine();
                        } else {
                            break;
                        }
                    }
                    System.out.println("Наименование заказанного товара: ");
                    String productTitle = scanner.nextLine();
                    System.out.println("Количество единиц: ");
                    int count = scanner.nextInt();
                    scanner.nextLine();

                    int updatedStock = productsService.getProductStock(productTitle, count);
                    if (updatedStock >= 0) {
                        orderService.placeOrder(customerEmail, productTitle, count);
                        System.out.println("Заказ успешно размещен.");
                    } else if (updatedStock == -1) {
                        System.err.println("Недостаточно товара на складе.");
                    } else {
                        System.err.println("Товар не найден.");
                    }
                    break;

                case 4:
                    // Показать всех пользователей
                    allUsers = usersService.getAllUsers();
                    if (allUsers != null && allUsers.length > 0) {
                        for (User user : allUsers) {
                            System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
                        }
                    } else {
                        System.err.println("Список пользователей пуст.");
                    }
                    break;

                case 5:
                    // Показать все товары
                    Product[] allProducts = productsService.getAllProducts();
                    if (allProducts != null) {
                        for (Product prod : allProducts) {
                            int remainingStock = productsService.getProductStock(prod.getTitle(), 0);
                            System.out.printf("%s - цена %.2f - остаток %d\n", prod.getTitle(), prod.getPrice(), remainingStock);
                        }
                    } else {
                        System.err.println("Список товаров пуст.");
                    }
                    break;

                case 6:
                    // Показать все заказы
                    Order[] allOrders = orderService.getAllOrders();
                    if (allOrders != null && allOrders.length > 0) {
                        allUsers = usersService.getAllUsers();
                        if (allUsers != null && allUsers.length > 0) {
                            for (Order order : allOrders) {
                                customerEmail = order.getCustomerEmail();
                                String customerName = "";
                                for (User user : allUsers) {
                                    if (user.getEmail().equals(customerEmail)) {
                                        customerName = user.getFirstName() + " " + user.getLastName();
                                        break;
                                    }
                                }
                                System.out.println(customerName + " заказал " + order.getCount() + " единиц товара "
                                        + order.getProductTitle() + " его emeil: " + customerEmail);
                            }
                        } else {
                            System.err.println("Список пользователей пуст.");
                        }
                    } else {
                        System.err.println("Список заказов пуст.");
                    }
                    break;
                default:
                    System.err.println("Неверная команда, попробуйте снова.");
            }
        }
    }
}