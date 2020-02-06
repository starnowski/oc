package st.exame;

/**
 * <br/>javac "./st/exame/Question10Test.java"
 * <br/>java "st.exame.Question10Test"
 */
public class Question10Test {

	public static void main(String []arg) {
		byte a = 40, b = 50;
		byte sum = (byte) a + b; // incompatible types: possible lossy conversion from int to byte
		System.out.println("sum:" + sum);
	}
}