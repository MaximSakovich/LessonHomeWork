package homeWork54.Task2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Task 2
//Дан список Person с полями name, age, city. Используйте Stream API для фильтрации людей,
// которые старше определенного возраста и проживают в определенном городе, а затем соберите их в список.

class Person {
    private final String name;
    private final int age;
    private final String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Матвей", 25, "Париж"),
                new Person("Борис", 31, "Лондон"),
                new Person("Максим", 35, "Лондон"),
                new Person("Данил", 40, "Берлин"),
                new Person("Андрей", 42, "Берлин")
        );
        int filterAge = 30;
        String filterCity = "Лондон";
        List<Person> result = personList.stream()
                .filter(person -> person.getAge() > filterAge && person.getCity().equals(filterCity))
                .collect(Collectors.toList());

        result.forEach(person -> System.out.println(person.getName() + ", " + person.getAge() + ", " + person.getCity()));
        result.forEach(System.out::println);
    }
}
