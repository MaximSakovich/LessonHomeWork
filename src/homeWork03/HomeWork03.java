package homeWork03;

public class HomeWork03 {

    public static void main(String[] args) {
        int var1 = 0;
        int var2 = 1;
        int var3 = 2;
        int var4 = 3;
        int var5 = 4;
        int var6 = 5;
        int var7 = 6;
        int var8 = 7;
        int var9 = 8;
        int var10 = 9;
        int countVariables = 10;
        int averageValue = (var1 + var2 + var3 + var4 + var5 + var6 + var7 + var8 + var9 + var10) / countVariables;
        //Сколько программа отбросила в дробной части? 0.5
        double q = (double) (var1 + var2 + var3 + var4 + var5 + var6 + var7 + var8 + var9 + var10) / countVariables;
        System.out.println("Среднее арифметическое: " + averageValue);
        System.out.println(q % 10);
        double priceA = 1000;
        double priceB = 500;
        double skidka = ((double) (priceA + priceB) * 10) / 100;
        double sumDiskont = (priceA + priceB) - skidka;
        System.out.format("Сумма товара со скидкой: %.2f \n", sumDiskont);
        System.out.format("Сумма скидки: %.2f \n", skidka);
        double fr = 30.2;
        double sa = 31.2;
        double so = 32.1;
        double mo = 32.3;
        double di = 30.4;
        double mi = 32.6;
        double don = 32.5;
        double middle = ((double) fr + sa + so + mo + di + mi + don) / 7;
        System.out.format("Средняя температура за неделю: %.1f C\n", middle);
        //могут получаться в качестве остатка от деления какого-либо целого числа
        // на 2  = 0,1
        // На 3  = 0,1,2
        // операции x += x++
        int x = 3;
        x++; // x = x+1; x=4
        System.out.println(++x); //x=5
        x--; // x = x-1; x=4
        System.out.println(--x);//x=3
        int y = 10;
        y +=5;  // y = y+5;
        System.out.println(y);
        int z = 20;
        z -=5;  // z = z-5;
        System.out.println(z);
        z *=5;  // z = z*5;
        System.out.println(z);
        z /=5;  // z = z/5;
        System.out.println(z);

    }
}
