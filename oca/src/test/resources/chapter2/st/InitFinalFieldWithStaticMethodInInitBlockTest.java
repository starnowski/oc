package st;


/**
 * <br/>javac "./st/InitFinalFieldWithStaticMethodInInitBlockTest.java"
 */
public class InitFinalFieldWithStaticMethodInInitBlockTest {

	final int var1;
	
	{
		var1 = initStaticInt();
	}

	private static int initStaticInt() {
		return 0;
	}
}
