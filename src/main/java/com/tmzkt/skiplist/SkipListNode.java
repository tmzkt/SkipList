package com.tmzkt.skiplist;

import java.util.*;

public class SkipListNode<E> {
    private final E value;
    public List<SkipListNode<E>> nextNodes;

    public SkipListNode(E value) {
        this.value = value;
        nextNodes = new ArrayList<>();
    }

    public E getValue() {
        return value;
    }

    public int level() {
        return nextNodes.size() - 1;
    }

    @Override
    public String toString() {
        return "SLN: " + value;
    }
}