package homeWork66;

//Task 1:
//Напишите программу, в которой запускается одновременно два потока.
// Один поток 1000 раз увеличивает переменную counter на 1, а второй поток 1000 раз
// уменьшает туже переменную на 1. По завершении работы обоих потоков выведите в консоль
// значение переменной counter. Убедитесь, что оно равно 0.

public class Task1 {
    private static int counter = 0;

    public static void main(String[] args) {
        Object lock = new Object();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    counter++;
                }
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    counter--;
                }
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Значение переменной counter: " + counter);
    }
}
