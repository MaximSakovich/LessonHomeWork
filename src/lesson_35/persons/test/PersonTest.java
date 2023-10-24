package lesson_35.persons.test;

import lesson_35.persons.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

class PersonTest {
    Person person;
    String startEmail = "john@test.com";
    String startPassword = "qwerty1Q!";
    @BeforeEach
    void setUp() {
        person = new Person(startEmail, startPassword);
    }

    @Test
    void  testSetValidEmail(){
        String validEmail = "valid@test.de";
        person.setEmail(validEmail);
        Assertions.assertEquals(validEmail, person.getEmail());

    }
//@Disabled
@Test
    void testInvalidEmail(){
        String incorrectEmail = "invalid.test.de";
        person.setEmail(incorrectEmail);
        Assertions.assertEquals(startEmail, person.getEmail());
}

@Test
    void testInvalidHundEmail(){
    String incorrectEmail = "inva@lid@test.de";
    person.setEmail(incorrectEmail);
    Assertions.assertEquals(startEmail, person.getEmail());
}

@ParameterizedTest
@ValueSource(strings = {"invalid@test.e", "invalid@test.de.", "invalid@testde"})
    void testIncorrectEmailSetParam(String incorrectEmail) {
    System.out.println("Current value for test: " + incorrectEmail);
       person.setEmail(incorrectEmail);
       Assertions.assertEquals(startEmail, person.getEmail());
}
@Disabled
@ParameterizedTest
@ValueSource (ints = {1, 2, 3})
void testIntsParam(int value) {
        Assertions.assertTrue(value <= 4);
        Assertions.assertFalse(value < 2);
}

@ParameterizedTest
//@EnumSource()
@MethodSource("generateDataForEmailTest")
void testIncorrectEmailSetParamMethodSource(String incorrectEmail){
    person.setEmail(incorrectEmail);
    Assertions.assertEquals(startEmail, person.getEmail());
}

static Stream<String> generateDataForEmailTest() {
     return Stream.of("inva@lid@test.de", "inva!lid@test.de","inva@lid@test.de","invalid@te!st.de");
}
@Disabled
@ParameterizedTest
@CsvSource({"apple, 1, true", "banana, 4, false", "cherry, 5, false"})
    void testCSVsource(String fruit, int count, boolean flag){
 Assertions.assertNotNull(fruit);
 Assertions.assertTrue(count>0);
 Assertions.assertFalse(flag);
}
@Disabled
@ParameterizedTest
@CsvFileSource(resources = "/data.csv")
void testDataFromFile(String fruit, int count, boolean flag) {
    Assertions.assertNotNull(fruit);
    Assertions.assertTrue(count > 0);
    Assertions.assertFalse(flag);
}



}