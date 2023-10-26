package lesson_36.cars;

import java.util.Arrays;
import java.util.Comparator;

public class CarsAppOld {
    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car("Alfa", 2022, 190);
        cars[1] = new Car("BMW", 2000, 190);
        cars[2] = new Car("Citroen", 2018, 170);
        cars[3] = new Car("Dodge", 2021, 205);
        cars[4] = new Car("Ferrari", 2021, 300);

        System.out.println(Arrays.toString(cars));

        int[] ints = new int[]{9, 5, 1, 2, 4, 3, 0};
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        Arrays.sort(cars);
        System.out.println(Arrays.toString(cars));

        CarYearComparator carYearComparator = new CarYearComparator();
        CarSpeedComparator carSpeedComparator = new CarSpeedComparator();

        Arrays.sort(cars, carYearComparator);
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, carSpeedComparator);
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getModel().compareTo(car2.getModel());
            }
        });
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, (car1, car2) -> car2.getModel().compareTo(car1.getModel()));
        Arrays.sort(cars, Comparator.comparing(Car::getModel));

        Arrays.sort(cars, (car1, car2) -> car2.getYear() - (car1.getYear()));
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, (car1, car2) -> {
            int yearCompare = Integer.compare(car1.getYear(), car1.getYear());
            if (yearCompare == 0) {
                return car2.getModel().compareTo(car1.getModel());
            } else {
                return yearCompare;
            }
        });
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, (car1, car2) -> car2.getMaxSpeed() - (car1.getMaxSpeed()));
        System.out.println(Arrays.toString(cars));


        Comparator<Car> speedYearComparator = Comparator
                .comparing(Car::getMaxSpeed)
                .reversed().thenComparing(Car::getYear);
        Arrays.sort(cars, speedYearComparator);
        System.out.println(Arrays.toString(cars));

        Comparator<Car> YearComparator = Comparator
                .comparing(Car::getYear)
                .reversed().thenComparing(Car::getMaxSpeed);
        Arrays.sort(cars, YearComparator);
        System.out.println(Arrays.toString(cars));

        Comparator<Car> yearSpeedComparator = Comparator
                .comparing(Car::getYear)
                .thenComparing(Car::getMaxSpeed).reversed();
        Arrays.sort(cars, yearSpeedComparator);
        System.out.println(Arrays.toString(cars));

        Comparator<Car> SpeedYearComparator = Comparator
                .comparing(Car::getYear)
                .thenComparing(Comparator.comparing(Car::getMaxSpeed).reversed());
        Arrays.sort(cars, SpeedYearComparator);
        System.out.println(Arrays.toString(cars));


    }
}
