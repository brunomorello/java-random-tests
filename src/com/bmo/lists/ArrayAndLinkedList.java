package com.bmo.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayAndLinkedList {
    public static void main(String[] args) {

        final int size = 10000000;
        List<String> stringArrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            stringArrayList.add("A");
        }

        long startTime = System.currentTimeMillis();
        stringArrayList.forEach(s -> s.toString());
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Time to iterate ArrayList fixed size  %d ms", (endTime - startTime)));

        //==========================================
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            stringList.add("B");
        }

        startTime = System.currentTimeMillis();
        stringList.forEach(s -> s.toString());
        endTime = System.currentTimeMillis();
        System.out.println(String.format("Time to iterate non fixed size ArrayList  %d ms", (endTime - startTime)));

        //==========================================
        List<String> strLinkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            strLinkedList.add("C");
        }

        startTime = System.currentTimeMillis();
        strLinkedList.forEach(s -> s.toString());
        endTime = System.currentTimeMillis();
        System.out.println(String.format("Time to iterate LinkedList using for each %d ms", (endTime - startTime)));

        //==========================================
        List<String> strLinkedList2 = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            strLinkedList2.add("C");
        }

        startTime = System.currentTimeMillis();
        Iterator<String> iterator = strLinkedList2.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println(String.format("Time to iterate LinkedList using iterate %d ms", (endTime - startTime)));
    }
}
