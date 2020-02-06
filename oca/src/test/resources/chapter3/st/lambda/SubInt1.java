package st.lambda;

/**
 * javac "./st/lambda/Int1.java" "./st/lambda/SubInt1.java"
 */
public interface SubInt1 extends Int1 {

default int returnInt() { return 2;}

}