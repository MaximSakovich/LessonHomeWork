package homeWork33.Task3Min2;

public class Main {
    public static void main(String[] args) {
                int[] array = new int[]{120, 42, 73, 41, 32, 53, 187, 24, 57, 42, -16, 55, 36};

                int min = Integer.MAX_VALUE;
                int min2 = Integer.MAX_VALUE;

                for (int i : array) {
                    if (i < min) {
                        min2 = min;
                        min = i;
                    } else if (i < min2 && i != min) {
                        min2 = i;
                    }
                }

                if (min2 != Integer.MAX_VALUE) {
                    System.out.println("Второй по минимальности элемент в массиве: " + min2);
                } else {
                    System.out.println("Второго по минимальности элемента нет");
                }
                System.out.println("Минимальный элемент в массиве: " + min);
            }
        }