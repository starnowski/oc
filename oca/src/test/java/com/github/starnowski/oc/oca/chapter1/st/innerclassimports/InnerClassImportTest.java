package com.github.starnowski.oc.oca.chapter1.st.innerclassimports;

import com.github.starnowski.oc.oca.ProcessDisplayedContent;
import com.github.starnowski.oc.oca.ProcessWrapper;
import com.github.starnowski.oc.oca.TestUtils;
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

public class InnerClassImportTest extends AbstractChapter1Test {

    @Test
    @DisplayName("the 'ClassWithImportInnerClass.java' class should not compile because it does not contains correct import declaration for class ClassWithManyInnerClassess, it contains import declaration for ClassWithManyInnerClassess's inner class")
    public void testClassWithInvalidImportDeclaration() throws IOException, InterruptedException {
        // given
        File destDir = returnFileForCopiedTestDirectory();
        String classWithImportInnerClassPath = "." + separator + "st" + separator + "innerclassimports" + separator + "ClassWithImportInnerClass.java";
        String classWithManyInnerClassessPath = "." + separator + "st" + separator + "innerclassimports" + separator + "subpackage" +  separator + "ClassWithManyInnerClassess.java";
        assertAll(
                () -> assertFalse("The file with extension 'class' for type ClassWithImportInnerClass should not exists", destDir.toPath().resolve("st").resolve("innerclassimports").resolve("ClassWithImportInnerClass.class").toFile().exists()),
                () -> assertFalse("The file with extension 'class' for type ClassWithManyInnerClassess should not exists", destDir.toPath().resolve("st").resolve("innerclassimports").resolve("subpackage").resolve("ClassWithManyInnerClassess.class").toFile().exists()),
                () -> assertTrue("Type ClassWithImportInnerClass contains import declaration for inner class InnerClass", TestUtils.readFileContent(destDir, classWithImportInnerClassPath).contains("import st.innerclassimports.subpackage.ClassWithManyInnerClassess.InnerClass;")),
                () -> assertFalse("Type ClassWithImportInnerClass does not contain import declaration for ClassWithManyInnerClassess class", TestUtils.readFileContent(destDir, classWithImportInnerClassPath).contains("import st.innerclassimports.subpackage.ClassWithManyInnerClassess;")),
                () -> assertFalse("Type ClassWithImportInnerClass does not contain import declaration for subpackage package", TestUtils.readFileContent(destDir, classWithImportInnerClassPath).contains("import st.innerclassimports.subpackage.*;")),
                () -> assertTrue("Type ClassWithManyInnerClassess contains InnerClass inner class", TestUtils.readFileContent(destDir, classWithManyInnerClassessPath).contains("public class InnerClass {}"))
        );

        // when
        ProcessWrapper process =  startJavacProcessWithArgumentsFromDirectory(destDir.toPath().toFile(), classWithImportInnerClassPath, classWithManyInnerClassessPath);
        process.getProcess().waitFor(10, SECONDS);

        // then
        ProcessDisplayedContent result = returnProcessDisplayedContent(process);
        out.println(result);
        assertAll(
                () -> assertTrue("Command was constructed correctly", result.getCommand().endsWith("javac " + classWithImportInnerClassPath + " " + classWithManyInnerClassessPath)),
                () -> assertTrue("Comment about invalid line should be displayed", result.getOutput().contains("ClassWithImportInnerClass.java:14: error: package ClassWithManyInnerClassess does not exist")),
                () -> assertTrue("Comment about error should be displayed", result.getOutput().contains("1 error"))
        );
    }
}
