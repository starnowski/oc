package com.github.starnowski.oc.dummy.chatbot;

import opennlp.tools.doccat.DocumentSample;

class YamlFileByMainNodesStreamTest {

    static DocumentSample[] documentSamples = {
            new DocumentSample("greeting", new String[]{"hi", "hi.", "hello", "how", "are", "you", "?", "hey", ".", "hows", "it", "going", "good", "morning", "good", "evening", "good", "afternoon", "howdy"}),
            new DocumentSample("conversation-continue", new String[]{"ok", "wow", "great", "oh", "is", "it", "?", "oh", "ohh", "Thats", "great", "Good", "Really", "hmm", "lemme", "think", "hm", "hmmm", "hmmmmm"}),
            new DocumentSample("price-inquiry", new String[]{"How", "much", "is", "the", "cost", "?", "What's", "the", "price", "?", "What's", "the", "cost", "?", "How", "much", "is", "price?", "How", "much", "it", "costs", "?", "price", "cost", "money", "how", "much.", "how", "much", "?"}),
            new DocumentSample("product-inquiry", new String[]{"What", "is", "this", "product", "?", "What's", "the", "product", "?", "What", "does", "this", "product", "do", "?", "What", "is", "name", "of", "product", "?", "What", "this", "product", "is", "all", "about?", "Can", "you", "tell", "me", "something", "about", "this", "product", "?", "What", "are", "the", "product", "features", "?", "Tell", "me", "feature", "of", "product."}),
            new DocumentSample("conversation-complete", new String[]{"Thanks", "done", "that's", "all", "thats", "it.", "thats", "it", "I", "am", "done", "Thank", "you", "for", "information", "Thank.", "thanks.", "thank", "you.", "thanks", "nothing", "else", "thats", "it."})
    };
}