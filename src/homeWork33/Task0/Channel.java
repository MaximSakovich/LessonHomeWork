package homeWork33.Task0;

import java.util.Random;

//Класс Канал
public class Channel {
    private final int channelNumber;
    private final Program[] programs;
    public Channel(int channelNumber, Program[] programs) {
        this.channelNumber = channelNumber;
        this.programs = programs;
    }
    public int getChannelNumber() {
        return channelNumber;
    }

    // Метод отображение случайной передачи на канале
    public void showRandomProgram() {
        if (programs.length > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(programs.length);
            System.out.println("Канал " + channelNumber + " Отображение передачи: " + programs[randomIndex].getName());
        } else {
            System.out.println("На этом канале нет доступных передач.");
        }
    }
}
