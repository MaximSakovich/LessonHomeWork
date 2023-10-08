package homeWork22;

import java.awt.*;

public class Main22 {
    public static void main(String[] args) {
        //record Point(double x, int y) {} // так можно писать начиная с 17 версии
        //System.out.println(new Point(2,3));
        double x = 0.1;
        x += 0.1;
        x += 0.1;
        System.out.println(x == 0.3);
        System.out.println(x);

        double a = Long.MAX_VALUE;
        long b = Long.MAX_VALUE;
        int c = 1;
        System.out.println(a + b + c);
        System.out.println(c + b + a);

    }
   private int hash;

}
