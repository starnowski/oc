package com.github.starnowski.oc.oca;

import org.apache.commons.io.FileUtils;

import java.io.*;

import static java.lang.String.format;

public class TestUtils {

    public static void copyDirectory(File srcDir, File destDir) throws IOException {
        FileUtils.copyDirectory(srcDir, destDir, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.getAbsolutePath().endsWith(".class");
            }
        });
    }

    public static String returnProcessOutputAsString(Process process) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ( (line = reader.readLine()) != null) {
            stringBuilder.append(format("%1$s%n", line));
        }
        return stringBuilder.toString();
    }
}
