package com.github.starnowski.oc.gc.demo;

public class CircleReferenceManager implements CircleReferenceManagerMBean {

    private CircleReferenceStorage circleReferenceStorage;

    public CircleReferenceManager() {
        circleReferenceStorage = new CircleReferenceStorage();
    }

    public void makeNullReferenceForCircleReferenceStorage() {
        circleReferenceStorage = null;
    }
}
