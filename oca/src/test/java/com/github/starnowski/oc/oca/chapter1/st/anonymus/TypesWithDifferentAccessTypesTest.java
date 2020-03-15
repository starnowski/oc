package com.github.starnowski.oc.oca.chapter1.st.anonymus;

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

public class TypesWithDifferentAccessTypesTest extends AbstractChapter1Test {

    @Test
    @DisplayName("the 'PublicClass.java' class should not compile, because it contains types with private and protected modifiers")
    public void testNumericTypesShouldCompilee() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        assertFalse("The file with extension 'class' for type PublicClass should not exists", destDir.toPath().resolve("st").resolve("anonymus").resolve("PublicClass.class").toFile().exists());

        // when
        String javaPath = "." + separator + "st" + separator + "anonymus" + separator + "PublicClass.java";
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir.toPath().toFile(), javaPath);
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac " + javaPath)),
                () -> assertTrue("Comment about invalid line should be displayed", result.getOutput().contains("PublicClass.java:61: error: modifier protected not allowed here")),
                () -> assertTrue("Comment about invalid line should be displayed", result.getOutput().contains("PublicClass.java:69: error: modifier private not allowed here")),
                () -> assertTrue("Comment about errors should be displayed", result.getOutput().contains("2 errors"))
        );
    }
}