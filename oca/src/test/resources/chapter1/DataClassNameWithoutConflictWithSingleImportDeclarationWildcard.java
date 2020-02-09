
import java.sql.Date;
import java.util.*;

/**
 * Compilation should be successful even when the import declaration for package "java.util" contains a wildcard.<br/>
 * Fortunately the import declaration for type "java.sql.Date" is unequivocal.<br/>
 *  javac DataClassNameWithoutConflictWithSingleImportDeclarationWildcard.java
*/
public class DataClassNameWithoutConflictWithSingleImportDeclarationWildcard {
	
	private Date date;
}