package st.lambda;


/// https://www.intertech.com/Blog/whats-package-info-java-for/

/**
 * javac "./st/lambda/Int1.java"
 */
public interface Int1 {
	
	default int returnInt() { return 1;}
	
	default short convertToShort(int value) { return (short)value;}
}