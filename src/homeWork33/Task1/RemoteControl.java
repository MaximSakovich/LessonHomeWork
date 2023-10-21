package homeWork33.Task1;

// Класс пульт
public class RemoteControl {
    private final Television television;
    public RemoteControl(Television television) {
        this.television = television;
    }
    // Метод, который принимает в качестве параметра номер канала.
    public void on(int channelNumber) {
        television.showProgram(channelNumber);
    }
}


