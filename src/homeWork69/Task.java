package homeWork69;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


//Task 1: Многопоточный Ресторан
//Разработать многопоточное приложение, имитирующее работу ресторана.
//Основные требования:
//Ограниченное Количество Столов:
//В ресторане есть ограниченное количество столов (например, 5 столов).
//Прием Заказов:
//Каждый посетитель (представленный отдельным потоком) приходит в ресторан и, если есть свободный стол, занимает его.
//Если свободных столов нет, посетитель ожидает.
//Обработка Заказов:
//Каждый заказ требует определенного времени для обработки (например, приготовления блюда).
// Используйте Thread.sleep() для имитации времени обработки.
//Количество одновременно обрабатываемых заказов ограничено (например, кухня может готовить до 3 блюд одновременно).
//Статистика:
//Подсчитайте общее количество обслуженных посетителей и среднее время обслуживания.
//P.S. Я бы использовал атомарные классы для подсчета статистики и других счетчиков.
//Завершение Работы:
//После обслуживания определенного количества посетителей (например, 30)
// ресторан закрывается, и программа завершает свою работу.
//Ожидаемый Результат:
//Программа должна корректно симулировать работу ресторана с учетом ограниченного количества столов и одновременно
//обрабатываемых заказов, вести статистику и корректно завершать свою работу
// после обслуживания заданного числа посетителей.

public class Task {
    private static final int NUM_TABLES = 5;
    private static final int MAX_SIMULTANEOUS_ORDERS = 3;
    private static final int TOTAL_CUSTOMERS = 30;

    private static final Semaphore tableSemaphore = new Semaphore(NUM_TABLES);
    private static final Semaphore orderSemaphore = new Semaphore(MAX_SIMULTANEOUS_ORDERS);
    private static final AtomicInteger totalCustomers = new AtomicInteger(0);
    private static final AtomicInteger totalServiceTime = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread[] customers = new Thread[TOTAL_CUSTOMERS];

        for (int i = 0; i < TOTAL_CUSTOMERS; i++) {
            customers[i] = new Thread(new Customer(i + 1));
            customers[i].start();
        }

        for (Thread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Ресторан закрыт. Обслужено " + totalCustomers.get() + " посетителей.");
        System.out.println("Среднее время обслуживания: " +
                (totalServiceTime.get() / totalCustomers.get()) + " секунд.");
    }

    static class Customer implements Runnable {
        private final int customerNumber;

        public Customer(int customerNumber) {
            this.customerNumber = customerNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Посетитель " + customerNumber + " входит в ресторан.");

                tableSemaphore.acquire(); // Занимаем стол

                System.out.println("Посетитель " + customerNumber + " занял стол.");

                orderSemaphore.acquire(); // Заказываем блюдо
                int orderProcessingTime = placeOrder();
                orderSemaphore.release(); // Блюдо готово, освобождаем разрешение

                System.out.println("Посетитель " + customerNumber + " получил заказ и обедает.");
                Thread.sleep(orderProcessingTime * 1000);

                System.out.println("Посетитель " + customerNumber + " закончил обед и уходит.");

                totalServiceTime.addAndGet(orderProcessingTime);
                totalCustomers.incrementAndGet();

                tableSemaphore.release(); // Освобождаем стол
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Метод имитации времени обработки заказа
        private int placeOrder() throws InterruptedException {
            int processingTime = (int) (Math.random() * 5) + 3;
            Thread.sleep(processingTime * 1000);
            return processingTime;
        }
    }
}