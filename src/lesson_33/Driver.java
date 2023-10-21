package lesson_33;

public class Driver {

    private String name;

    private Bus bus; // ссылка на автобус, в котором находится водитель

    public Driver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void goToBus(Bus bus) { // говорим водителю идти в нужный автобус
        this.free();
        this.bus = bus; // говорим водителю, что он закреплен за автобусом
        // а как сделать так, чтобы автобус тоже об этом знал?
        bus.setDriver(this);
    }

    private void free() {
        if (bus != null) { // проверяем, что автобус был
            System.out.println("Водитель " + name + " освобождает автобус " + bus.getNumber());
            this.bus.freeDriver(); // освободили водителя у автобуса
        }
        this.bus = null; // убрали автобус у водителя
    }

}
