package com.github.starnowski.oc.oca;

import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public abstract class AbstractChapterTest {

    @TempDir
    protected Path tempDir;

    protected File returnFileForCopiedTestDirectory() throws IOException {
        return TestUtils.returnFileForCopiedTestDirectory(tempDir, getChapterDirectoryName());
    }

    protected abstract String getChapterDirectoryName();
}
