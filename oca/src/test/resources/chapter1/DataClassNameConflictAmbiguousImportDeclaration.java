
import java.util.Date;
import java.sql.Date;

//javac DataClassNameConflict.java
public class DataClassNameConflictAmbiguousImportDeclaration {
	
	private Date date; //This line should generate complication error.
}