package st.anonymus2;

import st.anonymus.*;

/**
  *
  *	javac -cp ".;./st/anonymus" ./st/anonymus2/PublicClassWhichUseNonePublicClassFromOtherPackage.java"
  *
  */
public class PublicClassWhichUseNonePublicClassFromOtherPackage
{
	private OutOfPublicScopePackageClass variable1;
}