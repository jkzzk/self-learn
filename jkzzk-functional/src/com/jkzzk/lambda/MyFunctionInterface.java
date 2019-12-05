package com.jkzzk.lambda;

/**
 *  函数式接口在java中是指：有且仅有一个抽象方法的接口,
 *      当然接口中也可以有其他接口
 *
 *      @FunctionalInterface注解
 *          作用：检测接口，是否是一个函数式接口
 *              是：编译成功
 *              否：编译失败
 */
@FunctionalInterface
public interface MyFunctionInterface {

    public abstract void mehtod();

//    public abstract void mehtod2();

}
