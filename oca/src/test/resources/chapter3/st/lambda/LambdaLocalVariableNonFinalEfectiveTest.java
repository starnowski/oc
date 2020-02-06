package st.lambda;

/**
 * javac "./st/lambda/LambdaLocalVariableNonFinalEfectiveTest.java"
 */
public class LambdaLocalVariableNonFinalEfectiveTest {

	public static void main(String[] arg) {
		arg = new String[10];
		Runnable r = () -> {
			System.out.println("arg == null :" + (arg == null));
		};
	
	}

}