package homeWork68;

import java.util.Random;
import java.util.concurrent.Semaphore;

//Task 1: Парковка
//Создать многопоточное приложение для симуляции работы парковки с учетом
// различного времени пребывания автомобилей и ведения статистики.
//Создайте парковку на 5 мест.
//Напишите код для 10 потоков, где каждый поток представляет собой автомобиль, который пытается припарковаться.
//Организовать контроль доступа к парковочным местам. При отсутствии свободных мест автомобиль должен ожидать.
//Каждый автомобиль должен проводить на парковке случайное количество времени от 3 до 10 секунд.
//Программа должна учитывать общее время, проведенное всеми автомобилями на парковке.
//По завершении работы всех потоков программа должна рассчитать и
// вывести среднее время пребывания одного автомобиля на парковке.
//В консоль должны выводиться сообщения о приезде автомобиля, его парковке, времени пребывания на парковке и уезде.
public class Task {
    private static final int PARKING_SPOTS = 5;
    private static final int NUM_CARS = 10;

    private static Semaphore parkingSemaphore = new Semaphore(PARKING_SPOTS);
    private static volatile int totalParkingTime = 0;

    public static void main(String[] args) {
        Thread[] cars = new Thread[NUM_CARS];

        for (int i = 0; i < NUM_CARS; i++) {
            cars[i] = new Thread(new Car(i));
            cars[i].start();
        }

        for (Thread car : cars) {
            try {
                car.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int averageParkingTime = totalParkingTime / NUM_CARS;
        System.out.println("Среднее время пребывания на парковке: " + averageParkingTime + " секунд.");
        System.out.println("Симуляция завершена.");
    }

    static class Car implements Runnable {
        private final int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Автомобиль " + carNumber + " прибыл на парковку.");
                long startTime = System.currentTimeMillis();

                parkingSemaphore.acquire();
                System.out.println("Автомобиль " + carNumber + " припаркован.");

                int stayDuration = new Random().nextInt(8) + 3;
                Thread.sleep(stayDuration * 1000);

                long endTime = System.currentTimeMillis();
                int parkingTime = (int) ((endTime - startTime) / 1000);
                totalParkingTime += parkingTime;

                System.out.println("Автомобиль " + carNumber + " покинул парковку после " + stayDuration + " секунд.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                parkingSemaphore.release();
            }
        }
    }
}