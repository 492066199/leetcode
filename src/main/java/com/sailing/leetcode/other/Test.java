package com.sailing.leetcode.other;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * only foir test the code I write
 */
public class Test extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException {
        Test.class.getClassLoader().loadClass("ccc");
    }


}
