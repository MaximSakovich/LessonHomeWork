package lesson_05;

public class StringExample {
    public static void main(String[] args) {
        char a = 'A'; // Переменная будет хранить букву A латинского алфавита
        char b = 65; // Переменная будет хранить букву A латинского алфавита, соответсвующую кодy 65 в десятичной системе
        char c = 0x41; // Переменная будет хранить букву A латинского алфавита, соответсвующую коду 41 в шестнадцатеричной системе
        c = 0x0041;
        char d = '\u0041';
        char x = '\u1547';

        String string = "Java";
        int length = string.length();
        System.out.println(string.length());
        System.out.println(string.toUpperCase());
        System.out.println(string);
        String stringUpper = string.toUpperCase();
        System.out.println(stringUpper);
        String str1 = "One";
        String str2 = " ";
        String str3 = "hello";
        String concatStr = str1 + str2 + str3;
        System.out.println(concatStr);
        String concatStr2 = str1.concat(str2);
        concatStr2 = concatStr2.concat(str3);
        System.out.println(concatStr);
        System.out.println(concatStr2);

        String concatStr3 = String.join("_", str1, str2, str3);
        System.out.println(concatStr3);
        int id = 1;
        String string2 = concatStr3 + id;
        System.out.println(string2);
        System.out.println("My age: " + id);
        String digits = "0123456789fghj679";
        String digits2 = "1123456783";
        System.out.println(digits.length());
        char firstChar = digits.charAt(0);
        char firstChar2 = digits2.charAt(0);
        System.out.println("firstChar: " + firstChar);
        System.out.println("firstChar: " + firstChar2);
        char lastChar = digits.charAt(digits.length() - 1);
        System.out.println("firstChar: " + lastChar);
        String subString = digits.substring(2);
        System.out.println(subString);
        String subString2 = digits.substring(2, 5);
        System.out.println(subString2);

concatStr3 = concatStr3.concat("One");
        System.out.println(concatStr3);
    concatStr3 = concatStr3.replaceFirst("One", "Www");//Заменяет первое найденное совпадение
    concatStr3= concatStr3.replaceAll("One", "Wwww");//Заменяет все найденные совпадения
        System.out.println(concatStr3);
        String replStr = concatStr3.replace("One", "World");
        System.out.println(replStr);
    }
}































