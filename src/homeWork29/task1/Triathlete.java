package homeWork29.task1;

// Реализация класса Triathlete, который реализует оба интерфейса
public class Triathlete implements Swimmer, Runner {

    @Override
    public void swim() {
        System.out.println("Триатлонист плавает.");
    }

    @Override
    public void run() {
        System.out.println("Триатлонист бежит.");
    }
}

