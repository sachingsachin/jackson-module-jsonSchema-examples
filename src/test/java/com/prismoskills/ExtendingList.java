package com.prismoskills;

import java.util.ArrayList;

public class ExtendingList extends ArrayList<Integer> {

    private int data;

    public ExtendingList() {
        super(5);
        add(100);
        add(200);
        add(300);
        add(400);
        add(500);
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
}
