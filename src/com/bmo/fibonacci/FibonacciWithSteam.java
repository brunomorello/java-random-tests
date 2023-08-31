package com.bmo.fibonacci;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciWithSteam {
    public static void main(String[] args) {
        String result = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(7)
                .map(t -> t[0])
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(result);
    }
}
