package com.github.starnowski.oc.oca.chapter1.st;

import com.github.starnowski.oc.oca.ProcessDisplayedContent;
import com.github.starnowski.oc.oca.ProcessWrapper;
import com.github.starnowski.oc.oca.chapter1.AbstractChapter1Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.github.starnowski.oc.oca.TestUtils.returnProcessDisplayedContent;
import static com.github.starnowski.oc.oca.TestUtils.startJavacProcessWithArgumentsFromDirectory;
import static java.io.File.separator;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class InvalidVariableOrderInitializationTest extends AbstractChapter1Test {

    @Test
    @DisplayName("the 'InvalidVariableOrderInitializationTest.java' class should not compile'")
    public void testNumericTypesShouldCompilee() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        assertFalse("The file with extension 'class' for type InvalidVariableOrderInitializationTest should not exists", destDir.toPath().resolve("st").resolve("InvalidVariableOrderInitializationTest.class").toFile().exists());

        // when
        String javaPath = "." + separator + "st" + separator + "InvalidVariableOrderInitializationTest.java";
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir.toPath().toFile(), javaPath);
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac " + javaPath)),
                () -> assertTrue("Comment about invalid line should be displayed", result.getOutput().contains("InvalidVariableOrderInitializationTest.java:12: error: illegal forward reference")),
                () -> assertTrue("Comment about error should be displayed", result.getOutput().contains("1 error"))
        );
    }
}
