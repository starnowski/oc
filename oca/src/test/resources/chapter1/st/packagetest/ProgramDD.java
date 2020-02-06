
package st.packagetest;

/**
 *
 *	javac ./st/packagetest/ProgramDD.java
 *	java "st.packagetest.ProgramDD"
 *
 */
public class ProgramDD {

	public static void main(String arg[]) {
		ProgramCC programCC = new ProgramCC();
		programCC.packageMethod();
	}
}