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
        Process process =  startJavacProcessWithArgumentsFromDirectory(destDir, "DataClassNameConflict.java");
        process.waitFor(10, SECONDS);

        // then
        String result = returnProcessOutputAsString(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Comment about invalid line should be displayed", result.contains("DataClassNameConflict.java:8: error: cannot find symbol")),
                () -> assertTrue("Comment about error should be displayed", result.contains("1 error"))
        );
    }
}
