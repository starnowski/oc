package st.numerictypes;

/**
 * <br/>javac "./st/numerictypes/NumericTypeCastingTest.java"
 */
public class NumericTypeCastingTest{

	
	private void addTwoShortsAndSumToInt() {
		short x = 50, y = 40;
		short sum = x + y; // error: incompatible types: possible lossy conversion from int to short
	}
	
	private void addTwoIntAndSumToLong() {
		int a = 10, b = 20;
		long sum = a + b;
	}
	
	private void addTwoIntAndSumToFloat() {
		int a = 10, b = 40;
		float sum = a + b;
	}

	private void addTwoIntAndSumToDouble() {
		int a = 10, b = 40;
		double sum = a + b;
	}
	
	private void addFloatAndSumToFloat() {
		float a = 200, b = 400;
		float sum = a + b;
	}
	
	private void initFloatWithoutFSymbol() {
		float x = 10.0; // error: incompatible types: possible lossy conversion from double to float
	}
	
	private void addTwoDoubleAndSumToLong() {
		float a = 100.00f, b = 201.00f;
		long sum = a + b; // error: incompatible types: possible lossy conversion from float to long
	}
	
	private void addTwoDoubleAndSumToLong() {
		double a = 100.00, b = 201.00;
		long sum = a + b; // error: incompatible types: possible lossy conversion from double to long
	}
	
	private void initShortVariable() {
		short var = 10000;
		short var1 = 36000000; // error: incompatible types: possible lossy conversion from int to short
	}
	
	private void initByteVariable() {
		byte var = 127;
		byte var1 = 253; // error: incompatible types: possible lossy conversion from int to byte
	}
}