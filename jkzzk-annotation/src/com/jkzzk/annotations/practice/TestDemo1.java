package com.jkzzk.annotations.practice;

import java.util.Date;

/**
 *  测试pojo类
 */
public class TestDemo1 {

    @MyJackSon(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String birthdayString;

    public String getBirthdayString() {
        return birthdayString;
    }

    public void setBirthdayString(String birthdayString) {
        this.birthdayString = birthdayString;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return this.birthday.getTime() + "++++" + birthdayString;
    }
}
