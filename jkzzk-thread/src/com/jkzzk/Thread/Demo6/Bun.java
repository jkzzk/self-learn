package com.jkzzk.Thread.Demo6;

import java.util.Objects;

public class Bun {

    private String filling;

    public Bun() {
    }

    public Bun(String filling) {
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bun bun = (Bun) o;
        return Objects.equals(filling, bun.filling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filling);
    }

    @Override
    public String toString() {
        return "Bun{" +
                "filling='" + filling + '\'' +
                '}';
    }
}
