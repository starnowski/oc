package st;

/**
 * This test doesn't make sense because there was wrong sentence in book
 * http://stackoverflow.com/questions/29557106/ternary-operator-in-java-only-evaluating-one-expression-since-java-7-was-that
 *
 * Compile with default java
 * <br/><b>javac "./st/TernaryOperatorTest.java"</b>
 * <br/><b>java "st.TernaryOperatorTest"</b>
 * <br/>
 * Compile with 1.6 java
 * <br/><b>javac -target 1.6 -source 1.6 "./st/TernaryOperatorTest.java"</b>
 * <br/><b>java "st.TernaryOperatorTest"</b>
 *
 * <br/><b>javac -target 1.6 -source 1.6 -bootclasspath "C:\Program Files\Java\jdk1.6.0_45\jre\lib\rt.jar" "./st/TernaryOperatorTest.java"</b>
 * <br/><b>"C:\Program Files\Java\jdk1.6.0_45\bin\java" "st.TernaryOperatorTest"</b>
 *
 * <br/><b>"C:\Program Files\Java\jdk1.6.0_45\bin\javac" -target 1.6 -source 1.6 -bootclasspath "C:\Program Files\Java\jdk1.6.0_45\jre\lib\rt.jar" "./st/TernaryOperatorTest.java"</b>
 * <br/><b>"C:\Program Files\Java\jdk1.6.0_45\bin\java" "st.TernaryOperatorTest"</b>
 *
 *
 *
 */
public class TernaryOperatorTest {

	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		int result = y == 2 ? returnZero() : returnOne();
		System.out.println("The result is " + result);
	}
	
	private static int returnZero() {
		System.out.println("Ivoked returnZero");
		return 0;
	}
	
	private static int returnOne() {
		System.out.println("Ivoked returnOne");
		return 1;
	}

}