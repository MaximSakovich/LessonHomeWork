package homeWork39.repository;

import homeWork39.lib.MyArrayListBook;
import homeWork39.model.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReaderRepositoryTest {

    private ReaderRepository readerRepository;

    @BeforeEach
    void setUp() {
        readerRepository = new ReaderRepository();
    }

    @Test
    void addReader() {
        Reader reader = new Reader("John", "Doe", "johndoe@example.com", "johndoe", "password", new MyArrayListBook<>());
        readerRepository.addReader(reader);
        assertEquals(1, readerRepository.getAllReaders().getSize());
    }


    @Test
    void removeReader() {
        Reader reader = new Reader("Jane", "Doe", "janedoe@example.com", "janedoe", "password", new MyArrayListBook<>());
        readerRepository.addReader(reader);
        readerRepository.removeReader(reader);
        assertEquals(0, readerRepository.getAllReaders().getSize());
    }

    @Test
    void getAllReaders() {
        assertEquals(0, readerRepository.getAllReaders().getSize());
        Reader reader1 = new Reader("John", "Doe", "johndoe@example.com", "johndoe", "password", new MyArrayListBook<>());
        Reader reader2 = new Reader("Jane", "Doe", "janedoe@example.com", "janedoe", "password", new MyArrayListBook<>());
        readerRepository.addReader(reader1);
        readerRepository.addReader(reader2);
        assertEquals(2, readerRepository.getAllReaders().getSize());
    }

    @Test
    void getReaderByName() {
        Reader reader1 = new Reader("John", "Doe", "johndoe@example.com", "johndoe", "password", new MyArrayListBook<>());
        readerRepository.addReader(reader1);
        Reader foundReader = readerRepository.getReaderByName("John", "Doe");
        assertNotNull(foundReader);
        assertEquals("John", foundReader.getFirstName());
        assertEquals("Doe", foundReader.getLastName());
    }

    @Test
    void getReaderByName_NonExistentReader_ShouldReturnNull() {
        Reader nonExistentReader = readerRepository.getReaderByName("Non", "Existent");
        assertNull(nonExistentReader);
    }

    @Test
    void getReaderByName_ExistingReader_ShouldReturnReader() {
        Reader testReader = new Reader("Jane", "Smith", "janesmith@example.com", "janesmith", "password", new MyArrayListBook<>());
        readerRepository.addReader(testReader);
        Reader foundReader = readerRepository.getReaderByName("Jane", "Smith");
        assertNotNull(foundReader);
        assertEquals("Jane", foundReader.getFirstName());
        assertEquals("Smith", foundReader.getLastName());
    }
}
