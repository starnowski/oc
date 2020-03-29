package com.github.starnowski.oc.dummy.chatbot;

import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class YamlFileByMainNodesStreamTest {

    private List<DocumentSample> prepareDocumentSamplesList()
    {
        return Arrays.asList(
                new DocumentSample("greeting", new String[]{"hi", "hi.", "hello", "how", "are", "you", "?", "hey", ".", "hows", "it", "going", "good", "morning", "good", "evening", "good", "afternoon", "howdy"}),
                new DocumentSample("conversation-continue", new String[]{"ok", "wow", "great", "oh", "is", "it", "?", "oh", "ohh", "Thats", "great", "Good", "Really", "hmm", "lemme", "think", "hm", "hmmm", "hmmmmm"}),
                new DocumentSample("price-inquiry", new String[]{"How", "much", "is", "the", "cost", "?", "What's", "the", "price", "?", "What's", "the", "cost", "?", "How", "much", "is", "price?", "How", "much", "it", "costs", "?", "price", "cost", "money", "how", "much.", "how", "much?"}),
                new DocumentSample("product-inquiry", new String[]{"What", "is", "this", "product", "?", "What's", "the", "product", "?", "What", "does", "this", "product", "do", "?", "What", "is", "name", "of", "product", "?", "What", "this", "product", "is", "all", "about?", "Can", "you", "tell", "me", "something", "about", "this", "product", "?", "What", "are", "the", "product", "features", "?", "Tell", "me", "feature", "of", "product."}),
                new DocumentSample("conversation-complete", new String[]{"Thanks", "done", "that's", "all", "thats", "it.", "thats", "it", "I", "am", "done", "Thank", "you", "for", "information", "Thank.", "thanks.", "thank", "you.", "thanks", "nothing", "else", "thats", "it."}));
    }

    @Test
    @DisplayName("The prepared data should match data from test file 'yaml-file-by-main-nodes-stream-test.txt'")
    public void preparedDataShouldMatchDataFromTestResourceFile() throws IOException {
        // given
        ObjectStream<String> lineStream = new PlainTextByLineStream(createInputStreamFactory("yaml-file-by-main-nodes-stream-test.txt"), StandardCharsets.UTF_8);
        ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);
        List<DocumentSample> expectedDocumentSamplesList = new ArrayList<>();

        // when
        DocumentSample currentDocumentSample = sampleStream.read();
        while (currentDocumentSample != null) {
            expectedDocumentSamplesList.add(currentDocumentSample);
            currentDocumentSample = sampleStream.read();
        }

        // then
        assertIterableEquals(expectedDocumentSamplesList, prepareDocumentSamplesList());
    }

    @Test
    @DisplayName("Should return data as same way as the PlainTextByLineStream even if data are store in YAML format file")
    public void shouldReturnDataAsSameWayAsPlainTextByLineStreamType() throws IOException {
        // given
        ObjectStream<String> lineStream = new YamlFileByMainNodesStream(createInputStreamFactory("yaml-file-by-main-nodes-stream-test.txt"), StandardCharsets.UTF_8);
        ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);
        List<DocumentSample> expectedDocumentSamplesList = new ArrayList<>();

        // when
        DocumentSample currentDocumentSample = sampleStream.read();
        while (currentDocumentSample != null) {
            expectedDocumentSamplesList.add(currentDocumentSample);
            currentDocumentSample = sampleStream.read();
        }

        // then
        assertIterableEquals(expectedDocumentSamplesList, prepareDocumentSamplesList());
    }

    private InputStreamFactory createInputStreamFactory(String resource)
    {
        return new InputStreamFactory() {
            @Override
            public InputStream createInputStream() throws IOException {
                return this.getClass().getResourceAsStream(resource);
            }
        };
    }
}