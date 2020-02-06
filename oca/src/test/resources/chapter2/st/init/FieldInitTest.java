package st.init;

/**
 * <br/>javac "./st/init/FieldInitTest.java" "./st/init/FieldInitTestUtils.java"
 * <br/>java "st.init.FieldInitTest"
 */
public class FieldInitTest {

	private int val1 = FieldInitTestUtils.initValue(1, "definition");
	
	private static final int staticVal = FieldInitTestUtils.initValue(2, "definition");

	{
		val1 = FieldInitTestUtils.initValue(11, "init block");
	}
	
	public FieldInitTest() {
		val1 = FieldInitTestUtils.initValue(112, "non argument constructor");
	}
	
	public FieldInitTest(int val) {
		val1 = FieldInitTestUtils.initValue(val, "one argument constructor");
	}
	
	public static void main(String []arg) {
		FieldInitTest f1 = new FieldInitTest();
		FieldInitTest f2 = new FieldInitTest(113);
	}
	
}

