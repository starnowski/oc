package st.multiclasses;

/**
 * <br/><b>MultiClassFileTest.java</b>
 * <br/>javac ./st/multiclasses/MultiClassFileTest.java
 * <br/>dir "./st/multiclasses"
 * <br/>java st.multiclasses.MultiClassFileTest
 */
public class MultiClassFileTest {
	
	public static void main(String []arg){
		System.out.println("st.multiclasses.MultiClassFileTest#main(String[])");
	}
	
	/**
	 * <br/>java st.multiclasses.MultiClassFileTest$NestedStaticClass
	 */
	public static class NestedStaticClass{
		
		public static void main(String []arg){
			System.out.println("st.multiclasses.MultiClassFileTest$NestedStaticClass#main(String[])");
		}
	}
}

/**
 * <br/>java st.multiclasses.NonePublicClass1
 */
class NonePublicClass1 {
	
	public static void main(String []arg){
		System.out.println("st.multiclasses.NonePublicClass1#main(String[])");
	}
}

/**
 * <br/>java st.multiclasses.NonePublicClass2
 */
class NonePublicClass2 {
	
	public static void main(String []arg){
		System.out.println("st.multiclasses.NonePublicClass2#main(String[])");
	}
}