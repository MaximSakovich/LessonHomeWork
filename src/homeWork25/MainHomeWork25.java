package homeWork25;

public class MainHomeWork25 {
    public static void main(String[] args) {
        Processor processor1 = new Processor("Intel", "Core i7");
        Memory memory1 = new Memory("Corsair", "16GB DDR4");
        Storage storage1 = new Storage("Samsung", "1TB SSD");

        Computer computer1 = new Computer(new Processor[]{processor1}, new Memory[]{memory1}, new Storage[]{storage1});

        Processor processor2 = new Processor("AMD", "Ryzen 9");
        Memory memory2 = new Memory("Kingston", "32GB DDR4");
        Storage storage2 = new Storage("WD", "2TB SSD");

        Computer computer2 = new Computer(new Processor[]{processor2}, new Memory[]{memory2}, new Storage[]{storage2});

        Processor processor3 = new Processor("Apple", "M2");
        Memory memory3 = new Memory("G.Skill", "64GB DDR5");
        Storage storage3 = new Storage("Asus", "4TB SSD");

        Computer computer3 = new Computer(new Processor[]{processor3}, new Memory[]{memory3}, new Storage[]{storage3});

        System.out.println(computer1);
        System.out.println();
        System.out.println(computer2);
        System.out.println();
        System.out.println(computer3);
    }
}
