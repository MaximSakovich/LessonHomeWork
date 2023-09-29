package homeWork15;


public class Task3 {
    public static void main(String[] args) {
        // Task 3
       /* Написать метод, принимающий на вход массив строк.
       Метод должен вернуть массив, состоящий из самой короткой
       и самой длинной строки изначального массива. */

        String[] strings = {"One", "Two", "Twenty"};
        String[] result = shorLongestStrings(strings);

        System.out.println("Самая короткая строка: " + result[0]);
        System.out.println("Самая длинная строка: " + result[1]);
        System.out.println("Старый массив целиком: ");
        for (String str : strings) {
            System.out.println(str);
        }
        System.out.println("\nНовый массив целиком: ");
        for (String str : result) {
            System.out.println(str);
        }
    }
        //Метод, принимающий на вход массив строк, и возвращающий новый массив
        //из самой короткой и самой длинной строки изначального массива
        public static String[] shorLongestStrings (String[]inputStrings){
            if (inputStrings == null || inputStrings.length == 0) {
                return new String[0];
            }

            String shor = inputStrings[0];
            String longest = inputStrings[0];

            for (String str : inputStrings) {
                if (str.length() < shor.length()) {
                    shor = str;
                } else if (str.length() > longest.length()) {
                    longest = str;
                }
            }
            return new String[]{shor, longest};
        }
    }

