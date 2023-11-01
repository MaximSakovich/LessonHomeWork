package homeWork39.service;

import homeWork39.lib.MyArrayListBook;
import homeWork39.lib.MyLinkedListReader;
import homeWork39.model.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReaderServiceTest {
    private ReaderService readerService;

    @BeforeEach
    void setUp() {
        readerService = new ReaderService();
    }

    @Test
    void saveReader() {
        Reader testReader = new Reader("John", "Doe", "john.doe@example.com", "johndoe", "Test@123", new MyArrayListBook<>());
        readerService.saveReader(testReader);
        assertNotNull(readerService.findReaderByUsername("johndoe"));
    }

    @Test
    void findReaderByName() {
        Reader testReader = readerService.findReaderByName("John", "Doe");
        assertNull(testReader);
    }

    @Test
    void registerUser() {
        readerService.registerUser("Jane", "Doe", "jane.doe@example.com", "janedoe", "Test@123");
        assertNotNull(readerService.findReaderByUsername("janedoe"));
    }

    @Test
    void isReaderExistsByEmail() {
        assertFalse(readerService.isReaderExistsByEmail("example@example.com"));
    }

    @Test
    void isEmailValid() {
        assertTrue(readerService.isEmailValid("test@example.com"));
        assertFalse(readerService.isEmailValid("testexample.com"));
    }

    @Test
    void isPasswordValid() {
        assertTrue(readerService.isPasswordValid("Test@123"));
        assertFalse(readerService.isPasswordValid("test123"));
    }

    @Test
    void getAllReaders() {
        assertNotNull(readerService.getAllReaders());
    }

    @Test
    void authenticate() {
        readerService.registerUser("Test", "User", "test.user@example.com", "testuser", "Test@123");
        assertTrue(readerService.authenticate("testuser", "Test@123"));
        assertFalse(readerService.authenticate("testuser", "WrongPassword"));
    }

    @Test
    void displayUserPermissions() {
        readerService.registerUser("Test", "User", "test.user@example.com", "testuser", "Test@123");
        readerService.displayUserPermissions();
    }

    @Test
    void findReaderByUsername() {
        assertNull(readerService.findReaderByUsername("nonexistentuser"));
    }

    @Test
    void findReaderByNonExistentName_ShouldReturnNull() {
        Reader nonExistentReader = readerService.findReaderByName("Non", "Existent");
        assertNull(nonExistentReader);
    }

    @Test
    void isEmailValid_WithInvalidEmail_ShouldReturnFalse() {
        assertFalse(readerService.isEmailValid("invalidEmail"));
    }

    @Test
    void getAllReaders_WithNoReaders_ShouldReturnEmptyList() {
        MyLinkedListReader<Reader> allReaders = readerService.getAllReaders();
        assertEquals(0, allReaders.getSize());
    }
}