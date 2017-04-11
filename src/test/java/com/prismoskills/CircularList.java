package com.prismoskills;

public class CircularList {

    private int data;
    private CircularList prev;
    private CircularList next;

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public CircularList getPrev() {
        return prev;
    }
    public void setPrev(CircularList prev) {
        this.prev = prev;
    }
    public CircularList getNext() {
        return next;
    }
    public void setNext(CircularList next) {
        this.next = next;
    }
}
