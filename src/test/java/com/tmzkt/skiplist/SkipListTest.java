package com.tmzkt.skiplist;

import org.junit.Test;

import static org.junit.Assert.*;

public class SkipListTest {
    @Test
    public void emptyList() {
        SkipList<Integer> list = new SkipList<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void nonEmptyList() {
        SkipList<Integer> list = new SkipList<>();
        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    public void duplicatesNotAllowed() {
        SkipList<Integer> list = new SkipList<>();

        assertEquals(true, list.add(1));
        assertEquals(1, list.size());

        assertEquals(false, list.add(1));
        assertEquals(1, list.size());
    }
}