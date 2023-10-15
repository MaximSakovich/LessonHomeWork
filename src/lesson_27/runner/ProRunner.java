package lesson_27.runner;

public class ProRunner extends Human{


    public ProRunner() {
        setSpeed(25);
        setRestTime(5);
        super.typeRunner = "Pro runner";
    }

    public ProRunner(int speed, int restTime) {
        super(speed, restTime);
        super.typeRunner = "Pro runner";
    }
}