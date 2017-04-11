package com.prismoskills;

import java.util.HashMap;

public class ExtendingMap extends HashMap<Integer, Integer> {

    private int data;

    public ExtendingMap() {
        super(5);
        put(100, 100);
        put(200, 200);
        put(300, 300);
        put(400, 400);
        put(500, 500);
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
}
