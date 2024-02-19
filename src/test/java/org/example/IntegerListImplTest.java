package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class IntegerListImplTest {

    private IntegerListImpl integerList;

    @Before
    public void setUp() {
        integerList = new IntegerListImpl();
    }

    @Test
    public void testAdd() {
        Integer result = integerList.add(5);
        assertEquals(Integer.valueOf(5), result);
        // Другие тесты для метода add
    }

    @Test
    public void testAddAtIndex() {
        integerList.add(1);
        Integer result = integerList.add(0, 10);
        assertEquals(Integer.valueOf(10), result);
    }

    @Test
    public void testSet() {
        integerList.add(10);
        Integer result = integerList.set(0, 20);
        assertEquals(Integer.valueOf(20), result);
    }

    @Test
    public void testIndexOf() {
        integerList.add(10);
        integerList.add(15);
        integerList.add(20);
        int index = integerList.indexOf(15);
        assertEquals(1, index);
    }

    @Test
    public void testSize() {
        integerList.add(5);
        integerList.add(10);
        assertEquals(2, integerList.size());
    }

    @Test
    public void testClear() {
        integerList.add(5);
        integerList.add(10);
        integerList.clear();
        assertEquals(0, integerList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(integerList.isEmpty());
        integerList.add(5);
        assertFalse(integerList.isEmpty());
    }

    @Test
    public void testSortBubble() {
        int[] arr = {3, 2, 5, 1, 4};
        IntegerListImpl.sortBubble(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSortSelection() {
        int[] arr = {3, 2, 5, 1, 4};
        IntegerListImpl.sortSelection(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSortInsertion() {
        int[] arr = {3, 2, 5, 1, 4};
        IntegerListImpl.sortInsertion(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testGet() {
        integerList.add(5);
        integerList.add(10);
        Integer result = integerList.get(1);
        assertEquals(Integer.valueOf(10), result);
    }

    @Test
    public void testContains() {
        integerList.add(5);
        integerList.add(10);
        assertTrue(integerList.contains(5));
        assertFalse(integerList.contains(15));
    }

    @Test
    public void testLastIndexOf() {
        integerList.add(1);
        integerList.add(2);
        integerList.add(1);

        assertEquals(2, integerList.lastIndexOf(1));
        assertEquals(1, integerList.lastIndexOf(2));
        assertEquals(-1, integerList.lastIndexOf(3));
    }

    @Test
    public void testEquals() {
        integerList.add(1);
        integerList.add(2);
        IntegerList otherList = new IntegerListImpl();
        otherList.add(1);
        otherList.add(2);

        assertTrue(integerList.equals(otherList));

        IntegerList differentList = new IntegerListImpl();
        differentList.add(1);
        differentList.add(3);

        assertFalse(integerList.equals(differentList));
    }

    @Test
    public void testToArray() {
        integerList.add(1);
        integerList.add(2);

        Integer[] expectedArray = {1, 2};
        assertArrayEquals(expectedArray, integerList.toArray());
    }

    @Test
    public void testValidateItem() {
        assertThrows(NullItemException.class, () -> integerList.validateItem(null));
    }

    @Test
    public void testValidateSize() {
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
        assertThrows(StorageIsFullException.class, () -> integerList.add(10));
    }

    @Test
    public void testValidateIndex() {
        integerList.add(1);
        integerList.add(2);
        assertThrows(InvalidInputException.class, () -> integerList.get(2));
    }

    @Test
    public void testSort() {
        Integer[] unsortedArray = {3, 1, 2};
        Integer[] expectedArray = {1, 2, 3};

        IntegerListImpl integerListImpl = new IntegerListImpl();
        integerListImpl.sort(unsortedArray);

        assertArrayEquals(expectedArray, unsortedArray);
    }

    @Test
    public void testBinarySearch() {

        Integer[] sortedArray = {1, 2, 3, 4, 5};

        assertTrue(new IntegerListImpl().binarySearch(sortedArray, 3));
        assertFalse(new IntegerListImpl().binarySearch(sortedArray, 6));
    }

    @Test
    public void testRemoveInvalidIndex() {

        integerList.add(1);

        assertThrows(InvalidInputException.class, () -> integerList.remove(1));
    }

}


