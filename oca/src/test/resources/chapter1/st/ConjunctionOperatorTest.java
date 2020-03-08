package st;

/**
 *
 * Compile with default java
 * <br/><b>javac "./st/ConuctionOperatorTest.java"</b>
 * <br/><b>java "st.ConuctionOperatorTest"</b>
 */
public class ConjunctionOperatorTest {

	public static void main(String[] args) {
		if (returnFalse() & returnTrue()) {
			System.out.println("Condition is valid");
		} else {
			System.out.println("Condition is invalid");
		}
		System.out.println("The test is over");
	}
	
	private static boolean returnFalse() {
		System.out.println("Ivoked returnFalse");
		return false;
	}
	
	private static boolean returnTrue() {
		System.out.println("Ivoked returnTrue");
		return true;
	}

}