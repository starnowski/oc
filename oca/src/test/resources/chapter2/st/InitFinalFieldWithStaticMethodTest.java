package st;


/**
 * <br/>javac "./st/InitFinalFieldWithStaticMethodTest.java"
 */
public class InitFinalFieldWithStaticMethodTest {

	final int var1 = initStaticInt();

	private static int initStaticInt() {
		return 0;
	}
}
