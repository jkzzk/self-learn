package com.jkzzk.Exception.Demo4;

/**
 * 自定义异常类
 *      1.一般以Exception结尾，表示其实异常
 *      2.格式
 *          public class xxxException extends Exception {
 *              空参数构造方法() {super();}
 *
 *              构造方法(String message 异常信息) { super(message); }
 *          }
 * @author Jkzzk
 */
public class CustomException extends Exception {

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
