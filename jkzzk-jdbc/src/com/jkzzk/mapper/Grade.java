package com.jkzzk.mapper;

public class Grade {

    private String id;

    private String gradeName;

    private int deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }


    @Override
    public String toString() {
        return " id：" + this.id + "----" + " 年级名称：" + gradeName;
    }
}
