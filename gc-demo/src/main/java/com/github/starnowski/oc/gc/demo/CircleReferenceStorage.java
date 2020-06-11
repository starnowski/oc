package com.github.starnowski.oc.gc.demo;

public class CircleReferenceStorage {

    public CircleReferenceStorage() {
        SimpleObjectReference ref1 = new SimpleObjectReference();
        SimpleObjectReference ref2 = new SimpleObjectReference();
        ref1.setReference(ref2);
        ref2.setReference(ref1);
    }
}
