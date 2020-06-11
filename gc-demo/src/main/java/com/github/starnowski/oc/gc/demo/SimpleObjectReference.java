package com.github.starnowski.oc.gc.demo;

public final class SimpleObjectReference<R> {

    private R reference;

    public void setReference(R reference) {
        this.reference = reference;
    }

    public R getReference() {
        return reference;
    }
}
