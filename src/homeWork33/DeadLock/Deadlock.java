package homeWork33.DeadLock;

public class Deadlock {
    public static void main(String[] args) {
       Object lock1 = new Object();
       Object lock2 = new Object();

Thread tread1 = new Thread(() -> {
    System.out.println(Thread.currentThread().getName() + "start");
synchronized (lock1) {

    try {Thread.sleep(100);
    } catch (InterruptedException e) {
e.printStackTrace();}

    synchronized (lock2) {
    }
  }
    System.out.println(Thread.currentThread().getName() + "end");
}, "Thread1 ");

Thread tread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "start");
            synchronized (lock2) {
                synchronized (lock1) {
                }
            }
    System.out.println(Thread.currentThread().getName() + "end");
        }, "Thread2 ");
tread1.start();
tread2.start();
    }
}
