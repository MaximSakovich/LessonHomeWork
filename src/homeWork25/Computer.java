package homeWork25;
/*Компьютер и компоненты

        Создайте базовый класс Component с полями brand (бренд) и model (модель).
        Создайте производные классы: Processor, Memory, Storage от класса Component.
        Создайте класс Computer который будет содержать компоненты: процессор, память и накопитель.
        Реализуйте отношение композиции между Computer и компонентами. Компонент не может существовать без компьютера.
*/

public class Computer {
    private final int ID;
    private final Processor[] processors;
    private final Memory[] memories;
    private final Storage[] storage;

    private static int counter = 1;

    public Computer(Processor[] processors, Memory[] memories, Storage[] storage) {
        this.processors = processors;
        this.memories = memories;
        this.storage = storage;
        this.ID = counter++;
    }

   public int getID() {
        return ID;
    }

    public Processor[] getProcessors() {
        return processors;
    }

    public Memory[] getMemories() {
        return memories;
    }

    public Storage[] getStorage() {
        return storage;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Computer ID: " + ID + "\n");

        result.append("Processors:\n");
        for (Processor processor : processors) {
            result.append(processor.getBrand()).append(" ").append(processor.getModel()).append("\n");
        }

        result.append("Memories:\n");
        for (Memory memory : memories) {
            result.append(memory.getBrand()).append(" ").append(memory.getModel()).append("\n");
        }

        result.append("Storage:\n");
        for (Storage s : storage) {
            result.append(s.getBrand()).append(" ").append(s.getModel()).append("\n");
        }

        return result.toString();
    }
}