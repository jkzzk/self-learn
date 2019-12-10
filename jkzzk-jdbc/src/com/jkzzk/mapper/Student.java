package com.jkzzk.mapper;

/**
 *  学生类
 */
public class Student {

    private String id;

    private String studentNum;

    private String studentName;

    private String IDCard;

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return " id：" + this.id + "----" + " 学号：" + this.studentNum + "----" + " 姓名：" + this.studentName;
    }
}