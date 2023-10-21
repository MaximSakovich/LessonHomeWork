package homeWork33.Task0;
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
public class Main {
    public static void main(String[] args) {
        Program program1 = new Program("Про животных");
        Program program2 = new Program("КИНО");
        Program program3 = new Program("БАЛЕТ");
        Program[] channel1Programs = { program1, program2, program3 };

        Channel channel1 = new Channel(1, channel1Programs);

        Program program4 = new Program("В мире интересного");
        Program program5 = new Program("Новости");
        Program program6 = new Program("ПРОИСШЕСТВИЯ");
        Program[] channel2Programs = { program4, program5, program6 };

        Channel channel2 = new Channel(2, channel2Programs);

        Channel[] channels = { channel1, channel2 };

        Television television = new Television(channels);
        RemoteControl remoteControl = new RemoteControl(television);

        remoteControl.on(1);
        remoteControl.on(2);
        remoteControl.on(3); // Несуществующий канал
    }
}
