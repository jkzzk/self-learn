package com.jkzzk.annotations.practice;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJackSonAnalysis {

    public void analysis(TestDemo1 testMain) throws Exception {
        Class<TestDemo1> testDemo1Class = TestDemo1.class;
        Class<MyJackSon> myJackSonClass = MyJackSon.class;

        Field birthday = testDemo1Class.getDeclaredField("birthday");
        MyJackSon annotation = birthday.getAnnotation(myJackSonClass);

        String pattern = annotation.pattern();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        birthday.setAccessible(true);
        Date birthdayDate = (Date) birthday.get(testMain);
        System.out.println(birthdayDate);

        Field birthdayString = testDemo1Class.getDeclaredField("birthdayString");
        birthdayString.setAccessible(true);
        birthdayString.set(testMain,simpleDateFormat.format(birthdayDate));
    }

}
