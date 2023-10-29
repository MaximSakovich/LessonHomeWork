package homeWork38.services;

import homeWork38.models.Order;
import homeWork38.repositories.OrdersRepository;
import homeWork38.repositories.UsersRepository;

public class OrderService {
    private OrdersRepository ordersRepository;
    private UsersRepository usersRepository;

    public OrderService(OrdersRepository ordersRepository, UsersRepository usersRepository) {
        this.ordersRepository = ordersRepository;
        this.usersRepository = usersRepository;
    }

    public void placeOrder(String customerEmail, String productTitle, int count) {
        if (usersRepository.isExistsByEmail(customerEmail)) {
            Order order = new Order(customerEmail, productTitle, count);
            ordersRepository.save(order);
        } else {
            System.err.println("Пользователь с таким email не зарегистрирован. Пожалуйста, зарегистрируйтесь.");
            return;
        }
    }

    public int getTotalReservedProduct(String productTitle) {
        Order[] orders = ordersRepository.findAll();
        int totalReserved = 0;
        for (Order order : orders) {
            if (order.getProductTitle().equals(productTitle)) {
                totalReserved += order.getCount();
            }
        }
        return totalReserved;
    }
    public Order[] getAllOrders() {
        return ordersRepository.findAll();
    }

    public void setOrdersRepository(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
}