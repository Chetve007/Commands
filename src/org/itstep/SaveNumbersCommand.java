package org.itstep;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class SaveNumbersCommand implements Command {
    private final List<Integer> lst;
    private final File file;

    public SaveNumbersCommand(List<Integer> lst, File file) {
        this.lst  = lst;
        this.file = file;
    }

    @Override
    public void exec() throws Exception {
        try(PrintWriter printer = new PrintWriter(file)) {
            for (Integer i : lst)
                printer.println(i);
        }
    }
}
