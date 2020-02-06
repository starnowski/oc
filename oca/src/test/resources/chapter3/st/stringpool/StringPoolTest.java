package st.stringpool;

/**
 * <br/>javac "./st/stringpool/StringPoolTestProperties.java" "./st/stringpool/StringPoolTest.java"
 * <br/>java -ea st.stringpool.StringPoolTest
 */
public class StringPoolTest {

	private static final String STATIC_STRING = "chapter3";

	public static void main(String []arg) {
		boolean assertionAbled = false;
		assert assertionAbled = true;
		if (!assertionAbled) {
			throw new RuntimeException("Assertion is unavailable");
		}
		assert STATIC_STRING == StringPoolTestProperties.STATIC_STRING;
		System.out.println("Yupi, the string pool works's");
	}
}