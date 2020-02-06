package st.innerclassimports;
import st.innerclassimports.subpackage.ClassWithManyInnerClassess.InnerClass;

/**
 * <br/>javac "./st/innerclassimports/ClassWithImportInnerClass.java" "./st/innerclassimports/subpackage/ClassWithManyInnerClassess.java" 
 * <p/>
 .\st\innerclassimports\ClassWithImportInnerClass.java:9: error: package ClassWithManyInnerClassess does not exist
        public ClassWithManyInnerClassess.InnerClass obj;
                                         ^
1 error
 */
public class ClassWithImportInnerClass {

	public ClassWithManyInnerClassess.InnerClass obj;
}