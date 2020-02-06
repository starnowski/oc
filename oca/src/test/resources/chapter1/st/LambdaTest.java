package st;

/**
 * <br/>Compile with default java (8)
 * <br/>javac ./st/LambdaTest.java
 * <br/>java "st.LambdaTest"
 * 
 * <br/>Run class with java 6 --> TODO
 * <br/><b>"C:\Program Files\Java\jdk1.6.0_45\bin\java" "st.LambdaTest"</b>
 *
 *<br/><b>"C:\Program Files\Java\jdk1.6.0_45\bin\javac" -target 1.6 -source 1.6 -bootclasspath "C:\Program Files\Java\jdk1.6.0_45\jre\lib\rt.jar" ./st/LambdaTest.java</b>
 *<br>The statement aboube is going to failed
 *
 *
 *<br/><b>javac -target 1.6 -source 1.6 -bootclasspath "C:\Program Files\Java\jdk1.6.0_45\jre\lib\rt.jar" ./st/LambdaTest.java</b>
 */
public class LambdaTest {

	public static interface LogProvider {
		String getLog();
	}
	
	public static void main(String[] arg) {
		LambdaTest test = new LambdaTest();
		test.printlnLog(() -> "Lambda without quotes");
		test.printlnLog(() -> {return "Lambda with quotes";});
	}
	
	public void printlnLog(LogProvider provider) {
		if (provider != null) {
			System.out.println(provider.getLog());
		}
	}

}