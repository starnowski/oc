package st.anonymus;

/**
 *
 *  "./st/anonymus/clearAndCompile.bat"
 *	javac ./st/anonymus/PublicClass.java
 *
 */
public class PublicClass
{
	static class InnerPackageStaticClass 
	{
	
	}
	
	private static class InnerPrivateStaticClass 
	{
	
	}
	
	protected static class InnerProtectedStaticClass 
	{
	
	}
	
	public static class InnerPublicStaticClass 
	{
	
	}
	
	class InnerPackageClass
	{
		
	}
	
	private class InnerPrivateClass
	{
		
	}
	
	protected class InnerProtectedClass
	{
		
	}
	
	public class InnerPublicClass
	{
		
	}
	
	
}

class OutOfPublicScopePackageClass
{
	
}


//error: modifier protected not allowed here
protected class OutOfPublicScopeProtectedClass
{
	
}



//error: modifier private not allowed here
private class OutOfPublicScopePrivateClass
{
	
}

