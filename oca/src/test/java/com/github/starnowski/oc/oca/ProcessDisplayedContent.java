package com.github.starnowski.oc.oca;

public class ProcessDisplayedContent {
    private String command;
    private String output;

    public ProcessDisplayedContent(String command, String output) {
        this.command = command;
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%1$s%n", command));
        sb.append(output);
        return sb.toString();
    }
}
