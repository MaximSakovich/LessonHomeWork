package lesson_36.test;

import lesson_35.persons.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;
    String startEmail = "john@test.com";
    String startPassword = "qwerty1Q!";
    @BeforeEach
    void setUp() {person = new Person(startEmail, startPassword);}


    @ParameterizedTest
    @MethodSource ("getIncorrect")
    void testSetIncorrect (String incorrectPass){
        person.setPassword(incorrectPass);
        assertEquals(startPassword, person.getPassword());
    }

    static Stream<String> getIncorrect(){
        return Stream.of(
          "qwerty1@", "wertY1@", "qWerty1#"
        );
    }
//"qwer tY3@$", "qWer#ty3@", "\"qwErty3%"






}