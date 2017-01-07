package com.tmzkt;

import com.tmzkt.skiplist.SkipList;

public class Main {
    public static void main(String[] args) {
        SkipList<Integer> testList = new SkipList<>();
        System.out.println(testList);
        testList.add(4);
        System.out.println(testList);
        testList.add(1);
        System.out.println(testList);
        testList.add(2);
        System.out.println(testList);

        SkipList<String> testList2 = new SkipList<>();
        System.out.println(testList2);
        testList2.add("hello");
        System.out.println(testList2);
        testList2.add("beautiful");
        System.out.println(testList2);
        testList2.add("world");
        System.out.println(testList2);
    }
}
