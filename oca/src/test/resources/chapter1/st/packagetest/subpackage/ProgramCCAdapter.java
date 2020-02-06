// Subpackage
package st.packagetest.subpackage;

import st.packagetest.ProgramCC;

/**
 *
 *	javac ./st/packagetest/subpackage/ProgramCCAdapter.java
 *
 */

public class ProgramCCAdapter extends ProgramCC
{
	public static void main(String[] arg)
	{
		ProgramCC programCC = new ProgramCC();
		programCC.packageMethod(); // complication should failed for this line because class "st.packagetest.ProgramCC" is from other package and method "packageMethod" has package scope
	}
}