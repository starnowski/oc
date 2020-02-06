
import st.*;

public class PackageDependecieFailedTest {

	private ProgramAA programAA;
	private ProgramBB programBB; // this line should cause compilation error because class ProgramBB exist in package "st.packagetest", not "st".
}