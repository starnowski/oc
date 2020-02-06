package st.operator;

/**
 *<br/>javac "./st/operator/StringOperatorComputation.java"
 *<br/>java -ea "st.operator.StringOperatorComputation"
 */
public class StringOperatorComputation {

	public static void main(String[] arg) {
		boolean assertEnabled = false;
		assert assertEnabled = true;
		if (!assertEnabled) {
			throw new RuntimeException("Asserts must be enabled!!!");
		}
		String result = 1 + 2 + " is result";
		String expected = "3 is result";
		assert expected.equals(result);
		System.out.println(result);
	}

}