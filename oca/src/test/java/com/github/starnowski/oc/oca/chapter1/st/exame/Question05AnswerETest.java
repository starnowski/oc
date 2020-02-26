package com.github.starnowski.oc.oca.chapter1.st.exame;

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

public class Question05AnswerETest extends AbstractChapter1Test {
    
    @Test
    @DisplayName("the 'Question05AnswerETest.java' class should be to compile and TODO")
    public void testNumericTypesShouldCompilee() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        assertFalse("The file with extension 'class' for type Question05AnswerETest should not exists", destDir.toPath().resolve("st").resolve("exame").resolve("Question05AnswerETest.class").toFile().exists());
        String question05AnswerETestPath = "." + separator + "st" + separator + "exame" + separator + "Question05AnswerETest.java";

        // when
        // javac "./st/exame/Question05AnswerETest.java"
        //java "st.exame.Question05AnswerETest"
        ProcessWrapper javacProcess =  startJavacProcessWithArgumentsFromDirectory(destDir, question05AnswerETestPath);
        javacProcess.getProcess().waitFor(10, SECONDS);
        //TODO java process

        // then
        ProcessDisplayedContent javacProcessResult = returnProcessDisplayedContent(javacProcess);
        out.println(javacProcessResult);
        assertAll(
                () -> assertTrue("Command was constructed correctly", javacProcessResult.getCommand().endsWith("javac " + question05AnswerETestPath)),
                () -> assertTrue("The file with extension 'class' for type Question05AnswerETest should exists", destDir.toPath().resolve("st").resolve("exame").resolve("Question05AnswerETest.class").toFile().exists())
        );
    }

}
