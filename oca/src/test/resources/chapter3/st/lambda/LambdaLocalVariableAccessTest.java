package st.lambda;

/**
 * javac "./st/lambda/LambdaLocalVariableAccessTest.java"
 * java "st.lambda.LambdaLocalVariableAccessTest"
 */
public class LambdaLocalVariableAccessTest {

	public static void main(String[] arg) {
		Runnable r = () -> {
			System.out.println("arg == null :" + (arg == null));
		};
		r.run();
	}

}