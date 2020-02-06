//Comment
package st;

/**
 *
 *	javac ./st/ValidVariableOrderInitializationTest.java
 *  java "st.ValidVariableOrderInitializationTest"
 *
 */

public class ValidVariableOrderInitializationTest {

	String name;

	{
		System.out.println(name); 
	}

	public static void main(String[] arg)
	{
		ValidVariableOrderInitializationTest test = new ValidVariableOrderInitializationTest();
	}
}