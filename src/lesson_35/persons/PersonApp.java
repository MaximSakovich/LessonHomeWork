package lesson_35.persons;

public class PersonApp {
    public static void main(String[] args) {
        Person person = new Person("email", "password");
        System.out.println(person);
        person.setEmail("email");

        String test = "01@235689";
        System.out.println(test.indexOf('@'));
        System.out.println(test.lastIndexOf('@'));
        System.out.println(test.indexOf('1'));
        System.out.println(test.indexOf('1', 3));

        System.out.println(person);
        person.setEmail("a_sd@fff.ff");
        System.out.println(person);

        String password = "Password@1";
        System.out.println("Действителен ли пароль? " + person.isPasswordValid(password));
    }
}
