package com.jkzzk.Thread.Demo7;

/**
 * 包子类
 * @author JKzzk
 */
public class Bun {

    private String bunSkin;

    private String bunFilling;

    private boolean flag = false;

    public Bun() {
    }

    public Bun(String bunSkin, String bunFilling, boolean flag) {
        this.bunSkin = bunSkin;
        this.bunFilling = bunFilling;
        this.flag = flag;
    }

    public String getBunSkin() {
        return bunSkin;
    }

    public void setBunSkin(String bunSkin) {
        this.bunSkin = bunSkin;
    }

    public String getBunFilling() {
        return bunFilling;
    }

    public void setBunFilling(String bunFilling) {
        this.bunFilling = bunFilling;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return this.bunSkin + this.bunFilling + "包子";
    }
}
