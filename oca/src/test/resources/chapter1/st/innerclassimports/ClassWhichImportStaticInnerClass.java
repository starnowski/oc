package st.innerclassimports;
import st.innerclassimports.subpackage.ClassWithManyInnerClassess.InnerStaticClass;

/**
 * <br/>javac "./st/innerclassimports/ClassWhichImportStaticInnerClass.java" "./st/innerclassimports/subpackage/ClassWithManyInnerClassess.java" 
 * <p/>
 .\st\innerclassimports\ClassWhichImportStaticInnerClass.java:10: error: package ClassWithManyInnerClassess does not exist
        public ClassWithManyInnerClassess.InnerStaticClass obj;
                                         ^
1 error

 */
public class ClassWhichImportStaticInnerClass {

	public ClassWithManyInnerClassess.InnerStaticClass obj;
}