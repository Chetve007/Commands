package org.itstep;

import java.io.File;
import java.util.List;

public class SaveNumbersCommandFactory implements NumberCommandFactory {
    private final File file;

    public SaveNumbersCommandFactory(File file) {
        this.file = file;
    }

    @Override
    public Command construct(List<Integer> lst) {
        return new SaveNumbersCommand(lst,file);
    }
}
