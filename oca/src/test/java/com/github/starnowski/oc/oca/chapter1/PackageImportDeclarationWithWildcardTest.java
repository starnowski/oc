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

public class PackageImportDeclarationWithWildcardTest extends AbstractChapter1Test {

    @Test
    @DisplayName("the 'PackageDependecieFailedTest.java' class should be to not compile because the 'ProgramBB' type is in subpackage'")
    public void testPackageDependecieFailedTestShouldNotCompileBecauseProgramBBTypeIsInSubPackage() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();

        // when
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir, "PackageDependecieFailedTest.java");
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac PackageDependecieFailedTest.java")),
                () -> assertTrue("Comment about invalid line should be displayed", result.getOutput().contains("PackageDependecieFailedTest.java:7: error: cannot find symbol")),
                () -> assertTrue("Comment about error should be displayed", result.getOutput().contains("1 error"))
        );
    }

    @Test
    @DisplayName("the 'PackageDependecieSuccessTest.java' class should be to compile because all imports declaration are correct'")
    public void testPackageDependecieSuccessTestShouldCompilee() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        assertFalse("The file with extension 'class' for type PackageDependecieSuccessTest should not exists", destDir.toPath().resolve("PackageDependecieSuccessTest.class").toFile().exists());

        // when
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir, "PackageDependecieSuccessTest.java");
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac PackageDependecieSuccessTest.java")),
                () -> assertTrue("The file with extension 'class' for type PackageDependecieSuccessTest should exists", destDir.toPath().resolve("PackageDependecieSuccessTest.class").toFile().exists())
        );
    }
}
