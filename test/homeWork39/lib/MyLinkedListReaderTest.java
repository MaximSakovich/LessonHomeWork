package homeWork39.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListReaderTest {
    private MyLinkedListReader<Integer> myLinkedListReader;

    @BeforeEach
    void setUp() {
        myLinkedListReader = new MyLinkedListReader<>();
    }

    @Test
    void iterator() {
        MyLinkedListReader<String> myLinkedListReader = new MyLinkedListReader<>();
        myLinkedListReader.add("apple");
        myLinkedListReader.add("banana");
        myLinkedListReader.add("cherry");
        Iterator<String> iterator = myLinkedListReader.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("apple", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("banana", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("cherry", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void add() {
        myLinkedListReader.add(5);
        assertEquals(1, myLinkedListReader.getSize());
        assertEquals(5, myLinkedListReader.getArray()[0]);
    }

    @Test
    void remove() {
        myLinkedListReader.add(5);
        myLinkedListReader.remove(5);
        assertTrue(myLinkedListReader.isEmpty());
    }

    @Test
    void isEmpty() {
        assertTrue(myLinkedListReader.isEmpty());
        myLinkedListReader.add(10);
        assertFalse(myLinkedListReader.isEmpty());
    }

    @Test
    void getArray() {
        myLinkedListReader.add(1);
        myLinkedListReader.add(2);
        myLinkedListReader.add(3);
        Object[] array = myLinkedListReader.getArray();
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    void setArray() {
        Object[] newArray = new Object[]{4, 5, 6};
        myLinkedListReader.setArray(newArray);
        assertArrayEquals(newArray, myLinkedListReader.getArray());
    }

    @Test
    void getSize() {
        myLinkedListReader.add(5);
        assertEquals(1, myLinkedListReader.getSize());
    }

    @Test
    void setSize() {
        myLinkedListReader.setSize(5);
        assertEquals(5, myLinkedListReader.getSize());
    }
}