package lesson_05;

public class Main {
    public static void main(StringExample[] args) {
char a = 'A';// А латинского алфавита
char b = 65;// в 10-ричной системе
char c = 0x41;// в 16-ричной системе
char d = '\u0041';// Unicode
        System.out.println("a:" + a + b);
        System.out.println(c);
        c++;
        System.out.println(c);
        c+=3;
        System.out.println(c);
        System.out.println(d);



    }
}
