package homeWork33.Task1;


//Класс Телевизор
public class Television {
    private final Channel[] channels;
    public Television(Channel[] channels) {
        this.channels = channels;
    }

    // Метод для отображения передачи на заданном канале
    public void showProgram(int channelNumber) {
        for (Channel channel : channels) {
            if (channel.getChannelNumber() == channelNumber) {
                channel.showRandomProgram();
                return;
            }
        }
    }
}
