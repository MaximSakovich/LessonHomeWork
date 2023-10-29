package homeWork38.repositories;

import homeWork38.models.Order;

public class OrdersRepository {
    private static final int MAX_ORDERS_COUNT = 100;
    private Order[] orders;
    private int ordersCount;

    public OrdersRepository() {
        this.orders = new Order[MAX_ORDERS_COUNT];
    }

    public void save(Order order) {
        this.orders[ordersCount] = order;
        this.ordersCount++;
    }

    public Order[] findAll() {
        Order[] copy = new Order[ordersCount];
        System.arraycopy(orders, 0, copy, 0, ordersCount);
        return copy;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }
}
