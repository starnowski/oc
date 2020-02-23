package com.github.starnowski.oc.oca.chapter1;

import com.github.starnowski.oc.oca.AbstractChapterTest;
import com.github.starnowski.oc.oca.ProcessDisplayedContent;
import com.github.starnowski.oc.oca.ProcessWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.github.starnowski.oc.oca.TestUtils.returnProcessDisplayedContent;
import static com.github.starnowski.oc.oca.TestUtils.startJavacProcessWithArgumentsFromDirectory;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ClassNameConflictChapter1Test extends AbstractChapterTest {

    @Test
    @DisplayName("the 'DataClassNameConflictAmbiguousImportDeclaration.java' class should not be to compile because the import for 'Date' type is ambiguous")
    public void testShouldGenerateCompilationErrorWhenTheDateTypeImportDeclarationIsAmbiguous() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();

        // when
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir, "DataClassNameConflictAmbiguousImportDeclaration.java");
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac DataClassNameConflictAmbiguousImportDeclaration.java")),
                () -> assertTrue("Comment about invalid line should be displayed", result.getOutput().contains("DataClassNameConflictAmbiguousImportDeclaration.java:3: error: a type with the same simple name is already defined by the single-type-import of Date")),
                () -> assertTrue("Comment about error should be displayed", result.getOutput().contains("1 error"))
        );
    }

    @Test
    @DisplayName("the 'DataClassNameConflictAmbiguousImportWithWildcardDeclaration.java' class should not be to compile because the import declaration with wildcard for 'Date' type is ambiguous")
    public void testShouldGenerateCompilationErrorWhenTheDateTypeImportDeclarationWithWildcardIsAmbiguous() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();

        // when
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir, "DataClassNameConflictAmbiguousImportWithWildcardDeclaration.java");
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac DataClassNameConflictAmbiguousImportWithWildcardDeclaration.java")),
                () -> assertTrue("Comment about invalid line should be displayed", result.getOutput().contains("both class java.sql.Date in java.sql and class java.util.Date in java.util match")),
                () -> assertTrue("Comment about error should be displayed", result.getOutput().contains("1 error"))
        );
    }

    @Test
    @DisplayName("the 'DataClassNameWithoutConflict.java' class should be to compile because the import for 'Date' type is unequivocal")
    public void testDataClassNameWithoutConflictTypeShouldBeAbleToCompile() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        assertFalse("The file with extension 'class' for type DataClassNameWithoutConflict should not exists", destDir.toPath().resolve("DataClassNameWithoutConflict.class").toFile().exists());

        // when
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir, "DataClassNameWithoutConflict.java");
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac DataClassNameWithoutConflict.java")),
                () -> assertTrue("The file with extension 'class' for type DataClassNameWithoutConflict should exists", destDir.toPath().resolve("DataClassNameWithoutConflict.class").toFile().exists())
        );
    }

    @Test
    @DisplayName("the 'DataClassNameWithoutConflictWithSingleImportDeclarationWildcard.java' class should be to compile because the import for 'Date' type is unequivocal even when there is single import declaration with wildcard")
    public void testDataClassNameWithoutConflictTypeShouldBeAbleToCompileEvenWithSingleImportDeclarationWithWildcard() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        assertFalse("The file with extension 'class' for type DataClassNameWithoutConflict should not exists", destDir.toPath().resolve("DataClassNameWithoutConflictWithSingleImportDeclarationWildcard.class").toFile().exists());

        // when
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir, "DataClassNameWithoutConflictWithSingleImportDeclarationWildcard.java");
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac DataClassNameWithoutConflictWithSingleImportDeclarationWildcard.java")),
                () -> assertTrue("The file with extension 'class' for type DataClassNameWithoutConflictWithSingleImportDeclarationWildcard should exists", destDir.toPath().resolve("DataClassNameWithoutConflictWithSingleImportDeclarationWildcard.class").toFile().exists())
        );
    }

    @Override
    protected String getChapterDirectoryName() {
        return "chapter1";
    }
}
