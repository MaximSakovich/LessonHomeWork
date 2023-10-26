package homeWork36.Task3;

import homeWork36.Task2.MyComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyComparatorTest {

    @BeforeEach
    void setUp() {
    }

    private MyComparator comparator = new MyComparator();

    @Test
    public void testCompare() {
        assertEquals(-1, comparator.compare(2, 3));
        assertEquals(1, comparator.compare(3, 2));
        assertEquals(0, comparator.compare(2, 2));
        assertEquals(-1, comparator.compare(4, 6));
        assertEquals(1, comparator.compare(7, 9));
        assertEquals(0, comparator.compare(5, 5));
        assertEquals(-1, comparator.compare(2, 7));
        assertEquals(1, comparator.compare(9, 4));
    }
}