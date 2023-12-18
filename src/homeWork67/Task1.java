package homeWork67;

//Task 1:
//Разработать многопоточное приложение, где три различных потока печатают три разные буквы (например, 'A', 'B', 'C')
// в строгом порядке ABC по 20 раз.
//Создайте три потока - Каждый поток отвечает за печать определенной буквы ('A', 'B' или 'C').
//Все три потока запускаются одновременно.
//Синхронизация печати: - Необходимо синхронизировать потоки таким образом,
// чтобы они печатали свои буквы в последовательности ABC. То есть, сначала печатается 'A', затем 'B', затем 'C',
// и цикл повторяется. - Последовательность ABC должна повториться 20 раз.

public class Task1 {
    private static final Object lock = new Object();
    private static volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintTask('A'));
        Thread threadB = new Thread(new PrintTask('B'));
        Thread threadC = new Thread(new PrintTask('C'));

        threadA.start();
        threadB.start();
        threadC.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class PrintTask implements Runnable {
        private final char letter;

        public PrintTask(char letter) {
            this.letter = letter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                synchronized (lock) {
                    try {
                        while (letter != currentLetter) {
                            lock.wait();
                        }
                        System.out.print(letter + " ");

                        switch (letter) {
                            case 'A':
                                currentLetter = 'B';
                                break;
                            case 'B':
                                currentLetter = 'C';
                                break;
                            case 'C':
                                currentLetter = 'A';
                                break;
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.notifyAll();
                    }
                }
            }
        }
    }
}