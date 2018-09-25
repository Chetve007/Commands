package org.itstep;

import java.io.Writer;
import java.util.List;

public class SortNumbersCommandFactory implements NumberCommandFactory {
    private final Writer writer;

    public SortNumbersCommandFactory(Writer writer) {
        this.writer = writer;
    }

    @Override
    public Command construct(List<Integer> lst) {
        return new SortNumbersCommand(lst,writer);
    }
}
