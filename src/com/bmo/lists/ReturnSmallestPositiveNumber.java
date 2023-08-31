package com.bmo.lists;

import java.util.HashSet;
import java.util.Set;

public class ReturnSmallestPositiveNumber {
    public static void main(String[] args) {
        int[] vals = {1, 3, 6, 4, 1, 2};
        int smallestInt = smallestInt(vals);
        System.out.println(smallestInt);
    }

    private static int smallestInt(int[] vals) {
        final int arrSize = vals.length;
        Set<Integer> valsAux = new HashSet<>();
        for (int x : vals) {
            if (x > 0) {
                valsAux.add(x);
            }
        }

        for (int i = 1; i < arrSize; i++) {
            if (!valsAux.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
