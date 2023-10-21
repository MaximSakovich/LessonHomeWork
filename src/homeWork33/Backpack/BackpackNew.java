package homeWork33.Backpack;

public class BackpackNew {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] weights = {3, 4, 5, 8, 9, 5, 7, 9, 12, 15, 17, 18, 20};
        int[] prices = {1, 6, 4, 7, 6, 4, 6, 10, 9, 10, 9, 12, 12};

        int maxWeight = 87;

        long count = 1 << weights.length;

        int maxPrice = 0;
        int maxState = 0;
        int maxStateWeight = 0;
        int itemCount = 0;
       // int totalPrice = 0;

        for (int state = 0; state < count; state++) {
            int price = 0;
            int weight = 0;
            int countItems = 0;
            int total = 0;
            for (int i = 0; i < weights.length; i++) {
                if (((state >> i) & 1) == 1) {
                    countItems++;
                    total += prices[i];
                    weight += weights[i];
                }
            }
            if (weight <= maxWeight && total > maxPrice) {
                maxPrice = total;
                maxState = state;
                maxStateWeight = weight;
                itemCount = countItems;
               // totalPrice = total;
            }
        }

        System.out.println("Оптимальное содержимое рюкзака:");
        for (int i = 0; i < weights.length; i++) {
            if (((maxState >> i) & 1) == 1) {
                System.out.println("Элемент " + (i + 1) + " - стоимость: " + prices[i] + ", вес: " + weights[i]);
            }
        }

        System.out.println("Число элементов в рюкзаке: " + itemCount);
        System.out.println("Общая стоимость элементов в рюкзаке: " + maxPrice);
        System.out.println("Общая вместимость рюкзака: " + maxWeight);
        System.out.println("Общий вес элементов в рюкзаке: " + maxStateWeight);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println();
        System.out.println("Время выполнения: " + duration + " миллисекунд.");
    }
}
