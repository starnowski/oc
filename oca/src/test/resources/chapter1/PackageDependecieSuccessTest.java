
import st.*;
import st.packagetest.*;

public class PackageDependecieSuccessTest {

	private ProgramAA programAA;
	private ProgramBB programBB;
	
	public PackageDependecieSuccessTest() {
		programAA = new ProgramAA();
		programBB = new ProgramBB();
	}
	
	public static void main(String []args) {
		PackageDependecieSuccessTest test = new PackageDependecieSuccessTest();
		System.out.println("programAA:" + test.programAA + " class:" + test.programAA.getClass() + " programBB:" + test.programBB + " class:" + test.programBB.getClass());
	}
}