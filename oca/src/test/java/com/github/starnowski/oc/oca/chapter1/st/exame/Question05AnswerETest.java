package com.github.starnowski.oc.oca.chapter1.st.exame;

import com.github.starnowski.oc.oca.ProcessDisplayedContent;
import com.github.starnowski.oc.oca.ProcessWrapper;
import com.github.starnowski.oc.oca.chapter1.AbstractChapter1Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.github.starnowski.oc.oca.TestUtils.*;
import static java.io.File.separator;
import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Question05AnswerETest extends AbstractChapter1Test {

    @Test
    @DisplayName("the 'Question05AnswerETest.java' class should be to compile and display '2' as output")
    public void testQuestion05AnswerETest() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        assertFalse("The file with extension 'class' for type Question05AnswerETest should not exists", destDir.toPath().resolve("st").resolve("exame").resolve("Question05AnswerETest.class").toFile().exists());
        String question05AnswerETestPath = "." + separator + "st" + separator + "exame" + separator + "Question05AnswerETest.java";

        // when
        // javac "./st/exame/Question05AnswerETest.java"
        ProcessWrapper javacProcess =  startJavacProcessWithArgumentsFromDirectory(destDir, question05AnswerETestPath);
        javacProcess.getProcess().waitFor(10, SECONDS);

        //java "st.exame.Question05AnswerETest"
        ProcessWrapper javaProcess =  startJavaProcessWithArgumentsFromDirectory(destDir, "st.exame.Question05AnswerETest");
        javaProcess.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent javacProcessResult = returnProcessDisplayedContent(javacProcess);
        ProcessDisplayedContent javaProcessResult = returnProcessDisplayedContent(javaProcess);
        out.println(javacProcessResult);
        out.println(javaProcessResult);
        assertAll(
                () -> assertTrue("Command was constructed correctly", javacProcessResult.getCommand().endsWith("javac " + question05AnswerETestPath)),
                () -> assertTrue("The file with extension 'class' for type Question05AnswerETest should exists", destDir.toPath().resolve("st").resolve("exame").resolve("Question05AnswerETest.class").toFile().exists()),
                () -> assertTrue("Command was constructed correctly for the java execution", javaProcessResult.getCommand().endsWith("java st.exame.Question05AnswerETest")),
                () -> assertTrue("Program should display 'count:2'", javaProcessResult.getOutput().contains("count:2"))
        );
    }

}
