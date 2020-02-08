package com.github.starnowski.oc.oca;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import static java.io.File.separator;
import static java.lang.System.getenv;
import static java.lang.System.out;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Chapter1Test {

    @TempDir
    Path tempDir;

    @Test
    public void testShouldGenerateCompilationErrorWhenTheDateTypeReferenceIsUnambiguous() throws IOException, InterruptedException {
        // given
        ClassLoader classLoader = getClass().getClassLoader();
        File srcDir = new File(classLoader.getResource("chapter1").getFile());
        File destDir = tempDir.resolve("chapter1").toFile();
        FileUtils.copyDirectory(srcDir, destDir, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.getAbsolutePath().endsWith(".class");
            }
        });

        // when
        String javaHome = getenv("JAVA_HOME");
        String javacPath = javaHome + separator + "bin" + separator + "javac";
        ProcessBuilder builder = new ProcessBuilder( javacPath, "DataClassNameConflict.java");
        builder.directory( destDir.toPath().toFile().getAbsoluteFile() ); // this is where you set the root folder for the executable to run with
        builder.redirectErrorStream(true);
        Process process =  builder.start();
        process.waitFor(10, TimeUnit.SECONDS);

        // then
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ( (line = reader.readLine()) != null) {
            stringBuilder.append(String.format("%1$s%n", line));
        }
        String result = stringBuilder.toString();
        out.println(result);
        assertAll(
                () -> assertTrue("File should exist", result.contains("DataClassNameConflict.java:8: error: cannot find symbol")),
                () -> assertTrue("File should exist", result.contains("1 error"))
        );
    }
}
