package com.johnny.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static void main(String[] args) {

        Set<Integer> aa = new HashSet<>();
        aa.add(11);
        Integer[] bb = aa.toArray(new Integer[]{});
        System.out.println("aa");

    }

}
