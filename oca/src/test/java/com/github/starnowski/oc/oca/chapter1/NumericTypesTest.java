package com.github.starnowski.oc.oca.chapter1;

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

public class NumericTypesTest extends AbstractChapter1Test {

    @Test
    @DisplayName("the 'NumericTypes.java' class should be to compile'")
    public void testNumericTypesShouldCompilee() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        assertFalse("The file with extension 'class' for type NumericTypes should not exists", destDir.toPath().resolve("NumericTypes.class").toFile().exists());

        // when
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir, "NumericTypes.java");
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac NumericTypes.java")),
                () -> assertTrue("The file with extension 'class' for type NumericTypes should exists", destDir.toPath().resolve("NumericTypes.class").toFile().exists())
        );
    }
}
