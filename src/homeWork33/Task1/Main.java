package homeWork33.Task1;
/*Task
Смоделировать предметную область "Телевизор"
Классы:
    - Телевизор
    - Канал
    - Передача
    - Пульт
В телевизоре есть множество каналов.
У каждого канала есть множество передач
У каждого канала есть номер.

Сделать пульт, который имеет ссылку на телевизор.
У пульта должен быть метод on(номер канала)
При вызове этого метода, канал с нужным номером показывает случайную передачу
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Program[] programs = new Program[1000];
        for (int i = 0; i < 1000; i++) {
            programs[i] = new Program("Передача " + (i + 1));
        }
        Channel[] channels = new Channel[5];
        int programsCount = programs.length;
        int channelsCount = channels.length;
        int programsPerChannel = programsCount / channelsCount;

        for (int i = 0; i < channelsCount; i++) {
            // Проверка границ массива перед инициализацией каналов
            int startIndex = i * programsPerChannel;
            int endIndex = (i + 1 == channelsCount) ? programsCount : (i + 1) * programsPerChannel;
            Program[] channelPrograms = new Program[endIndex - startIndex];
            for (int j = startIndex; j < endIndex; j++) {
                channelPrograms[j - startIndex] = programs[j];
            }
            channels[i] = new Channel(i + 1, channelPrograms);
        }

        Television television = new Television(channels);
        RemoteControl remoteControl = new RemoteControl(television);
        Scanner scanner = new Scanner(System.in);
        int selectedChannel;
        do {
            System.out.println("Выберите канал от 1 до 5 (для выключения Телевизора нажмите 0): ");
            selectedChannel = scanner.nextInt();
            if (selectedChannel < 0 || selectedChannel > 5) {
                System.err.println("Такого канала не существует. Попробуйте снова.");
                continue;
            }
            if (selectedChannel != 0) {
                remoteControl.on(selectedChannel);
                System.out.println("Текущий канал: " + selectedChannel);
            }
        } while (selectedChannel != 0);
        scanner.close();
    }
}

