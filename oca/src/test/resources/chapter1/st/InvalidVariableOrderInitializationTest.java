//Comment
package st;

/**
 *
 *	javac ./st/InvalidVariableOrderInitializationTest.java
 *
 */
public class InvalidVariableOrderInitializationTest {

	{
		System.out.println(name); // This line should generate compilcation error because "name" variable was not initialized yet. 
	}
	
	String name;

}

