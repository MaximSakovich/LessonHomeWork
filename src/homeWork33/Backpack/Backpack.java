package homeWork33.Backpack;

public class Backpack {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
                int[] weights = {3, 4, 5, 8, 9};
                int[] prices = {1, 6, 4, 7, 6};

                int maxWeight = 13;

                long count = 2L << weights.length;

                int maxPrice = 0;
                long maxState = 0;
                int maxStateWeight = 0;
                int itemCount = 0;
                int totalPrice = 0;

                for (long state = 0; state < count; state++) {
                    int price = statePrice(state, prices);
                    int weight = stateWeight(state, weights);
                    if (weight <= maxWeight) {
                        if (maxPrice < price) {
                            maxPrice = price;
                            maxState = state;
                            maxStateWeight = weight;
                            itemCount = 0;
                            totalPrice = 0;
                            for (int i = 0; i < weights.length; i++) {
                                if ((1L << i & maxState) > 0) {
                                    itemCount++;
                                    totalPrice += prices[i];
                                }
                            }
                        }
                    }
                }

                System.out.println("Оптимальное содержимое рюкзака:");
                long powerOfTwo = 1;
                for (int i = 0; i < weights.length; i++) {
                    if ((powerOfTwo & maxState) > 0) {
                        System.out.println("Элемент " + (i + 1) + " - стоимость: " + prices[i] + ", вес: " + weights[i]);
                    }
                    powerOfTwo <<= 1;
                }

                System.out.println("Число элементов в рюкзаке: " + itemCount);
                System.out.println("Общая стоимость элементов в рюкзаке: " + totalPrice);
                System.out.println("Общая стоимость рюкзака: " + maxPrice);
                System.out.println("Общий вес рюкзака: " + maxStateWeight);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Время выполнения: " + duration + " миллисекунд.");
            }

            private static int stateWeight(long state, int[] weights) {
                long powerOfTwo = 1;
                int weight = 0;
                for (int i = 0; i < weights.length; i++) {
                    if ((powerOfTwo & state) != 0) {
                        weight += weights[i];
                    }
                    powerOfTwo <<= 1;
                }
                return weight;
            }

            private static int statePrice(long state, int[] prices) {
                long powerOfTwo = 1;
                int price = 0;
                for (int i = 0; i < prices.length; i++) {
                    if ((powerOfTwo & state) != 0) {
                        price += prices[i];
                    }
                    powerOfTwo <<= 1;
                }
                return price;
    }
}
