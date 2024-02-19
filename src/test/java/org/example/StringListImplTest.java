package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringListImplTest {

    @Test
    public void testAdd() {
        StringListImpl list = new StringListImpl();
        assertEquals("item1", list.add("item1"));
    }

    @Test
    public void testAddAtIndex() {
        StringListImpl list = new StringListImpl();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        assertEquals("item4", list.add(1, "item4"));
    }

    @Test
    public void testSet() {
        StringListImpl list = new StringListImpl();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        assertEquals("newItem", list.set(1, "newItem"));
    }


    @Test
    public void testRemoveByItem() {
        StringListImpl list = new StringListImpl();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        assertEquals("item2", list.remove("item2"));
    }

    @Test
    public void testRemoveByIndex() {
        StringListImpl list = new StringListImpl();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        assertEquals("item2", list.remove(1));
    }

    @Test
    public void testLastIndexOf() {
        StringListImpl list = new StringListImpl();
        list.add("item1");
        list.add("item2");
        list.add("item1");
        assertEquals(2, list.lastIndexOf("item1"));
    }

    @Test
    public void testGet() {
        StringListImpl list = new StringListImpl();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        assertEquals("item2", list.get(1));
    }

    @Test
    public void testEquals() {
        StringListImpl list1 = new StringListImpl();
        list1.add("item1");
        list1.add("item2");

        StringListImpl list2 = new StringListImpl();
        list2.add("item1");
        list2.add("item2");

        assertTrue(list1.equals(list2));
    }

    @Test
    public void testSize() {
        StringListImpl list = new StringListImpl();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        assertEquals(3, list.size());
    }

    @Test
    public void testIsEmpty() {
        StringListImpl list = new StringListImpl();
        assertTrue(list.isEmpty());

        list.add("item1");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testClear() {
        StringListImpl list = new StringListImpl();
        list.add("item1");
        list.add("item2");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testToArray() {
        StringListImpl list = new StringListImpl();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        assertArrayEquals(new String[]{"item1", "item2", "item3"}, list.toArray());
    }

    @Test(expected = NullItemException.class)
    public void testValidateItemWithNull() {
        StringListImpl list = new StringListImpl();
        list.validateItem(null);
    }

    @Test(expected = StorageIsFullException.class)
    public void testValidateSizeWhenFull() {
        StringListImpl list = new StringListImpl(2);
        list.add("item1");
        list.add("item2");
        list.validateSize();
    }

    @Test
    public void testValidateIndex() {
        StringListImpl list = new StringListImpl();
        list.add("item1");
        list.add("item2");

        try {
            list.validateIndex(2);
            fail("Expected InvalidInputException to be thrown");
        } catch (InvalidInputException e) {
        }
    }
}
