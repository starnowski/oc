package com.github.starnowski.oc.dummy.chatbot;

import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

public class YamlFileByMainNodesStream implements ObjectStream<String> {

    private final Charset encoding;
    private InputStreamFactory inputStreamFactory;

    public YamlFileByMainNodesStream(InputStreamFactory inputStreamFactory, Charset charset) throws IOException {
        this.inputStreamFactory = (InputStreamFactory) Objects.requireNonNull(inputStreamFactory, "inputStreamFactory must not be null!");
        this.encoding = charset;
        this.reset();
    }

    @Override
    public String read() throws IOException {
        return null;
    }
}
