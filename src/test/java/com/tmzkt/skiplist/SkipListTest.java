package com.tmzkt.skiplist;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void itemsAreSorted() {
        SkipList<Integer> list = new SkipList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        List<Integer> orderedList = list.stream().collect(Collectors.toList());
        assertEquals(2, (int) orderedList.get(0));
        assertEquals(3, (int) orderedList.get(1));
        assertEquals(4, (int) orderedList.get(2));
    }

    @Test
    public void contains() {
        SkipList<Integer> list = new SkipList<>();
        list.add(3);
        assertTrue(list.contains(3));
        assertFalse(list.contains(2));
    }

    @Test // TODO make this test pass
    public void remove() {
        SkipList<Integer> list = new SkipList<>();
        list.add(3);
        assertTrue(list.contains(3));
        list.remove(3);
        assertFalse(list.contains(3));
    }
}