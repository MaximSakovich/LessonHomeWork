package homeWork39.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListBookTest {

    private MyArrayListBook<Integer> myArrayList;

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayListBook<>();
    }

    @Test
    void iterator() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        Iterator<Integer> iterator = myArrayList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void add() {
        myArrayList.add(5);
        assertEquals(1, myArrayList.size());
        assertEquals(5, myArrayList.get(0));
    }

    @Test
    void remove() {
        myArrayList.add(5);
        myArrayList.remove(5);
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    void isEmpty() {
        assertTrue(myArrayList.isEmpty());
        myArrayList.add(10);
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    void get() {
        myArrayList.add(10);
        assertEquals(10, myArrayList.get(0));
    }

    @Test
    void set() {
        myArrayList.add(5);
        myArrayList.set(0, 10);
        assertEquals(10, myArrayList.get(0));
    }

    @Test
    void getArray() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        Object[] array = myArrayList.getArray();
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    void setArray() {
        Object[] newArray = new Object[]{4, 5, 6};
        myArrayList.setArray(newArray);
        assertArrayEquals(newArray, myArrayList.getArray());
    }
    @Test
    void getSize() {
        myArrayList.add(5);
        assertEquals(1, myArrayList.getSize());
    }

    @Test
    void setSize() {
        myArrayList.setSize(5);
        assertEquals(5, myArrayList.getSize());
    }

    @Test
    void size() {
        myArrayList.add(5);
        assertEquals(1, myArrayList.size());
    }
}