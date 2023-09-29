package homeWork05;

public class HomeWork05 {
    public static void main(String[] args) {
        //Task 01
        String name = "Maksyma";
        System.out.println(name.length());
        char firstChar = name.charAt(0);
        System.out.println("firstChar: " + firstChar);
        char lastChar = name.charAt(name.length() - 1);
        System.out.println("lastChar: " + (int)lastChar);
        int fist = firstChar;
        int last = lastChar;
        System.out.println("Десятичный код: " + fist);
        System.out.println("Десятичный код: " + last);
        //Task 02
        String str1 = "Java";
        String str2 = "is";
        String str3 = "a";
        String str4 = "powerful";
        String str5 = "language";
        String concatStr = str1 + " " + str2 + " " + str3 + " " + str4 + " " + str5;
        System.out.println(concatStr);
        String concatStr2 = String.join(" ", str1, str2, str3, str4, str5);
        System.out.println(concatStr2);
        System.out.println(concatStr.length());
        //Task 02.2
        concatStr = concatStr.replace("powerful", "super");
        System.out.println(concatStr);
        System.out.println("Содержит ли строка подстроку age: " + concatStr.contains("age"));
        //Task 03
        String a = "string";
        String b = "code";
        String c = "Practice";
        int middleIndex = a.length()/2;
        String subStr = a.substring(middleIndex-1, middleIndex+1);
        System.out.println(subStr);
        String subA = a.substring(2, 4);
        System.out.println(subA);
        String subB = b.substring(1, 3);
        System.out.println(subB);
        String subC = c.substring(3, 5);
        System.out.println(subC);
    }
}
