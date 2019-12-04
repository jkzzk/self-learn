package com.jkzzk.Demo2;

public class GenericDog extends GenericAnimals<String> {

    private Integer legs;

    public GenericDog() {

    }

    public GenericDog(Integer legs,String name) {
        this.legs = legs;
        super.setName(name);
    }

    public Integer getLegs() {
        return legs;
    }

    public void setLegs(Integer legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return super.getName() + "有" + this.legs + "条腿！";
    }
}
