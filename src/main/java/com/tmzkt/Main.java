package com.tmzkt;

import com.tmzkt.skiplist.SkipList;

public class Main {
    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();
        skipList.add(4);
        skipList.add(1);
        skipList.add(6);

        for (int i : skipList) {
            System.out.println(i);
        }
    }
}
