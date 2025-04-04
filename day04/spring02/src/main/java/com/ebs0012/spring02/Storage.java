package com.ebs0012.spring02;

public class Storage<P> {
    private P item;

    public P getItem() {
        return item;
    }

    public void setItem(P item) {
        this.item = item;
    }
}
