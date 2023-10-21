package homeWork33.Task0;


//Класс Телевизор
public class Television {
    private final Channel[] channels;
    public Television(Channel[] channels) {
        this.channels = channels;
    }
    public void showProgram(int channelNumber) {
        for (Channel channel : channels) {
            if (channel.getChannelNumber() == channelNumber) {
                channel.showRandomProgram();
                return;
            }
        }
        System.err.println("Канал номер " + channelNumber + " не найден.");
    }

}
