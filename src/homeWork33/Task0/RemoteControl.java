package homeWork33.Task0;

// Класс пульт
public class RemoteControl {
    private final Television television;
    public RemoteControl(Television television) {
        this.television = television;
    }
    public void on(int channelNumber) {
        television.showProgram(channelNumber);
    }
    }


