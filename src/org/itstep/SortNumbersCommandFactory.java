package org.itstep;

import java.util.List;

public class SortNumbersCommandFactory implements NumberCommandFactory {
    @Override
    public Command construct(List<Integer> lst) {
        return new SortNumbersCommand(lst);
    }
}
