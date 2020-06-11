package com.github.starnowski.oc.gc.demo;

public class CircleReferenceStorage {

    private SimpleObjectReference ref1;
    private SimpleObjectReference ref2;

    public CircleReferenceStorage() {
        ref1 = new SimpleObjectReference();
        ref2 = new SimpleObjectReference();
        ref1.setReference(ref2);
        ref2.setReference(ref1);
    }
}
