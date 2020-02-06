package st;

public class TypeWithPublicMethodAccess extends TypeWithProtectedMethodAccess {

	public void invokeProtectedMethod() {
		System.out.println("TypeWithPublicMethodAccess#invokeProtectedMethod");
	}
}