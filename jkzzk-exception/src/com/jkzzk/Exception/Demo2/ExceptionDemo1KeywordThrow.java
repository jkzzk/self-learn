package com.jkzzk.Exception.Demo2;

/**
 * 异常的关键字
 *      throw关键字
 *          1.作用
 *              可以使用throw关键字在指定的方法中抛出指定的异常
 *          2.格式
 *              throw new xxxException("发生异常的原因");
 *          3.注意
 *              1.throw关键字必须写在方法的内部
 *              2.throw后面的对象必须是Exception类或者Exception的子类
 *              3.throw抛出异常对象
 *                  throw抛出运行时异常时，无序写代码处理，JVM也会进行处理
 *                  throw抛出编译时异常时，必须手动处理(try--catch)或者throws给调用者
 * @author Jkzzk
 */
public class ExceptionDemo1KeywordThrow {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        getElement(arr,0);

        //java.lang.NullPointerException: 数组为空！
//        getElement(null,0);

        //java.lang.ArrayIndexOutOfBoundsException: 索引不合法！
//        getElemdent(arr,7);
    }

    public static int getElement(int[] arr, int index) {

        if(arr == null) {
            throw new NullPointerException("数组为空！");
        }

        if(index < 0 || index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("索引不合法！");
        }

        return arr[index];
    }
}
