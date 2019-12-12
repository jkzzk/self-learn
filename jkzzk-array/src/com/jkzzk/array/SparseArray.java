package com.jkzzk.array;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *  稀疏数组
 *      应用场景：
 *          当一个数组中大部分的值为同一值时，可以用稀疏数组来保存改数据
 *      存储方式：
 *          1.记录数组一共几行几列，有多少个不同的值
 *          2.把具有不同值的元素的行列和值记录在一个小规模的数组中，从而缩小程序的规模
 *      二维数组转稀疏数组的思路：
 *          1.遍历原始二维数组，得到有效数据的个数 sum
 *          2.根据sum可以创建稀疏数组的sparseArray int[sum+1][3]
 *          3.将二维数组的有效数据存入到稀疏数组中
 *      稀疏数组转原始二维数组的思路：
 *          1.读取稀疏数组的第一行，创建原始数组
 *          2.遍历稀疏数组的其他数据，将其赋值给原始数组的相应位置
 */
public class SparseArray implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 稀疏数组
     */
    private int[][] sparseArray = null;

    /**
     * 有效个数
     */
    private int valid = 0;

    /**
     * 稀疏数组当前指针位置
     */
    private int currentCount = 1;


    /**
     * 原始二维数组
     */
    private int[][] originalArrs = null;

    /**
     * 二位数组的无效值
     */
    private int invalid = 0;


    /**
     * 无参数构造
     */
    public SparseArray() {
        this.sparseArray = null;
        this.valid = 0;
        this.currentCount = 1;
        this.originalArrs = null;
        this.invalid = 0;
    }

    /**
     * 二维数组和无效值构造
     * @param originalArrs
     * @param invalid
     */
    public SparseArray(int[][] originalArrs, int invalid) {
        this.toSparseArray(originalArrs,invalid);
    }

    /**
     * 二维数组构造
     * @param originalArrs
     */
    public SparseArray(int[][] originalArrs) {
        this.toSparseArray(originalArrs);
    }

    /**
     * 二维数组转换为稀疏数组，默认无效值为0
     * @param arrs
     * @return
     *      转换正常，返回true <br>
     *      二维数组为空，返回false <br>
     *      有效数据个数为0，返回false <br>
     */
    public boolean toSparseArray(int[][] arrs) {
        return toSparseArray(arrs,0);
    }

    /**
     * 二维数组转换为稀疏数组
     * @param arrs 二维数组
     * @param invalid 无效值
     * @return
     *      转换正常，返回true <br>
     *      二维数组为空，返回false <br>
     */
    public boolean toSparseArray(int[][] arrs,int invalid) {

        //arrs是否为空
        if(isArraysInvalid(arrs)) {
            return false;
        }

        this.originalArrs = new int[arrs.length][arrs[0].length];
        System.arraycopy(arrs,0,this.originalArrs,0,arrs.length);
        this.invalid = invalid;

        //判断有效个数，如果是0返回false
        this.statisticalValid(arrs);

        //创建一个稀疏数组
        this.sparseArray = new int[this.valid + 1][3];

        //存入二维数组的基本信息
        this.sparseArray[0][0] = arrs.length;
        this.sparseArray[0][1] = arrs[0].length;
        this.sparseArray[0][2] = this.valid;

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                if(arrs[i][j] != invalid) {
                    this.sparseArray[this.currentCount][0] = i;
                    this.sparseArray[this.currentCount][1] = j;
                    this.sparseArray[this.currentCount][2] = arrs[i][j];
                    this.currentCount++;
                }
            }
        }

        return true;
    }

    /**
     * 稀疏数组转变为二维数组
     * @return
     *      二维数组
     * @throws SparseArrayException
     */
    public int[][] toOriginalArrs() throws SparseArrayException {

        if(isArraysInvalid(this.sparseArray)) {
            throw new SparseArrayException("No SparseArray!");
        }

        int[][] arrays = new int[this.sparseArray[0][0]][this.sparseArray[0][1]];

        Stream.of(arrays).forEach(arr -> {
            Arrays.fill(arr,1);
        });

        for (int i = 1; i < this.sparseArray.length; i++) {
            arrays[this.sparseArray[i][0]][this.sparseArray[i][1]] = this.sparseArray[i][2];
        }

        return arrays;
    }

    /**
     * 检测传入二维数组是否为空
     * @param arrs 二维数组
     * @return
     *      为空，返回true <br>
     *      不为空，返回false <br>
     */
    public boolean isArraysInvalid(int[][] arrs) {
        if(arrs == null) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 统计有效个数
     * @param arrs 传入数组
     * @return
     *      有效数据个数为0，则返回false
     *      有效数据个数不为0，则放回true
     */
    private void statisticalValid(int[][] arrs) {
        Stream.of(arrs).forEach(arr -> {
            for (int ele : arr) {
                if(ele != this.invalid) {
                    this.valid++;
                }
            }
        });
    }

    /**
     * 释放稀疏数组当前指针
     * @param value
     */
    private void clearCurrentCount(int value) {
        this.currentCount = value;
    }

    /**
     * @param arrs 二维数组
     * @return
     *      检测参数二维数组是否适合转变为稀疏数组
     */
    public boolean checkArrays(int[][] arrs) {

        if(this.isArraysInvalid(arrs)) {
            return false;
        }

        double rows = arrs.length;
        double clos = arrs[0].length;
        double maxValid = Math.floor(rows * clos/3) - 1;

        return this.valid < maxValid;
    }


    /**
     * 获取稀疏数组
     * @return
     *      返回稀疏数组
     */
    public int[][] getSparseArray() {
        return sparseArray;
    }



    /**
     * 获取有效值个数
     * @return
     *      返回有效值个数
     */
    public int getValid() {
        return valid;
    }

    /**
     * 获取原始数组
     * @return
     *      返回无效数据值
     */
    public int[][] getOriginalArrs() {
        int[][] arrays = new int[this.sparseArray[0][1]][this.sparseArray[0][2]];
        System.arraycopy(originalArrs,0,arrays,0,originalArrs.length);
        return arrays;
    }

    /**
     * 获取无效数据值
     * @return
     *      返回无效数据值
     */
    public int getInvalid() {
        return invalid;
    }

    public void printSparse() {
        Stream.of(this.sparseArray).forEach(arr -> {
            for (int ele : arr) {
                System.out.print(ele + "\t");
            }
            System.out.println();
        });
    }
}
