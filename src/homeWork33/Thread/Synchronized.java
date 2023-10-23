package homeWork33.Thread;

public class Synchronized {
    public static void main(String[] args) {
        test2();
    }

    private static int counter;
    public static void test1() {

        Runnable runnable = new Runnable() {
            @Override
           public void run() {
                synchronized (this) {
                    counter = 0;
                    for (int i = 0; i < 8; i++) {
                        counter = counter + 1;
                        System.out.println(Thread.currentThread().getName() + ": " + counter);
                    }
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }

    public static void test2() {
        StringBuffer stringBuilder = new StringBuffer();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                stringBuilder
                        .append("long hello world long hello world long hello world: ")
                        .append(Thread.currentThread().getName())
                        .append("\n");
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);
        Thread thread7 = new Thread(runnable);
        Thread thread8 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }

        System.out.println(stringBuilder);
    }
}
