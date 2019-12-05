package com.jkzzk.lambda;

@FunctionalInterface
public interface Logger {

    // 返回日志拼接的字符串
    public abstract String logger();

}
