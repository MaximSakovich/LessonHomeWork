package homeWork16;


public class Task3 {
    public static void main(String[] args) {
        //Task 3
        //Написать метод по поиску строки в массиве строк.
        //На вход метод принимает массив строк, и строку для поиска.
        String[] strArray = {"night", "morning", "One", "Two", "Twenty"};
        String searchString = "morning";

        int resultIndex = findStringInArray(strArray, searchString);

        if (resultIndex != -1) {
            System.out.println("Строка '" + searchString + "' найдена в массиве на позиции " + (resultIndex+1));
        } else {
            System.out.println("Строка '" + searchString + "' не найдена в массиве.");
        }
    }

    // Метод для поиска строки в массиве строк
    public static int findStringInArray(String[] arr, String searchString) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(searchString)) {
                return i;
            }
        }

        return -1;
    }
}
