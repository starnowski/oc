package com.github.starnowski.oc.oca;

import java.util.List;

public class ProcessWrapper {

    private Process process;
    private List<String> command;

    public ProcessWrapper(Process process, List<String> command) {
        this.process = process;
        this.command = command;
    }

    public Process getProcess() {
        return process;
    }

    public List<String> getCommand() {
        return command;
    }
}
