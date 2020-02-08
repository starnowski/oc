package com.github.starnowski.oc.oca;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static com.github.starnowski.oc.oca.TestUtils.*;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Chapter1Test {

    @TempDir
    Path tempDir;

    @Test
    @DisplayName("the 'DataClassNameConflict.java' class should not be to compile because the import for 'Date' type is unambiguous")
    public void testShouldGenerateCompilationErrorWhenTheDateTypeReferenceIsUnambiguous() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory(tempDir, "chapter1");

        // when
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir, "DataClassNameConflict.java");
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac DataClassNameConflict.java")),
                () -> assertTrue("Comment about invalid line should be displayed", result.getOutput().contains("DataClassNameConflict.java:8: error: cannot find symbol")),
                () -> assertTrue("Comment about error should be displayed", result.getOutput().contains("1 error"))
        );
    }

    @Test
    @DisplayName("the 'DataClassNameWithoutConflict.java' class should be to compile because the import for 'Date' type is ambiguous")
    public void testDataClassNameWithoutConflictTypeShouldBeAbleToCompile() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory(tempDir, "chapter1");
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
}
