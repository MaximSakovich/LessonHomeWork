package homeWork35.test;

import homeWork35.persons.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;
    String startEmail = "john@test.com";
    String startPassword = "qwerty1Q!";

    @BeforeEach
    void setUp() {
        person = new Person(startEmail, startPassword);
    }

    @Test
    public void testValidPassword() {
        String validPassword = "ValidPassword@1";
        person.setPassword(validPassword);
        Assertions.assertEquals(validPassword, person.getPassword());
        assertTrue(person.isPasswordValid("ValidPassword@1"));
    }

    @Test
    public void testInvalidLength() {
        String invalidLength = "abc";
        person.setPassword(invalidLength);
        assertFalse(person.isPasswordValid(invalidLength));
    }

    @Test
    public void testMissingUpperCase() {
        String missingUpperCase = "password@1";
        person.setPassword(missingUpperCase);
        assertFalse(person.isPasswordValid(missingUpperCase));
    }

    @Test
    public void testMissingLowerCase() {
        String missingLowerCase = "PASSWORD@1";
        person.setPassword(missingLowerCase);
        assertFalse(person.isPasswordValid(missingLowerCase));
    }

    @Test
    public void testMissingDigit() {
        String missingDigit = "Password@";
        person.setPassword(missingDigit);
        assertFalse(person.isPasswordValid(missingDigit));
    }

    @Test
    public void testMissingSpecialCharacter() {
        String missingSpecialCharacter = "Password1";
        person.isPasswordValid(missingSpecialCharacter);
        assertFalse(person.isPasswordValid(missingSpecialCharacter));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "password@1", "PASSWORD@1", "Password@", "Password1"})
    void testIncorrectPasswordSetParam(String incorrectPassword) {
        System.out.println("Current value for test: " + incorrectPassword);
        person.setPassword(incorrectPassword);
        Assertions.assertEquals(startPassword, person.getPassword());

    }
}