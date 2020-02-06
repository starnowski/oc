package st.lambda;

/**
 * javac "./st/lambda/Int1.java" "./st/lambda/SubInt1.java" "./st/lambda/Short1.java" "./st/lambda/Double1.java" "./st/lambda/LambdaImplementationTest.java"
 * java st.lambda.LambdaImplementationTest
 */
public class LambdaImplementationTest implements SubInt1, Short1, Double1 {

	public short convertToShort(int value) { return value > 0 ? Short1.super.convertToShort(value) : SubInt1.super.convertToShort(value);}
	
	public static void main(String[] arg) {
		LambdaImplementationTest test = new LambdaImplementationTest();
		int n = test.convertToShort(1);
		System.out.println("n value : " + n);
		n = test.convertToShort(-1);
		System.out.println("n value : " + n);
	}
}