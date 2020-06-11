package com.github.starnowski.oc.gc.demo;

public class CircleReferenceManager {

    private CircleReferenceStorage circleReferenceStorage;

    public CircleReferenceManager() {
        circleReferenceStorage = new CircleReferenceStorage();
    }

    public void setReferenceForCircleReferenceStorageAsNull() {
        circleReferenceStorage = null;
    }
}
