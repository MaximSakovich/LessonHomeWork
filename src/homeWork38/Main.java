package homeWork38;

import homeWork38.repositories.OrdersRepository;
import homeWork38.repositories.ProductsRepository;
import homeWork38.repositories.UsersRepository;
import homeWork38.services.OrderService;
import homeWork38.services.ProductsService;
import homeWork38.services.UsersService;
import homeWork38.view.Menu;
/*
Реализовать в том же Menu функционал для добавления товаров и получения и списка
Реализовать ProductsService
Реализовать ProductsRepository
Задание со звездочкой - попробуйте сделать функционал оформления заказа
 */
public class Main {
    public static void main(String[] args) {

        UsersRepository usersRepository  = new UsersRepository();
        ProductsRepository productsRepository = new ProductsRepository();
        OrdersRepository ordersRepository = new OrdersRepository();

        UsersService usersService = new UsersService(usersRepository);
        OrderService orderService = new OrderService(ordersRepository, usersRepository);
        ProductsService productsService = new ProductsService(productsRepository, orderService);

        Menu menu = new Menu(usersService, productsService, orderService);
        menu.run();
    }
}











