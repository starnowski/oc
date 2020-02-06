package st.exame;

/**
 * <br/>javac "./st/exame/Question2Test.java"
 * <br/>java "st.exame.Question2Test"
 */
public class Question2Test {

	public static void main(String []arg) {
		byte x = 5;
		byte y = 10;
		int z = x + y;
		long w = x + y;
		double d = x + y;
		float f = x + y; // OK - float and int requires the same capacity of memory
		// char c = x + y; // incompatible types: possible lossy conversion from int to char
		System.out.println("x:" + x + " y:" + y + " z:" + z + " w:" + w + " d:" + d + " f:" + f);
	}
}