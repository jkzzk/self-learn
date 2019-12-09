package com.jkzzk.annotations.practice;

import java.util.Date;

public class TestMain {

    public static void main(String[] args) throws Exception {
        //从数据库中拿出来赋值
        TestDemo1 testDemo1 = new TestDemo1();
        testDemo1.setBirthday(new Date());

        //解析函数
        MyJackSonAnalysis myJackSonAnalysis =new MyJackSonAnalysis();
        myJackSonAnalysis.analysis(testDemo1);

        System.out.println(testDemo1.toString());
    }

}
