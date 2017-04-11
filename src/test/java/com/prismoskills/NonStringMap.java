package com.prismoskills;

import java.util.Map;

public class NonStringMap {

    private int data;
    private Map<Foo, Bar> map;

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Map<Foo, Bar> getMap() {
        return map;
    }
    public void setMap(Map<Foo, Bar> map) {
        this.map = map;
    }
}
