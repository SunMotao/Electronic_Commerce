package com.iotek.entity;

/**
 * Created by xiaohuang on 2018/1/16.
 */
public enum Color {
    RED("red",255,0,0) ,BLUE("blue",0,0,255),GREEN("green",0,255,0);

    private  String name;
    private  int  a;
    private  int  b;
    private  int  c;

    Color(String name, int a, int b, int c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
