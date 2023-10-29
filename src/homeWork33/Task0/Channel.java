package homeWork33.Task0;

import java.util.Random;

//Класс Канал
public class Channel {
    private final int channelNumber;
    private String nameChannel;
    private final Program[] programs;

    public Channel(int channelNumber, String nameChannel, Program[] programs) {
        this.channelNumber = channelNumber;
        this.nameChannel = nameChannel;
        this.programs = programs;
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public String getNameChannel() {
        return nameChannel;
    }


    // Метод отображение случайной передачи на канале
    public void showRandomProgram() {
        if (programs.length > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(programs.length);
            System.out.println("Канал " + channelNumber + " (" + nameChannel + ") Отображение передачи: " + programs[randomIndex].getName());
        } else {
            System.out.println("На этом канале " + nameChannel + " нет доступных передач.");
        }
    }
}
