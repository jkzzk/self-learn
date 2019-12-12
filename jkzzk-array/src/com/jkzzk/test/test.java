package com.jkzzk.test;

import com.jkzzk.array.SparseArray;
import com.jkzzk.array.SparseArrayException;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *  测试类
 */
public class test {

    @Test
    public void getSparseArray() {

        SparseArray sparseArray = new SparseArray();

        int[][] arrs = new int[10][10];

        for (int[] arr : arrs) {
            Arrays.fill(arr,1);
        }

        arrs[2][6] = 2;
        arrs[3][1] = 5;
        arrs[5][7] = 6;
        arrs[8][0] = 8;
        arrs[4][6] = 0;

        sparseArray.toSparseArray(arrs,1);

        System.out.println("原始数组！");
        printArray(arrs);
        System.out.println("稀疏数组！");
        sparseArray.printSparse();
        System.out.println("恢复原始数组！");
        try {
            printArray(sparseArray.toOriginalArrs());
        } catch (SparseArrayException e) {
            e.printStackTrace();
        }

    }

    private static void printArray(int [][] arrs) {
        Stream.of(arrs).forEach(arr -> {
            for (int ele : arr) {
                System.out.print(ele + "\t");
            }
            System.out.println();
        });
    }

}
