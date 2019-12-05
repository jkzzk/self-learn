package com.jkzzk.lambda;


import java.util.Arrays;
import java.util.Comparator;

/**
 *  Lambda作为方法的返回值
 */
public class LambdaDemo5 {

    public static Comparator<String> getComparable() {
        return (o1,o2) -> o2.length()-o1.length();
    }

    public static void main(String[] args) {
        String[] arr = {"1","22","333","4444","55555"};

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr,getComparable());

        System.out.println(Arrays.toString(arr));
    }
}
