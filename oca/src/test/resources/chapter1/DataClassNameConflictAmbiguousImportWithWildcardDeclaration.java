
import java.util.*;
import java.sql.*;

//javac DataClassNameConflictAmbiguousImportDeclaration.java
public class DataClassNameConflictAmbiguousImportWithWildcardDeclaration {
	
	private Date date; //This line should generate complication error.
}