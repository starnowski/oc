package com.github.starnowski.oc.oca.chapter1.st;

import com.github.starnowski.oc.oca.ProcessDisplayedContent;
import com.github.starnowski.oc.oca.ProcessWrapper;
import com.github.starnowski.oc.oca.chapter1.AbstractChapter1Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.github.starnowski.oc.oca.TestUtils.*;
import static com.github.starnowski.oc.oca.TestUtils.returnProcessDisplayedContent;
import static java.io.File.separator;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ConjunctionOperatorTest extends AbstractChapter1Test {

    @Test
    @DisplayName("the 'ConjunctionOperatorTest.java' class should be to compile and display both messages because of single conjunction character")
    public void testQuestion05AnswerETest() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        assertFalse("The file with extension 'class' for type ConjunctionOperatorTest should not exists", destDir.toPath().resolve("st").resolve("ConjunctionOperatorTest.class").toFile().exists());
        String question05AnswerETestPath = "." + separator + "st" + separator + "ConjunctionOperatorTest.java";

        // when
        // javac "./st/exame/Question05AnswerETest.java"
        ProcessWrapper javacProcess =  startJavacProcessWithArgumentsFromDirectory(destDir, question05AnswerETestPath);
        javacProcess.getProcess().waitFor(10, SECONDS);

        //java "st.exame.Question05AnswerETest"
        ProcessWrapper javaProcess =  startJavaProcessWithArgumentsFromDirectory(destDir, "st.ConjunctionOperatorTest");
        javaProcess.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent javacProcessResult = returnProcessDisplayedContent(javacProcess);
        ProcessDisplayedContent javaProcessResult = returnProcessDisplayedContent(javaProcess);
        out.println(javacProcessResult);
        out.println(javaProcessResult);
        assertAll(
                () -> assertTrue("Command was constructed correctly", javacProcessResult.getCommand().endsWith("javac " + question05AnswerETestPath)),
                () -> assertTrue("The file with extension 'class' for type ConjunctionOperatorTest should exists", destDir.toPath().resolve("st").resolve("ConjunctionOperatorTest.class").toFile().exists()),
                () -> assertTrue("Command was constructed correctly for the java execution", javaProcessResult.getCommand().endsWith("java st.ConjunctionOperatorTest")),
                () -> assertTrue("Program should display 'Ivoked returnFalse'", javaProcessResult.getOutput().contains("Ivoked returnFalse")),
                () -> assertTrue("Program should display 'Ivoked returnTrue'", javaProcessResult.getOutput().contains("Ivoked returnTrue")),
                () -> assertTrue("Program should display 'Condition is invalid'", javaProcessResult.getOutput().contains("Condition is invalid")),
                () -> assertFalse("Program should not display 'Condition is valid'", javaProcessResult.getOutput().contains("Condition is valid")),
                () -> assertTrue("Program should display 'The test is over'", javaProcessResult.getOutput().contains("The test is over"))
        );
    }
}
