package com.github.starnowski.oc.oca.chapter1;

import com.github.starnowski.oc.oca.ProcessDisplayedContent;
import com.github.starnowski.oc.oca.ProcessWrapper;
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

public class InvalidImportDeclarationWithWildCardTest extends AbstractChapter1Test {

    @Test
    @DisplayName("the 'AquariumVisitorAnswerE.java' class should be to compile'")
    public void testNumericTypesShouldCompilee() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        assertFalse("The file with extension 'class' for type AquariumVisitorAnswerE should not exists", destDir.toPath().resolve("question5").resolve("visitor").resolve("AquariumVisitorAnswerE.class").toFile().exists());
        assertFalse("The file with extension 'class' for type Jelly should not exists", destDir.toPath().resolve("question5").resolve("aquarium").resolve("jellies").resolve("Jelly.class").toFile().exists());
        assertFalse("The file with extension 'class' for type Tank should not exists", destDir.toPath().resolve("question5").resolve("aquarium").resolve("Tank.class").toFile().exists());

        // when
        String aquariumVisitorAnswerEPath = "." + separator + "visitor" + separator + "AquariumVisitorAnswerE.java";
        String jellyPath = "." + separator + "aquarium" + separator + "jellies" + separator + "Jelly.java";
        String tankPath = "." + separator + "aquarium" + separator + "Tank.java";
        // javac "./visitor/AquariumVisitorAnswerE.java" "./aquarium/jellies/Jelly.java"  "./aquarium/Tank.java"
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir.toPath().resolve("question5").toFile(), aquariumVisitorAnswerEPath, jellyPath, tankPath);
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac " + aquariumVisitorAnswerEPath + " " + jellyPath + " " + tankPath)),
                () -> assertTrue("Comment about invalid line should be displayed", result.getOutput().contains("AquariumVisitorAnswerE.java:9: error: cannot find symbol")),
                () -> assertTrue("Comment about error should be displayed", result.getOutput().contains("1 error"))
        );
    }
}