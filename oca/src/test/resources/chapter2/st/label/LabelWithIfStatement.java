package st.label;

/**
 * <br/>javac "./st/label/LabelWithIfStatement.java"
 * <br/>java "st.label.LabelWithIfStatement"
 */
public class LabelWithIfStatement {

	public static void main(String[] arg) {
		int x = 0;
		MAIN_IF:
		if (x == 1) {
			System.out.println("Statement is true");
		} else {
			System.out.println("Statement is false");
		}
	}
}