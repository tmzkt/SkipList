package com.tmzkt.skiplist;

/******************************************************************************
 * src.AbstractSortedSet                                                           *
 *                                                                             *
 * Extends AbstractSet and implements SortedSet, and contains stub methods     *
 *                                                                             *
 * View README file for information about this project.                        *
 * View LICENSE file for license information.                                  *
 ******************************************************************************/

import java.util.*;

abstract class AbstractSortedSet<E> extends AbstractSet<E> implements SortedSet<E> {
    @Override
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return null;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return null;
    }

    @Override
    public Comparator<? super E> comparator() {
        return null;  // uses natural ordering
    }
}