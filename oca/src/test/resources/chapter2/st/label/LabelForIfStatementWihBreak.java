package st.label;

/**
 * <br/>javac "./st/label/LabelForIfStatementWihBreak.java"
 * <br/>java "st.label.LabelForIfStatementWihBreak"
 */
public class LabelForIfStatementWihBreak {

	public static void main(String[] arg) {
		int x = getIntArgument(arg, 0, 0);
		int y = getIntArgument(arg, 1, 0);
		MAIN_IF:
		if (x == 1) {
			System.out.println("Statement is true");
			if (y == 1) {
				break MAIN_IF;
			}
			System.out.println("y: " + y);
		} else {
			System.out.println("Statement is false");
			if (y == 1) {
				break MAIN_IF;
			}
			System.out.println("y: " + y);
		}
	}
	
	private static int getIntArgument(String[] arg, int index, int defValue) {
		if (arg != null && arg.length >= (index + 1)) {
			return Integer.valueOf(arg[index]);
		}
		return defValue;
	}
}