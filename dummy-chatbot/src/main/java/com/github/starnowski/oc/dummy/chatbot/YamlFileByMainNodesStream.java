package com.github.starnowski.oc.dummy.chatbot;

import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toCollection;

public class YamlFileByMainNodesStream implements ObjectStream<String> {

    private final Charset encoding;
    private InputStreamFactory inputStreamFactory;
    private Queue<String> categoryEntries;

    public YamlFileByMainNodesStream(InputStreamFactory inputStreamFactory, Charset charset) throws IOException {
        this.inputStreamFactory = requireNonNull(inputStreamFactory, "inputStreamFactory must not be null!");
        this.encoding = charset;
        this.reset();
    }

    @Override
    public String read() {
        return categoryEntries.poll();
    }

    @Override
    public void reset() throws IOException {
        Yaml yaml = new Yaml();
        categoryEntries = new LinkedList<>();
        try (InputStream in = inputStreamFactory.createInputStream())
        {
            Iterable<Object> itr = yaml.loadAll(in);
            for (Object o : itr) {
                Map<String, List<String>> map = (Map<String, List<String>>) o;
                categoryEntries = map.entrySet().stream().map(en -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(en.getKey());
                    sb.append("\t");
                    sb.append(en.getValue().stream().map(String::trim).collect(Collectors.joining(" ")));
                    return sb.toString();
                }).collect(toCollection(LinkedList::new));
            }
        }
    }

    @Override
    public void close() {
        // do nothing
    }
}
