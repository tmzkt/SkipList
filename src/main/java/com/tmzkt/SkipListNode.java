package com.tmzkt;

/******************************************************************************
 * src.SkipListNode                                                                *
 *                                                                             *
 * View README file for information about this project.                        *
 * View LICENSE file for license information.                                  *
 ******************************************************************************/

import java.util.*;

public class SkipListNode<E> {
    private E value;
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

    public String toString() {
        return "SLN: " + value;
    }
}