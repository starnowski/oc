package com.github.starnowski.oc.oca;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import static com.github.starnowski.oc.oca.TestUtils.copyDirectory;
import static java.io.File.separator;
import static java.lang.System.getenv;
import static java.lang.System.out;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Chapter1Test {

    @TempDir
    Path tempDir;

    @Test
    @DisplayName("the 'DataClassNameConflict.java' class should not be to compile because the import for 'Date' type is unambiguous")
    public void testShouldGenerateCompilationErrorWhenTheDateTypeReferenceIsUnambiguous() throws IOException, InterruptedException {
        // given
        ClassLoader classLoader = getClass().getClassLoader();
        File srcDir = new File(classLoader.getResource("chapter1").getFile());
        File destDir = tempDir.resolve("chapter1").toFile();
        copyDirectory(srcDir, destDir);

        // when
        String javaHome = getenv("JAVA_HOME");
        String javacPath = javaHome + separator + "bin" + separator + "javac";
        ProcessBuilder builder = new ProcessBuilder( javacPath, "DataClassNameConflict.java");
        builder.directory( destDir.toPath().toFile().getAbsoluteFile() ); // this is where you set the root folder for the executable to run with
        builder.redirectErrorStream(true);
        Process process =  builder.start();
        process.waitFor(10, TimeUnit.SECONDS);

        // then
        String result = TestUtils.returnProcessOutputAsString(process);
        out.println(result);
        assertAll(
                () -> assertTrue("File should exist", result.contains("DataClassNameConflict.java:8: error: cannot find symbol")),
                () -> assertTrue("File should exist", result.contains("1 error"))
        );
    }
}
