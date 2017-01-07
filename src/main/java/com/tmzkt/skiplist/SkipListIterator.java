package com.tmzkt.skiplist;

/******************************************************************************
 * src.SkipListIterator                                                            *
 *                                                                             *
 * View README file for information about this project.                        *
 * View LICENSE file for license information.                                  *
 ******************************************************************************/

import java.util.*;

public class SkipListIterator<E extends Comparable<E>> implements Iterator<E> {
    SkipList<E> list;
    SkipListNode<E> current;

    public SkipListIterator(SkipList<E> list) {
        this.list = list;
        this.current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current.nextNodes.get(0) != null;
    }

    @Override
    public E next() {
        current = current.nextNodes.get(0);
        return current.getValue();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}