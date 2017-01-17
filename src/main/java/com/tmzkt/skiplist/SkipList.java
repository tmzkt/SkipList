package com.tmzkt.skiplist;

import java.util.*;
import java.util.stream.Collectors;

public class SkipList<E extends Comparable<E>> extends AbstractSortedSet<E> {
    private static final double PROBABILITY = 0.5;

    private final SkipListNode<E> head;
    private int maxLevel;
    private int size;

    public SkipList() {
        size = 0;
        maxLevel = 0;
        // a src.SkipListNode with value null marks the beginning
        head = new SkipListNode<>(null);
        // null marks the end
        head.nextNodes.add(null);
    }

    public SkipListNode<E> getHead() {
        return head;
    }

    // Adds e to the skiplist.
    // Returns false if already in skiplist, true otherwise.
    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        size++;
        // random number from 0 to maxLevel+1 (inclusive)
        int level = 0;
        while (Math.random() < PROBABILITY) {
            level++;
        }
        while (level > maxLevel) { // should only happen once
            head.nextNodes.add(null);
            maxLevel++;
        }
        SkipListNode<E> newNode = new SkipListNode<>(e);
        SkipListNode<E> current = head;
        do {
            current = findNext(e, current, level);
            newNode.nextNodes.add(0, current.nextNodes.get(level));
            current.nextNodes.set(level, newNode);
        } while (level-- > 0);
        return true;
    }

    // Returns the skiplist node with greatest value <= e
    private SkipListNode find(E e) {
        return find(e, head, maxLevel);
    }

    // Returns the skiplist node with greatest value <= e
    // Starts at node start and level
    private SkipListNode find(E e, SkipListNode current, int level) {
        do {
            current = findNext(e, current, level);
        } while (level-- > 0);
        return current;
    }

    // Returns the node at a given level with highest value less than e
    private SkipListNode findNext(E e, SkipListNode current, int level) {
        SkipListNode next = (SkipListNode) current.nextNodes.get(level);
        while (next != null) {
            E value = (E) next.getValue();
            if (lessThan(e, value)) { // e < value
                break;
            }
            current = next;
            next = (SkipListNode) current.nextNodes.get(level);
        }
        return current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        E e = (E) o;
        SkipListNode node = find(e);
        return node != null &&
                node.getValue() != null &&
                equalTo((E) node.getValue(), e);
    }

    @Override
    public Iterator<E> iterator() {
        return new SkipListIterator<>(this);
    }

    @Override
    public String toString() {
        return "SkipList{" +
                "list=" + this.stream().map(Object::toString).collect(Collectors.joining(", "))
                + '}';
    }

    /******************************************************************************
     * Utility Functions                                                           *
     ******************************************************************************/

    private boolean lessThan(E a, E b) {
        return a.compareTo(b) < 0;
    }

    private boolean equalTo(E a, E b) {
        return a.compareTo(b) == 0;
    }

    private boolean greaterThan(E a, E b) {
        return a.compareTo(b) > 0;
    }
}
